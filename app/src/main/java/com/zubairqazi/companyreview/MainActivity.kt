package com.zubairqazi.companyreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    var reviews: MutableList<Review> = ArrayList()
    var salaries: MutableList<Salary> = ArrayList()
    var interviews: MutableList<Interview> = ArrayList()
    var numItems = reviews.size + salaries.size + interviews.size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        fetchJSON()
        Thread.sleep(1000)
        val homeFeed = HomeFeed(reviews, salaries, interviews, numItems)

        runOnUiThread {
            recyclerView_main.adapter = MainAdapter(homeFeed)
        }

    }

    fun fetchJSON() {
        println("Attempting to fetch JSON")
        val url = "https://raw.githubusercontent.com/vikrama/feed-json-sample/master/feed.json"

        val request = Request.Builder()
            .header("Authorization", "7CACB198ED14ABB2EB1D7C1A48CD592E")
            .url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val json = JSONObject(body)
                val response = json.getJSONObject("response")
                val results = response.getJSONArray("results")

                val gson = GsonBuilder().create()

                for (i in 0 until results.length()) {
                    val result = results.getJSONObject(i)

                    if (result.getString("type") == "REVIEW_RESULT") {
                        val review = gson.fromJson(result.getJSONObject("review").toString(),
                            Review::class.java)
                        review.type = "Review"
                        try {
                            reviews.add(review)
                            numItems++
                        }
                        catch (e: Exception) {
                            println(e)
                        }
                    }
                    else if (result.getString("type") == "INTERVIEW_RESULT") {
                        val interview = gson.fromJson(result.getJSONObject("interview")
                            .toString(), Interview::class.java)
                        interview.type = "Interview"
                        try {
                            interviews.add(interview)
                            numItems++
                        }
                        catch (e: Exception) {
                            println(e)
                        }
                    }
                    else if (result.getString("type") == "SALARY_RESULT") {
                        val salary = gson.fromJson(result.getJSONObject("salary").toString()
                            , Salary::class.java)
                        salary.empBasePay = result.getJSONObject("salary")
                            .getJSONObject("basePay").getDouble("amount").toString()
                        salary.meanEmpBasePay = result.getJSONObject("salary")
                            .getJSONObject("meanBasePay").getDouble("amount").toString()
                        salary.type = "Salary"
                        try {
                            salaries.add(salary)
                            numItems++
                        }
                        catch (e: Exception) {
                            println(e)
                        }
                    }
                }

            }

            override fun onFailure(call: Call, e: IOException) {
                println(e.toString())
                println("Failed to Execute")
            }
        })

    }
}
