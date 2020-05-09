package com.example.projectakhir.Service;

import com.example.projectakhir.HolidaysModel.HolidaysResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HolidaysRepository {
    @GET("v1/holidays?api_key=7176f371-8fc0-4b2c-ba1d-6a1d928e0171&country=US&year=2020")
    Call<HolidaysResponse> getHoliday();
}
