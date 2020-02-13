package com.zubairqazi.companyreview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_row.view.*
import java.lang.Exception

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolderClass>() {

    var count_reviews = homeFeed.reviews.size
    var count_interviews = homeFeed.interviews.size
    var count_salaries = homeFeed.salaries.size

    // Necessary for outputting model objects
    var offset1 = homeFeed.reviews.size
    var offset2 = homeFeed.reviews.size + homeFeed.interviews.size

    lateinit var intent: Intent

    // Number of Items
    override fun getItemCount(): Int {
        // Waiting for homeFeed to be populated by GSON
        // return homeFeed.numItems
        return homeFeed.numItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderClass {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_row, parent, false)
        return CustomViewHolderClass(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolderClass, position: Int) {

        val companyLogo = holder.view.image_companyLogo

        // Outputs Reviews, Interviews, and then Salaries
        try {
            if (count_reviews > 0) {
                holder.view.textView_company?.text = homeFeed.reviews[position].employerName
                holder.view.textView_type?.text = "Review"

                Picasso.get().load(homeFeed.reviews[position].sqLogoUrl).into(companyLogo)

                count_reviews -= 1

                holder.view.setOnClickListener {
                    intent = Intent(it.context, ReviewActivity::class.java)
                        .putExtra("Review",  homeFeed.reviews[position])
                    startActivity(it.context, intent, null)
                }
            }

            if (count_interviews > 0 && count_reviews == 0) {
                holder.view.textView_company?.text= homeFeed.interviews[position - offset1].employerName
                holder.view.textView_type?.text = "Interview"

                Picasso.get().load(homeFeed.interviews[position - offset1].sqLogoUrl).into(companyLogo)

                count_interviews -= 1

                holder.view.setOnClickListener {
                    intent = Intent(it.context, InterviewActivity::class.java)
                        .putExtra("Interview",  homeFeed.interviews[position - offset1])
                    startActivity(it.context, intent, null)
                }

            }

            if (count_salaries > 0 && count_reviews == 0 && count_interviews == 0 )  {
                holder.view.textView_company?.text= homeFeed.salaries[position - offset2].employerName
                holder.view.textView_type?.text = "Salary"

                Picasso.get().load(homeFeed.salaries[position - offset2].sqLogoUrl).into(companyLogo)

                count_salaries -= 1

                holder.view.setOnClickListener {
                    intent = Intent(it.context, SalaryActivity::class.java)
                        .putExtra("Salary", homeFeed.salaries[position - offset2])
                    startActivity(it.context, intent, null)
                }
            }
        }
        catch (e: Exception) {
            println(e)
        }

    }
}

class CustomViewHolderClass(val view: View) : RecyclerView.ViewHolder(view) {

}