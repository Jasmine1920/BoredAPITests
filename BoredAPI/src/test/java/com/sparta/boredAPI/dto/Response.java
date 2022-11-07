package com.sparta.boredAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	public Response() {}

	public Response(String activity, double accessibility, double price, String link, String type, String key, int participants) {
		this.activity = activity;
		this.accessibility = accessibility;
		this.price = price;
		this.link = link;
		this.type = type;
		this.key = key;
		this.participants = participants;
	}

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

	public Boolean activityisrecreationalandnotnull(){
		return type!=null && getType().equals("recreational");}

	public boolean isNotEmpty() {
		return activity != null && !activity.isEmpty()
				&& link != null && !link.isEmpty()
				&& type != null && !type.isEmpty()
				&& key != null && !key.isEmpty();
	}
}