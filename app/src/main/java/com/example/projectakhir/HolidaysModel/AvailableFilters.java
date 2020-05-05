package com.example.projectakhir.HolidaysModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AvailableFilters{

	@SerializedName("languages")
	private List<String> languages;

	@SerializedName("states")
	private States states;

	public void setLanguages(List<String> languages){
		this.languages = languages;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public void setStates(States states){
		this.states = states;
	}

	public States getStates(){
		return states;
	}

	@Override
 	public String toString(){
		return 
			"AvailableFilters{" + 
			"languages = '" + languages + '\'' + 
			",states = '" + states + '\'' + 
			"}";
		}
}