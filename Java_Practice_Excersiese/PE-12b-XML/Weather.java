	
// 		<weather module_id="0" tab_id="0" mobile_row="0" mobile_zipped="1" row="0" section="0">
// 		<forecast_information>
// 			<city data="Pittsford, NY" />
// 			<postal_code data="14534" />
// 			<latitude_e6 data="" />
// 			<longitude_e6 data="" />
// 			<forecast_date data="2011-03-12" />
// 			<current_date_time data="2011-03-12 19:48:39 +0000" />
// 			<unit_system data="US" />
// 		</forecast_information>
// 		<current_conditions>
// 			<condition data="Mostly Cloudy" />
// 			<temp_f data="42" />
// 			<temp_c data="6" />
// 			<humidity data="Humidity: 63%" />
// 			<icon data="/ig/images/weather/mostly_cloudy.gif" />
// 			<wind_condition data="Wind: NW at 7 mph" />
// 		</current_conditions>
// 		<forecast_conditions>
// 			<day_of_week data="Sat" />
// 			<low data="32" />
// 			<high data="45" />
// 			<icon data="/ig/images/weather/rain_snow.gif" />
// 			<condition data="Rain and Snow" />
// 		</forecast_conditions>

import java.util.*;
import org.w3c.dom.Document;

/** Weather.java
	 Weather class to hold information from an XML input.
	 XML source can be a file, or from Internet.
	 Michael Floeser
  */

public class Weather{
	ForecastInformation forecast;
	CurrentConditions conditions;
	ArrayList<ForecastConditions> futureConds;
	
	public Weather(	ForecastInformation _forecast, 
							CurrentConditions _conditions, 
							ArrayList<ForecastConditions> _futureConds ) {
		forecast 	= _forecast;
		conditions	= _conditions;
		futureConds	= _futureConds;
	}
	
	public String toString(){
		String result =  forecast + "\n" + conditions;
		
		for( ForecastConditions fc : futureConds ){
			result = result + "\n" + fc;
		}
		
		return result;
	}

}

class ForecastInformation {
	private String city;
	private String postal;
	private String latitude;
	private String longitude;
	private String forecast;
	private String currDT;
	private String units;
	
	public ForecastInformation( String _city, String _postal, String _latitude, 
						String _longitude, String _forecast, String _currDT, String _units ) {
	city 		= _city;
	postal	= _postal;
	latitude	= _latitude;
	longitude= _longitude;
	forecast	= _forecast;
	currDT	= _currDT;
	units		= _units;
}
	
	public String toString(){
		return city + "; " + postal + "; " + latitude + "; " + longitude + "; " + forecast + "; " + 
									currDT + "; " + units ;
	}									
}

class CurrentConditions {
	private String condition;
	private String tempf;
	private String tempc;
	private String humidity;
	private String icon;
	private String wind;

	public CurrentConditions( String _condition, String _tempf, String _tempc, String _humidity, String _icon, String _wind ) {
		condition	= _condition;
		tempf			= _tempf;
		tempc			= _tempc;
		humidity	 	= _humidity;
		icon			= _icon;
		wind			= _wind;
	}

	public String toString() {
		return condition +"; "+ tempf +"; "+ tempc +"; "+ humidity +"; "+ icon +"; "+ wind ;
	}
}


class ForecastConditions {
	private String dow;
	private String low;
	private String high;
	private String icon;
	private String condition;
	
	public ForecastConditions( String _dow, String _low, String _high, String _icon, String _condition ) {
		dow 			= _dow;
		low 			= _low;
		high 		= _high;
		icon 			= _icon;
		condition	= _condition;
	}
	
	public String toString() {
		return dow +"; "+ low +"; "+ high +"; "+ icon +"; "+ condition;
	}
}