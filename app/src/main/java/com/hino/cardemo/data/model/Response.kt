package com.hino.cardemo.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Hien Ngo
 * @since 12/18/18
 */
data class Response<T>(
    @SerializedName("page") var page: Int = 0,
    @SerializedName("pageSize") var pageSize: Int = 0,
    @SerializedName("totalPageCount") var total : Int,
    @SerializedName("wkda") var data : T)