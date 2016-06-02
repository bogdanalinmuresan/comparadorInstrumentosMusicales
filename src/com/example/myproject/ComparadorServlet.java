package com.example.myproject;

import java.io.IOException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.net.*;
import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import com.example.myproject.BookInfo;

@SuppressWarnings("serial")
public class ComparadorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<BookInfo>resu;
		String searchword = req.getParameter("keywords");
		//System.out.println(searchword);
		
        EbayDriver driver = new EbayDriver();
        String tag = searchword;
       
        try {
			resu=new ArrayList<BookInfo>(driver.run(java.net.URLEncoder.encode(tag, "UTF-8")));
			//jsoap
			//*************	***************//
        	
			String url="http://es.aliexpress.com/wholesale?catId=0&initiative_id=SB_20160531110333&SearchText=";
			url=url.concat(searchword);
			System.out.println(url);

			Document doc=null;
			try{
				doc = Jsoup.connect(url).get();
			}catch(IOException e){
				e.printStackTrace();
			}
			
			Elements items = doc.getElementsByClass("item");
			
			for (Element item : items) {
				String articulo = item.select(".item").first().html();
				
				}
			
			//System.out.println("este es el titulo "+title);
			
			
			req.setAttribute("articulosEbay", resu);
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
			
			
			//*******************************//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			/*
			try {
				
				String isbn = req.getParameter("isbn").trim().replace("-", "");
				BookInfo book = null;
				
				if (isbn.length()>0) {
					
					book = checkAmazonOffers(isbn, book, ".com");
					book = checkAmazonOffers(isbn, book, ".co.uk");
					book = checkAmazonOffers(isbn, book, ".es");
					book = checkAmazonOffers(isbn, book, ".de");
					book = checkAmazonOffers(isbn, book, ".fr");
					book = checkAmazonOffers(isbn, book, ".it");
					book = checkAmazonOffers(isbn, book, ".ca");
					
					book = checkGoogleOffers(isbn, book, "US");
					book = checkGoogleOffers(isbn, book, "UK");
					book = checkGoogleOffers(isbn, book, "ES");
					
					
				 
				
				
					if (book!=null && book.isbn!=null) {
						req.setAttribute("book", book);
						RequestDispatcher rd = req.getRequestDispatcher("/book.jsp");
						rd.forward(req, resp);
					} else {				
						resp.sendRedirect("/error.html");
					}
				 
				} catch (Exception error) { 

			    resp.sendRedirect("/error.html");
			}
		}
*/
	}
}//ComparadorServlet
