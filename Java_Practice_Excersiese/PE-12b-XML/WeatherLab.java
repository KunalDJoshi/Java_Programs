import java.util.ArrayList;
import javax.swing.*;
import java.net.*;
import java.io.*;

// URI:  http://www.google.com/ig/api?hl=en&weather=New+York
// Language=Spanish: &hl=es   =German: &hl=de    =Croatian:  &hl=hr    =French: &hl=fr
// Calgary, AB = has a zip code of "T1X 1E1"

/**
   This program returns weather information.
	Data is in the Google API Weather format.
	Input is taken from the command line, and can be either from a file for testing purposes, 
	or from a zip code, or city state, city/country.  
	This program can tell the difference between an existing file and Zipcode/City-State/City-Country combinationT1X 1E1
   It prints out the items that are described in the XML file.
*/
public class WeatherLab extends JFrame
{
   public static void main(String[] args) throws Exception
   {
		Weather climate = null;
		
		String inputString = "14534.xml";
		if ( args.length > 0 ) {
			inputString = "";
			for( String item : args ){
				inputString += item+" ";
			}
			inputString = inputString.trim();
		}

      WeatherParser parser = new WeatherParser();

		if ( (new File(inputString)).isFile() ) {
			System.out.println("Using the file: "+inputString);
			climate = parser.parse(inputString);
		} else {
			System.out.println("Using a URL containing: "+inputString);
			inputString = URLEncoder.encode(inputString, "UTF-8");
			URL website = new URL("http://www.google.com/ig/api?weather="+inputString);		
			URLConnection uc = website.openConnection();
			InputStream is = uc.getInputStream();
			climate = parser.parse( is );
		}

		System.out.println( "\nWeather conditions are: \n" + climate );

   }
}
