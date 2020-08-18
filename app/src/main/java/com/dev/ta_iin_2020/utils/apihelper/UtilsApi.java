package com.dev.ta_iin_2020.utils.apihelper;

public class UtilsApi {
    public static final String BASE_URL = "http://192.168.43.120/kotak/";

    public static ApiInterface getApiService(){
        return ApiClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
