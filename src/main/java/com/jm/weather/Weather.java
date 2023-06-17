package com.jm.weather;


public class Weather {
	private String humidity;
	private String temp;
	private String windSpeed;
	private String condition;
	private String day;
	private String icon;
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(String humidity, String temp, String windSpeed, String condition, String day, String icon) {
		super();
		this.humidity = humidity;
		this.temp = temp;
		this.windSpeed = windSpeed;
		this.condition = condition;
		this.day = day;
		this.icon = icon;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
