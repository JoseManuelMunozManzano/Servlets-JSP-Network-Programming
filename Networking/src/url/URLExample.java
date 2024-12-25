package url;

import java.net.*;
import java.io.*;

public class URLExample {
    public static void main(String[] args) throws Exception {

        // Ejemplo 1
    	// Parse through the URL Details
        // URL URL = new URL("http://company.com:80/docs/books/tutorial"
        //                    + "/index.html?name=networking#Sometext");

        // System.out.println("protocol = " + URL.getProtocol());
        // System.out.println("authority = " + URL.getAuthority());
        // System.out.println("host = " + URL.getHost());
        // System.out.println("port = " + URL.getPort());
        // System.out.println("path = " + URL.getPath());
        // System.out.println("query = " + URL.getQuery());
        // System.out.println("filename = " + URL.getFile());
        // System.out.println("ref = " + URL.getRef());
    	
        // Ejemplo 2
        // Reading the content of a URL
        URL oracle = new URL("https://how-to-host-a-website.com/");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}
