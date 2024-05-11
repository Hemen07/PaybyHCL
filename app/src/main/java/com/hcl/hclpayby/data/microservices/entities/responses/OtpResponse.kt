package com.hcl.hclpayby.data.microservices.entities.responses


import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class OtpResponse(
    var status: String? = null,
) : Parcelable