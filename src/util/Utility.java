package util;

import org.json.JSONArray;
import org.json.JSONObject;

import android.text.TextUtils;
import db.CoolWeatherDB;
import model.City;
import model.County;
import model.Province;

public class Utility {

	public synchronized static boolean handleChineseProvinces(CoolWeatherDB coolWeatherDB, String response){
		if(!TextUtils.isEmpty(response)){
			try {
				JSONObject jsonObject = new JSONObject(response);
				JSONArray object = jsonObject.getJSONArray("data");
				for(int i = 0;i < object.length();i++){
					Province province = new Province();
					if(i == 0){						
						province.setProvinceName(object.getJSONObject(i).getString("prov"));
						coolWeatherDB.saveProvince(province);			
					}else if(!object.getJSONObject(i).getString("prov").equals(object.getJSONObject(i-1).getString("prov"))){
						province.setProvinceName(object.getJSONObject(i).getString("prov"));
						coolWeatherDB.saveProvince(province);	
					}
					
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return true;
		}
		return false;
		
	}
	
	public synchronized static boolean handleChineseCities(CoolWeatherDB coolWeatherDB, String response){
		if(!TextUtils.isEmpty(response)){
			try {
				JSONObject jsonObject = new JSONObject(response);
				JSONArray object = jsonObject.getJSONArray("data");
				for(int i = 0;i < object.length();i++){
					City city = new City();				
					if(i == 0){						
						city.setCityName(object.getJSONObject(i).getString("city"));
						city.setProvinceName(object.getJSONObject(i).getString("prov"));
						coolWeatherDB.saveCity(city);			
					}else if(!object.getJSONObject(i).getString("city").equals(object.getJSONObject(i-1).getString("city"))){
						city.setProvinceName(object.getJSONObject(i).getString("prov"));
						city.setCityName(object.getJSONObject(i).getString("city"));
						coolWeatherDB.saveCity(city);	
					}								
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}			
			return true;
		}
		return false;
	}
	
	public synchronized static boolean handleChineseCounties(CoolWeatherDB coolWeatherDB, String response){
		if(!TextUtils.isEmpty(response)){
			try {
				JSONObject jsonObject = new JSONObject(response);
				JSONArray object = jsonObject.getJSONArray("data");
				for(int i = 0;i < object.length();i++){
					County county = new County();					
					county.setCountyName(object.getJSONObject(i).getString("district"));
					county.setCityName(object.getJSONObject(i).getString("city"));
					county.setCountyCode(object.getJSONObject(i).getInt("areaid"));
					coolWeatherDB.saveCounty(county);				
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return true;
		}
		
		return false;
		
	}
}
