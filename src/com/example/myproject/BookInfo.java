package com.example.myproject;

public class BookInfo {
	public String itemId;
	public String title;
	public String currentPrice;
	public String galleryUrl;
	public String urlImag;
	
	//constructor
	public BookInfo(){
		itemId="vacio";
		title="vacio";
		currentPrice="vacio";
		galleryUrl="vacio";
		urlImag=null;
	}
	
	//metodo modificador
	public void set(String item,String tit,String price,String gallery,String urlIma){
		itemId=item;
		title=tit;
		currentPrice=price;
		galleryUrl=gallery;
		urlImag=urlIma;
		
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
	
	public String getUrlImag(){
		return urlImag;
	}
	
	
	
}
