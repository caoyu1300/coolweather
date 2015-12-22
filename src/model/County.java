package model;

public class County {
	private int id;
	private String countyName;
	private int countyCode;
	private String cityName;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getCountyName(){
		return countyName;
	}
	
	public void setCountyName(String name){
		this.countyName= name;
	}
	
	public int getCountyCode(){
		return countyCode;
	}
	
	public void setCountyCode(int code){
		this.countyCode = code;
	}
	
	public String getCityName(){
		return cityName;
	}
	
	public void setCityName(String cityName){
		this.cityName = cityName;
	}
}
