package com.zubairqazi.companyreview

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class InterviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview)

        val interview = intent.getParcelableExtra<Interview>("Interview")

        val employerName = findViewById<TextView>(R.id.textView_employer)
//        val interviewDate = findViewById<TextView>(R.id.interView)
//        val interviewSource: String?,
        val jobTitle = findViewById<TextView>(R.id.textView_jobTitle)
        val location = findViewById<TextView>(R.id.textView_location)
        val outcome = findViewById<TextView>(R.id.textView_outcome)
        val processAnswer = findViewById<TextView>(R.id.textView_processAnswer)
        val processDifficulty = findViewById<TextView>(R.id.textView_processDiff)
        val processOverallExperience = findViewById<TextView>(R.id.textView_overallExperience)
        val sqLogoUrl = findViewById<ImageView>(R.id.image_companyLogo)

        Picasso.get().load(interview.sqLogoUrl).into(sqLogoUrl)

        employerName.text = interview.employerName
        jobTitle.text = interview.jobTitle
        location.text = interview.location
        outcome.text = "Outcome: " + interview.outcome
        processAnswer.text = "Process: \n" + interview.processAnswer
        processDifficulty.text = "Process Difficulty: \n" + interview.processDifficulty
        processOverallExperience.text = "Overall Experience: \n" + interview.processOverallExperience

    }
}
