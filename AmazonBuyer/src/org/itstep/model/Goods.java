package org.itstep.model;

public class Goods {
	
	private String name;
	private String initial_price;
	private String asin;
	private String img_url;
	private String good_url;
	private String price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInitial_price() {
		return initial_price;
	}
	public void setInitial_price(String initial_price) {
		this.initial_price = initial_price;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getGood_url() {
		return good_url;
	}
	public void setGood_url(String good_url) {
		this.good_url = good_url;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Goods() {
	}
	public Goods(String name, String asin) {
		this.name = name;
		this.asin = asin;
	}
	
	
	
	
	

}
