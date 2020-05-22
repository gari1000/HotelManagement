package com.hit.model;

public class Room {
	private String name;
	private String bedType;
	private int capacity;
	private boolean withView;
	private int price;
	
	public Room(String name, String bedType, int capacity, boolean withView, int price) {
		super();
		this.name = name;
		this.bedType = bedType;
		this.capacity = capacity;
		this.withView = withView;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBedType() {
		return bedType;
	}
	
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isWithView() {
		return withView;
	}
	
	public void setWithView(boolean withView) {
		this.withView = withView;
	}

}
