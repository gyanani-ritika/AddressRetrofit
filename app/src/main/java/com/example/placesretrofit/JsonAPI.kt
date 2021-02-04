package com.example.placesretrofit;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

 interface JsonAPI {
    @GET("compassLocation/rest/address/autocomplete")
    fun getPlaces(@Query("limit") limit : Int ,
                            @Query("queryString") query: String,
                            @Query("uhm") uhm : Boolean,
                            @Query("pinCode")  pincode: Boolean): Call<Example>
}
