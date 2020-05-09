package com.example.projectakhir.HolidaysModel;

import com.google.gson.annotations.SerializedName;

public class Query{

	@SerializedName("country")
	private String country;

	@SerializedName("api_key")
	private String apiKey;

	@SerializedName("year")
	private String year;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setApiKey(String apiKey){
		this.apiKey = apiKey;
	}

	public String getApiKey(){
		return apiKey;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}
}