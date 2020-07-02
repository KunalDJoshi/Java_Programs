// Example of DOM parsing, using XPath
//// See Tree Navigation of Dom & Dom navigation

import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
//   http://www.google.com/ig/api?weather=14534
//   http://www.google.com/ig/images/weather/rain_snow.gif

/**
   An XML parser for item lists
*/
public class WeatherParser {

// 	public static void main(String [] args) throws Exception{
// 		new WeatherParser().parse("14534.xml");
// 		
// 	}

   private DocumentBuilder builder;
   private XPath path;
	private static final String PREFIX = "/xml_api_reply/weather/";
   /**
      Constructs a parser that can parse item lists.
   */
   public WeatherParser() 
         throws ParserConfigurationException
   {
      DocumentBuilderFactory dbfactory 
            = DocumentBuilderFactory.newInstance();
      builder = dbfactory.newDocumentBuilder();
      XPathFactory xpfactory = XPathFactory.newInstance();
      path = xpfactory.newXPath();
   }

   /**
      Parses an XML file containing an item list.
      @param fileName the name of the file as a String
      @return an array list containing all items in the XML file
   */
   public Weather parse(String fileName) throws SAXException, IOException, XPathExpressionException {
      File f = new File(fileName);
      Document doc = builder.parse(f);
		return doParse( doc );
	}
	
   /**
      Parses an XML file containing an item list.
      @param fileName the name of the file as a File object
      @return an array list containing all items in the XML file
   */
   public Weather parse(File fileName) throws SAXException, IOException, XPathExpressionException {
      Document doc = builder.parse(fileName);
		return doParse( doc );
	}
	
   /**
      Parses an XML file containing an item list.
      @param fileName the name of the file as an InputStream
      @return an array list containing all items in the XML file
   */		
	public Weather parse(InputStream is) throws SAXException, IOException, XPathExpressionException {
      Document doc = builder.parse(is);
		return doParse( doc );
	}
	
	public Weather doParse( Document doc ) throws XPathExpressionException{
	
//       int itemCount = Integer.parseInt( path.evaluate("count("+PREFIX+"forecast_conditions)", doc));
// 		System.out.println("itemCount = "+itemCount);
		Weather wh = new Weather(  getForecastInfo( doc), getCurrCond( doc ), getForecastCond( doc ) );	

// 		System.out.println( wh );		
      return wh;
   }

///////////////////////////////////////////////////////////////////////////////////////////////
	public ForecastInformation getForecastInfo( Document doc ) throws XPathExpressionException {
			ForecastInformation fi = null;
			String location = PREFIX+"forecast_information/";
			String city 	= path.evaluate(location+"city/@data", doc );
			String postal 	= path.evaluate(location+"postal_code/@data", doc );
			String latitude= path.evaluate(location+"latitude_e6/@data", doc );
			String longitude = path.evaluate(location+"longitude_e6/@data", doc );
			String forecast= path.evaluate(location+"forecast_date/@data", doc );
			String currDT	= path.evaluate(location+"current_date_time/@data", doc );
			String units	= path.evaluate(location+"unit_system/@data", doc );

// 		<forecast_information>
// 			<city data="Pittsford, NY" />
// 			<postal_code data="14534" />
// 			<latitude_e6 data="" />
// 			<longitude_e6 data="" />
// 			<forecast_date data="2011-03-12" />
// 			<current_date_time data="2011-03-12 19:48:39 +0000" />
// 			<unit_system data="US" />
// 		</forecast_information>
			fi = new ForecastInformation( city, postal, latitude, longitude, forecast, currDT, units );
// 			System.out.println( fi );
		return fi;
	}
	
	public CurrentConditions getCurrCond(Document doc) throws XPathExpressionException {
	

		// STUDENTS ADD CODE HERE TO PARSE THE CurrentConditions
         CurrentConditions cc = null;
         String location = PREFIX+"current_conditions/";
         String condition 	= path.evaluate(location+"condition/@data", doc );
         String tempf = path.evaluate(location+"temp_f/@data",doc);
         String tempc= path.evaluate(location+"temp_c/@data",doc);
         String humidity= path.evaluate(location+"humidity/@data",doc);
         String icon=path.evaluate(location+"icon/@data",doc);
         String windcond=path.evaluate(location+"wind_condition/@data",doc);
         
//			<current_conditions>
// 			<condition data="Mostly Cloudy" />
// 			<temp_f data="42" />
// 			<temp_c data="6" />
// 			<humidity data="Humidity: 63%" />
// 			<icon data="/ig/images/weather/mostly_cloudy.gif" />
// 			<wind_condition data="Wind: NW at 7 mph" />
// 		</current_conditions>
          cc = new CurrentConditions(condition,tempf,tempc,humidity,icon,windcond);

         
// 			System.out.println( cc );
			return cc;
	}
	
	public ArrayList<ForecastConditions>  getForecastCond(Document doc) throws XPathExpressionException {
		ArrayList<ForecastConditions> alForeCast = new ArrayList<ForecastConditions>();

		int itemCount = Integer.parseInt( path.evaluate("count("+PREFIX+"forecast_conditions)", doc));
		System.out.println("itemCount = "+itemCount);

		for( int i = 1; i<=itemCount; i++) {
			String location 	= PREFIX+"forecast_conditions["+i+"]/";
			String day_of_week= path.evaluate(location+"day_of_week/@data", doc );
			String low 			= path.evaluate(location+"low/@data", doc );
			String high 		= path.evaluate(location+"high/@data", doc );
			String icon 		= path.evaluate(location+"icon/@data", doc );
			String condition 	= path.evaluate(location+"condition/@data", doc );
			
			ForecastConditions fc = new ForecastConditions(day_of_week, low, high, icon, condition );
// 			System.out.println(fc );
			alForeCast.add(fc);
			
	// 		<forecast_conditions>
	// 			<day_of_week data="Sun" />
	// 			<low data="23" />
	// 			<high data="36" />
	// 			<icon data="/ig/images/weather/snow.gif" />
	// 			<condition data="Snow Showers" />
	// 		</forecast_conditions>

		}
		return alForeCast;
	}
	
}