package com.dev.ta_iin_2020.utils.apihelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getTotalInfaq.php")
    Call<ResponseBody> getData();

    @GET("getPerDay.php")
    Call<ResponseBody> getPerDay();

    @GET("getPerMonth.php")
    Call<ResponseBody> getPerMonth();

    @GET("getDataPerDay.php")
    Call<ResponseBody> getDetailDay();

    @GET("getDataPerMonth.php")
    Call<ResponseBody> getDetailMonth();


}
