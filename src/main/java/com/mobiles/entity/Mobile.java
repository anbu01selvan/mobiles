package com.mobiles.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mob_details")
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private int price;
	private int batteryCapacity;
	private String screenSize;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", brand=" + brand + ", price=" + price + ", batteryCapacity=" + batteryCapacity
				+ ", screenSize=" + screenSize + "]";
	}
	
}
