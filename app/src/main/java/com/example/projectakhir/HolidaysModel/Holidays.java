package com.example.projectakhir.HolidaysModel;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Holidays{

	@SerializedName("holidays")
	private ArrayList<HolidaysItem> holidays;

	@SerializedName("query")
	private Query query;

	public void setHolidays(ArrayList<HolidaysItem> holidays){
		this.holidays = holidays;
	}

	public ArrayList<HolidaysItem> getHolidays(){
		return holidays;
	}

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}
}