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
import com.example.myproject.amazonDrive;

@SuppressWarnings("serial")
public class ComparadorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<BookInfo>resuEbay;
		List<BookInfo>resuFnac;
		List<BookInfo>resuAmazon;
		String searchword = req.getParameter("keywords");
		
		
        EbayDriver driverEbay = new EbayDriver();
        fnacDriver driverFnac=new fnacDriver();
        amazonDrive driverAmazon=new amazonDrive();
        String tag = searchword;
       
        try {
			resuEbay=new ArrayList<BookInfo>(driverEbay.run(java.net.URLEncoder.encode(tag, "UTF-8")));
			resuFnac=new ArrayList<BookInfo>(driverFnac.run(java.net.URLEncoder.encode(tag, "UTF-8")));
			resuAmazon=new ArrayList<BookInfo>(driverAmazon.run(java.net.URLEncoder.encode(tag, "UTF-8")));
		
			
			req.setAttribute("articulosEbay", resuEbay);
			req.setAttribute("articulosFnac", resuFnac);
			req.setAttribute("articulosAmazon", resuAmazon);
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
			
			
			//*******************************//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}//ComparadorServlet
