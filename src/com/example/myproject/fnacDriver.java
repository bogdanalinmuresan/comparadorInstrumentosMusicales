package com.example.myproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.example.myproject.BookInfo;
public class fnacDriver {

	public String url = "http://busqueda.fnac.es/Search/SearchResult.aspx?SCat=9%211&Search=";
	public final static int REQUEST_DELAY = 3000;
	private List<BookInfo> res;
	
	//constructor
	public fnacDriver(){
		res=new ArrayList<BookInfo>();
	}

    public static String cambiarurl( String url){
        url = url.replace(' ','+');
        return url;
    }
    
    public static int getStatusConnectionCode(String url) {
		
        Response response = null;
		
        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }
	
	
   
    public static Document getHtmlDocument(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;
    }
    public List<BookInfo> run(String tag) throws Exception {
    	//realizamos la consulta
    	url=url.concat(tag);
    	System.out.println("Url de la consulta es "+url+"\n");
    	
       // Compruebo si me da un 200 al hacer la petición
       if (getStatusConnectionCode(url) == 200) {
		
           // Obtengo el HTML de la web en un objeto Document2
           Document document = getHtmlDocument(url);
		
           // Busco todas las historias de meneame que estan dentro de: 
           Elements entradas = document.getElementsByClass("oneprd");
		
           // Paseo cada una de las entradas
           for (Element elem : entradas) {
               String titulo = elem.select(".lienInverse.title").text();
               String precio = elem.select(".prix").text();
               
               String url = elem.select(".lienInverse a").attr("href");
              
               
               String urlImag = elem.select(".img img").attr("src");
               
               System.out.println("el titulo es"+titulo+"\n");
               System.out.println("el precio es"+precio+"\n");
               System.out.println("la url es "+url+"\n");
               System.out.println("la urlImag es "+urlImag+"\n");
               
               BookInfo book=new BookInfo();
               book.set("vacio", titulo, precio, url,urlImag);
               res.add(book);
           }
           

       }else{
           System.out.println("Code error = : "+getStatusConnectionCode(url));              
       }
        //process xml dump returned from EBAY
        
        //Honor rate limits - wait between results
        Thread.sleep(REQUEST_DELAY);
        return res;
    }
}
