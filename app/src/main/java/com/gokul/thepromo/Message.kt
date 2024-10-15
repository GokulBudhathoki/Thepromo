package com.gokul.thepromo

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val startDate: String?,
    val immediateStart: Boolean,
    val includeJunior: Boolean,
    val jobTitle: String?
) : Serializable {

    fun getFullJobDescription() = if (includeJunior) "a Junior $jobTitle" else "an $jobTitle"

    fun getAvailability() = if(immediateStart) "immediately" else "from $startDate"
}