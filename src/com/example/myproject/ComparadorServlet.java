package com.example.myproject;

import java.io.IOException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.net.*;
import java.io.*;

@SuppressWarnings("serial")
public class ComparadorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String searchword = req.getParameter("keywords");
		//System.out.println(searchword);
		
        EbayDriver driver = new EbayDriver();
        String tag = searchword;
        try {
			driver.run(java.net.URLEncoder.encode(tag, "UTF-8"));
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
