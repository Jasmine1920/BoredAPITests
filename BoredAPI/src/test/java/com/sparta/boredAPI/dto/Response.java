package com.sparta.boredAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("activity")
	private String activity;

	@JsonProperty("accessibility")
	private Double accessibility;

	@JsonProperty("price")
	private Double price;

	@JsonProperty("type")
	private String type;

	@JsonProperty("key")
	private String key;

	@JsonProperty("participants")
	private Integer participants;

	@JsonProperty("link")
	private String link;

	public String getActivity(){
		return activity;
	}

	public Double getAccessibility(){
		return accessibility;
	}

	public Double getPrice(){
		return price;
	}

	public String getType(){
		return type;
	}

	public String getKey(){
		return key;
	}

	public Integer getParticipants(){
		return participants;
	}
}