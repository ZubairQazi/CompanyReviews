package com.zubairqazi.companyreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class SalaryActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salary)

        val salary = intent.getParcelableExtra<Salary>("Salary")

        val employerName = findViewById<TextView>(R.id.textView_employer)
        val jobTitle= findViewById<TextView>(R.id.textView_jobTitle)
        val location = findViewById<TextView>(R.id.textView_location)
        val empBasePay1 = findViewById<TextView>(R.id.textView_basePay1)
        val empBasePay2 = findViewById<TextView>(R.id.textView_basePay2)
        val employmentStatus = findViewById<TextView>(R.id.textView_employmentStatus)
        val meanEmpBasePay = findViewById<TextView>(R.id.textView_meanBasePay)
        val reviewDateTime = findViewById<TextView>(R.id.textView_reviewDateTime)
        val payPeriod = findViewById<TextView>(R.id.textView_payPeriod)
        val sqLogoUrl = findViewById<ImageView>(R.id.image_companyLogo)

        // Load company logo from url into ImageView
        Picasso.get().load(salary.sqLogoUrl).into(sqLogoUrl)

        employerName.text = salary.employerName
        jobTitle.text = salary.jobTitle
        location.text = salary.location
        empBasePay1.text = "$" + salary.empBasePay
        empBasePay2.text = "Base Pay: $" + salary.empBasePay
        employmentStatus.text = "Employment Status: " + salary.employmentStatus
        meanEmpBasePay.text = "Mean Base Pay: " + salary.meanEmpBasePay
        reviewDateTime.text = "Date Submitted: " + salary.reviewDateTime
        payPeriod.text = "Pay Period: " + salary.payPeriod

    }
}
