package com.francesco_benedetto.wcic_crawler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	
	private static Properties props = null;
	private static FileInputStream is = null;

	public static Properties load(){
		props = new Properties();
		try 
		{
			is = new FileInputStream("/home/francesco/workspace/wcic/wcic_crawler/wcic-crawler/src/main/resources/config.properties");
			props.load(is);
			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(is!=null) {
				try {
				is.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return props;
	}

}
