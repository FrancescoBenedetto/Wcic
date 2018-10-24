package com.francesco_benedetto.wcic_crawler;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.common.io.Files;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class GialloZafferanoCrawler extends WebCrawler{
	
	private Properties props = PropertiesLoader.load();
	private String baseOutPath = null;
	
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp4|zip|gz))$");
	
	
	public GialloZafferanoCrawler() {
		baseOutPath = props.getProperty("BASE_PATH") 
				+ props.getProperty("BASE_RAWPAGESINPUT_PATH") 
				+ "/";
	}
	
	
	
	/**
     * This method receives two parameters. The first parameter is the page
     * in which we have discovered this new url and the second parameter is
     * the new url. You should implement this function to specify whether
     * the given url should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the crawler to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "https://www.ics.uci.edu/". In this case, we didn't need the
     * referringPage parameter to make the decision.
     */
     @Override
     public boolean shouldVisit(Page referringPage, WebURL url) {
         String href = url.getURL().toLowerCase();
         return !FILTERS.matcher(href).matches()
        		// && (href.length() - href.replace("/", "").length()) == 3
                && 
                (href.startsWith("https://www.giallozafferano.it/") 
                		|| href.startsWith("https://ricette.giallozafferano.it/"));
         		
     }

     /**
      * This function is called when a page is fetched and ready
      * to be processed by your program.
      */
     @Override
     public void visit(Page page) {
         String url = page.getWebURL().getURL();
         System.out.println("URL: " + url);

         if (page.getParseData() instanceof HtmlParseData
        		 && page.getWebURL().toString().endsWith(".html")) {
             HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
//             String text = htmlParseData.getText();
             String html = htmlParseData.getHtml();
             //Set<WebURL> links = htmlParseData.getOutgoingUrls();
             String[] splittedUrl = page.getWebURL().toString().split("/");
             String outPath = baseOutPath 
            		 + extractDishType(html) + "/"
            		 + (splittedUrl[splittedUrl.length - 1]);
        	 try 
        	 {
        		 System.out.println("scrivendo: " + outPath);
        		 /*
        		 Files.write(html.getBytes(), Paths.get(outPath).toFile());
        		 */
        		 
        		 File file = new File(outPath);
        		 file.getParentFile().mkdirs();
        		 FileWriter writer = new FileWriter(file);
        		 html = html.concat("\n<appended-url>"+page.getWebURL()+"</appended-url>");
        		 writer.write(html);
        		 writer.close();
        		 
        	 } 
        	 catch (Exception e) 
        	 {
				e.printStackTrace();
        	 }
        	 //System.out.println("Text length: " + text.length());
             //System.out.println("Html length: " + html.length());
             //System.out.println("Number of outgoing links: " + links.size());
         }
    }
     
     private String extractDishType(String html) {
    	 Document doc = Jsoup.parse(html);
    	 Element recipeCategoryContainer = doc.select("div.recipe-category").first();
    	 String typeName = recipeCategoryContainer.select("a.rkat").text().trim();
    	 if(recipeCategoryContainer==null || typeName==null || typeName.trim().equals("")) return "ALTRO";
    	 else return typeName.replaceAll(" ", "_").toUpperCase();
    	 
     }
	
}
