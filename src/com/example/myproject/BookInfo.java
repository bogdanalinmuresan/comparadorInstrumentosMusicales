package com.example.myproject;

public class BookInfo {
	public String itemId;
	public String title;
	public String currentPrice;
	public String galleryUrl;
	
	//constructor
	public BookInfo(){
		itemId="vacio";
		title="vacio";
		currentPrice="vacio";
		galleryUrl="vacio";
	}
	
	//metodo modificador
	public void set(String item,String tit,String price,String gallery){
		itemId=item;
		title=tit;
		currentPrice=price;
		galleryUrl=gallery;
	}
	public String getTitle(){
		return title;
	}
	public String getItemId(){
		return itemId;
	}
	
	public String getCurrentPrice(){
		return currentPrice;
	}
	public String getGalleryUrl(){
		return galleryUrl;
	}
	
	
	
}
