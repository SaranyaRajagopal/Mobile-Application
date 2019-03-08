package com.chainsys.mobapp.model;

public class Product {

	private int id;
	private String brand;
	private String model;
	private int price;
	private String processor;
	private String memory;
	@Override
	public String toString() {
		return "MobDetails [id=" + id + ", brand=" + brand + ", model=" + model
				+ ", price=" + price + ", processor=" + processor + ", memory="
				+ memory + "]";
	}
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
}
