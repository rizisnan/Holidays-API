package com.example.projectakhir.Service;

import com.example.projectakhir.HolidaysModel.HolidaysResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HolidaysRepository {
    @GET("v1/holidays?api_key=95f4c07a-5552-435b-9cc0-5f7282ef6a71&country=US&year=2020")
    Call<HolidaysResponse> getHoliday();

}
