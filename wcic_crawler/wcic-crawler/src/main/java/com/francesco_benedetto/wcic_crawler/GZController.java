package com.francesco_benedetto.wcic_crawler;

import java.util.Properties;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class GZController {

	public static void main(String[] args) throws Exception{
		Properties props = PropertiesLoader.load();
		String crawlStorageFolder = props.getProperty("BASE_PATH") 
				+ "/data";
        int numberOfCrawlers = 7;
        //int maxDepthOfCrawling = 10;
        

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        //config.setMaxDepthOfCrawling(maxDepthOfCrawling);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        controller.addSeed("https://www.giallozafferano.it/ricette-cat/Primi/");
        controller.addSeed("https://www.giallozafferano.it/ricette-cat/Primi/page*");
        //controller.addSeed("https://www.ics.uci.edu/~welling/");
    	//controller.addSeed("https://www.ics.uci.edu/");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(GialloZafferanoCrawler.class, numberOfCrawlers);
    }
	
}