package com.hino.cardemo.data.service

import com.hino.cardemo.data.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Hien Ngo
 * @since 15/12/18
 */
interface CarApiService {
    @GET("v1/car-types/manufacturer")
    fun getManufacturer(@Query("page") page : Int,
                        @Query("pageSize") pageSize : Int) : Observable<Response<Map<String, String>>>

    @GET("v1/car-types/main-types")
    fun getMainType(@Query("manufacturer")manufacturer : String,
                    @Query("page") page : Int,
                    @Query("pageSize") pageSize : Int) : Observable<Response<Map<String, String>>>

    @GET("v1/car-types/built-dates")
    fun getBuildDate(@Query("manufacturer") manufacturer : String,
                     @Query("main-type") type : String) : Observable<Response<Map<String, String>>>
}