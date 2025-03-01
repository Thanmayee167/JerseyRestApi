package com.thanmayee.restapi;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement
@JsonRootName(value = "alien")
public class Alien {
	private int id;
	private String name;
	private String colour;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", colour=" + colour + "]";
	}

}
