package com.example.projectakhir.Service;

import com.example.projectakhir.HolidaysModel.HolidaysResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HolidaysRepository {
    @GET("v1/holidays?api_key=e1f532d3-6ba9-4f96-82cb-4de3b45753ae&country=US&year=2020")
    Call<HolidaysResponse> getHoliday();
}
