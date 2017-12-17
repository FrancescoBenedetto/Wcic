package com.fben.wcic.performanceTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PerformanceTest {

	public static void main(String[] args) {

		  try {
			URL url = new URL("http://localhost:8080/search/getCookableDishes?ingredients=Pepe,Sale&atLeast=1&page=1");
			long startTime = System.currentTimeMillis();
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			long endTime = System.currentTimeMillis();
			
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
			System.out.println((endTime-startTime)/1000);

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		}
}
