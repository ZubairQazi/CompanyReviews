package com.zubairqazi.companyreview

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

// MODEL OBJECTS

class HomeFeed(val reviews: MutableList<Review>, val salaries: MutableList<Salary>,
               val interviews: MutableList<Interview>, val numItems: Int)

class Review(
    val employerName: String?,
    val jobTitle: String?,
    val location: String?,
    val overall: String?,
    val pros: String?,
    val cons: String?,
    val ceoApproval: String?,
    val advice: String?,
    val compensationAndBenefitsRating: String?,
    val cultureAndValuesRating: String?,
    val careerOpportunitiesRating: String?,
    val ceoRating: String?,
    val seniorLeadershipRating: String?,
    val overallRating: String?,
    val helpfulCount: String?,
    val notHelpfulCount: String?,
    val workLifeBalanceRating: String?,
    val sqLogoUrl: String,
    var type: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(employerName)
        writeString(jobTitle)
        writeString(location)
        writeString(overall)
        writeString(pros)
        writeString(cons)
        writeString(ceoApproval)
        writeString(advice)
        writeString(compensationAndBenefitsRating)
        writeString(cultureAndValuesRating)
        writeString(careerOpportunitiesRating)
        writeString(ceoRating)
        writeString(seniorLeadershipRating)
        writeString(overallRating)
        writeString(helpfulCount)
        writeString(notHelpfulCount)
        writeString(workLifeBalanceRating)
        writeString(sqLogoUrl)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Review> = object : Parcelable.Creator<Review> {
            override fun createFromParcel(source: Parcel): Review = Review(source)
            override fun newArray(size: Int): Array<Review?> = arrayOfNulls(size)
        }
    }
}


class Salary(
    val employerName: String?,
    val jobTitle: String?,
    val location: String?,
    var empBasePay: String?,
    val employmentStatus: String?,
    var meanEmpBasePay: String?,
    val reviewDateTime: String?,
    val payPeriod: String?,
    val sqLogoUrl: String,
    var type: String) : Parcelable {

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(employerName)
        writeString(jobTitle)
        writeString(location)
        writeString(empBasePay)
        writeString(employmentStatus)
        writeString(meanEmpBasePay)
        writeString(reviewDateTime)
        writeString(payPeriod)
        writeString(sqLogoUrl)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Salary> = object : Parcelable.Creator<Salary> {
            override fun createFromParcel(source: Parcel): Salary = Salary(source)
            override fun newArray(size: Int): Array<Salary?> = arrayOfNulls(size)
        }
    }
}

class Interview(
    val employerName: String?,
    val interviewDate: String?,
    val interviewSource: String?,
    val jobTitle: String?,
    val location: String?,
    val outcome: String?,
    val processAnswer: String?,
    val processDifficulty: String?,
    val processOverallExperience: String?,
    val sqLogoUrl: String,
    var type: String) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(employerName)
        writeString(interviewDate)
        writeString(interviewSource)
        writeString(jobTitle)
        writeString(location)
        writeString(outcome)
        writeString(processAnswer)
        writeString(processDifficulty)
        writeString(processOverallExperience)
        writeString(sqLogoUrl)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Interview> = object : Parcelable.Creator<Interview> {
            override fun createFromParcel(source: Parcel): Interview = Interview(source)
            override fun newArray(size: Int): Array<Interview?> = arrayOfNulls(size)
        }
    }
}