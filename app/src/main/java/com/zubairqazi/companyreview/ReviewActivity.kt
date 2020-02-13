
package com.zubairqazi.companyreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val review = intent.getParcelableExtra<Review>("Review")

        val employerName = findViewById<TextView>(R.id.textView_employer)
        val jobTitle = findViewById<TextView>(R.id.textView_jobTitle)
        val location = findViewById<TextView>(R.id.textView_location)
        val overall = findViewById<TextView>(R.id.textView_overall)
        val employmentStatus = findViewById<TextView>(R.id.textView_employmentStatus)
        val pros = findViewById<TextView>(R.id.textView_pros)
        val cons = findViewById<TextView>(R.id.textView_cons)
        val reviewDateTime = findViewById<TextView>(R.id.textView_reviewDateTime)
        val advice = findViewById<TextView>(R.id.textView_advice)
        val compensationAndBenefitsRating = findViewById<TextView>(R.id.textView_compBenRatings)
        val cultureAndValuesRating = findViewById<TextView>(R.id.textView_cultValueRatings)
        val careerOpportunitiesRating = findViewById<TextView>(R.id.textView_careerOppRatings)
        val ceoRating = findViewById<TextView>(R.id.textView_ceoRating)
        val seniorLeadershipRating = findViewById<TextView>(R.id.textView_seniorLeadRating)
        val overallRating = findViewById<TextView>(R.id.textView_overallRating)
        val helpfulCount = findViewById<TextView>(R.id.textView_helpfulRating)
        val notHelpfulCount = findViewById<TextView>(R.id.textView_notHelpfulRating)
        val workLifeBalanceRating = findViewById<TextView>(R.id.textView_workBalRating)
        val sqLogoUrl = findViewById<ImageView>(R.id.image_companyLogo)

        // Load company logo from url into ImageView
        Picasso.get().load(review.sqLogoUrl).into(sqLogoUrl)

        employerName.text = review.employerName
        jobTitle.text = review.jobTitle
        location.text = review.location
        overall.text = review.overall
        pros.text = "Pros: \n" + review.pros + "\n"
        cons.text = "Cons: \n" + review.cons + "\n"
        advice.text = "Advice: \n" + review.advice + "\n"
        compensationAndBenefitsRating.text = "compensationAndBenefitsRating: " + review.compensationAndBenefitsRating
        cultureAndValuesRating.text = "cultureAndValuesRating: " + review.cultureAndValuesRating
        careerOpportunitiesRating.text = "careerOpportunitiesRating: " + review.careerOpportunitiesRating
        ceoRating.text = "ceoRating: " + review.ceoRating
        seniorLeadershipRating.text = "seniorLeadershipRating: " + review.seniorLeadershipRating
        overallRating.text = "overallRating: " + review.overallRating
        helpfulCount.text = "helpfulCount: " + review.helpfulCount
        notHelpfulCount.text = "notHelpfulCount: " + review.notHelpfulCount
        workLifeBalanceRating.text = "workLifeBalanceRating: " +review.workLifeBalanceRating
    }
}
