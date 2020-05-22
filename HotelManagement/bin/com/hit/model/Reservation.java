package com.hit.model;

import java.util.ArrayList;
import java.util.Iterator;


public class Reservation {
	private String name;
	private int resId; 
	private ArrayList <Room> rooms;
	private int price;
	
	public void addRoom(Room room) {
		rooms.add(room);
		}
	
	public int calcPrice() {
		
		Iterator<Room> it= rooms.iterator();
		
		while (it.hasNext()) {
			int i=0;
			this.price += rooms.get(i).getPrice();
			i++;
		    it.next();
		}
		return this.price;
	}
	
	

}
