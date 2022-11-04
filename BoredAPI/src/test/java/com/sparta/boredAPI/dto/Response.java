package com.sparta.boredAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("activity")
	private String activity;

	@JsonProperty("accessibility")
<<<<<<< HEAD
	private Double accessibility;

	@JsonProperty("price")
	private Double price;
=======
	private Integer accessibility;

	@JsonProperty("price")
	private Integer price;

	@JsonProperty("link")
	private String link;
>>>>>>> 8ed077e4892dbf92e6d95cdbba8db1d75c4de34b

	@JsonProperty("type")
	private String type;

	@JsonProperty("key")
	private String key;

	@JsonProperty("participants")
	private Integer participants;

<<<<<<< HEAD
	@JsonProperty("link")
	private String link;

=======
>>>>>>> 8ed077e4892dbf92e6d95cdbba8db1d75c4de34b
	public String getActivity(){
		return activity;
	}

<<<<<<< HEAD
	public Double getAccessibility(){
		return accessibility;
	}

	public Double getPrice(){
		return price;
	}

=======
	public Integer getAccessibility(){
		return accessibility;
	}

	public Integer getPrice(){
		return price;
	}

	public String getLink(){
		return link;
	}

>>>>>>> 8ed077e4892dbf92e6d95cdbba8db1d75c4de34b
	public String getType(){
		return type;
	}

	public String getKey(){
		return key;
	}

	public Integer getParticipants(){
		return participants;
	}
<<<<<<< HEAD
=======

	//helper methods
	public boolean isNotEmpty() {
		return activity != null && !activity.isEmpty()
				&& type != null && !type.isEmpty()
				&& link != null && !link.isEmpty()
				&& key != null && !key.isEmpty()
				&& accessibility != null
				&& price != null
				&& participants != null;
	}
>>>>>>> 8ed077e4892dbf92e6d95cdbba8db1d75c4de34b
}