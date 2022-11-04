package com.sparta.boredAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("activity")
	private String activity;

	@JsonProperty("accessibility")
	private double accessibility;

	@JsonProperty("price")
	private double price;

	@JsonProperty("link")
	private String link;

	@JsonProperty("type")
	private String type;

	@JsonProperty("key")
	private String key;

	@JsonProperty("participants")
	private int participants;

	public String getActivity(){
		return activity;
	}

	public double getAccessibility(){
		return accessibility;
	}

	public double getPrice(){
		return price;
	}

	public String getLink(){
		return link;
	}

	public String getType(){
		return type;
	}

	public String getKey(){
		return key;
	}

	public int getParticipants(){
		return participants;
	}
}