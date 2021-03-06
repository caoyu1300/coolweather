package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.nfc.NfcAdapter.CreateBeamUrisCallback;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

	
	public static final String CREAT_PROVINCE = "create table province(id integer primary key autoincrement,"
			+ "province_name text,province_code text)";
	public static final String CREATE_CITY = "create table city(id integer primary key autoincrement,"
			+ "city_name text,city_code text,province_name integer)";
	public static final String CREATE_COUNTY = "create table county(id integer primary key autoincrement,"
			+ "county_name text,county_code integer,city_name text)";
	public CoolWeatherOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREAT_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
