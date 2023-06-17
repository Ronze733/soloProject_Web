package com.jm.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherDAO {
	
	private final static WeatherDAO WEATHERDAO = new WeatherDAO(); 
	
	public WeatherDAO() {
		// TODO Auto-generated constructor stub
	}

	public static WeatherDAO getWeatherdao() {
		// TODO Auto-generated method stub
		return WEATHERDAO;
	}

	public void makeWeather(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String city = request.getParameter("city");
		
		String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&units=metric&cnt=40&appid=3c20bb3f5ab75a340db446d8ba273c5b";
		
		try {
			URL u = new URL(url);
			System.out.println(u);
			HttpsURLConnection  huc = (HttpsURLConnection) u.openConnection();
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			System.out.println(isr);
			
			JSONParser jp = new JSONParser();
			
			JSONObject weatherData = (JSONObject) jp.parse(isr);
			System.out.println(weatherData);
			
			JSONObject sysJ = (JSONObject) weatherData.get("city");
			JSONArray weatherJ = (JSONArray) weatherData.get("list");
			
			String cityName = sysJ.get("name") + "";
			String countryName = sysJ.get("country") + "";
			
			request.setAttribute("cityName", cityName);
			request.setAttribute("countryName", countryName);
			
			Weather weather = null;
			
			ArrayList<Weather> weathers = new ArrayList<Weather>();
			
			for(int i = 0; i < 24; i++) {
				JSONObject day = (JSONObject) weatherJ.get(i);
				String date = (String) day.get("dt_txt");
				
				JSONObject main = (JSONObject) day.get("main");
				
				String humidity = main.get("humidity") + "";
				String temp = main.get("temp") + "";
				
				JSONArray conditionJ = (JSONArray) day.get("weather");
				String condition = ((JSONObject) conditionJ.get(0)).get("main") + "";
				String icon = ((JSONObject) conditionJ.get(0)).get("icon") + "";
				
				
				
				String windspeed = ((JSONObject) day.get("wind")).get("speed") + "";
				weather = new Weather(humidity, temp, windspeed, condition, date, icon);
				
				weathers.add(weather);
			}
			
			request.setAttribute("weathers", weathers);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
