package com.sparta.boredAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("activity")
	private String activity;

	@JsonProperty("accessibility")
	private Double accessibility;

	@JsonProperty("price")
	private Double price;

	@JsonProperty("link")
	private String link;

	@JsonProperty("type")
	private String type;

	@JsonProperty("key")
	private String key;

	@JsonProperty("participants")
	private Integer participants;


	public Double getAccessibility(){
		return accessibility;
	}

	public Double getPrice(){
		return price;
	}

	public Integer getAccessibility(){
		return accessibility;
	}

	public Integer getPrice(){
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

	public Integer getParticipants() {
		return participants;
	}

	//helper methods
	public boolean isNotEmpty() {
		return activity != null && !activity.isEmpty()
				&& type != null && !type.isEmpty()
				&& link != null && !link.isEmpty()
				&& key != null && !key.isEmpty()
				&& accessibility != null
				&& price != null
				&& participants != null;
	}}