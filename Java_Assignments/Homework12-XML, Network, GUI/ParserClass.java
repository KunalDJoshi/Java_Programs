/**
 *ParserClass class has ParserClass constructor. 
 *This class will .
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-11-26
 */
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.stream.*;
import javax.xml.xpath.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class ParserClass {

    private DocumentBuilder builder;
    private XPath path;
    
	private String prefix = "//query/results/";
    private ArrayList<Results> results = new ArrayList<>();
	private String humReadDate = "";
	private String fName;


    public ArrayList<Results> parse() {
        return results;
    } 

    /**
    This is constructor of ParserClass class.
    @param String fileName
    */ 
    public ParserClass(String fileName) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException
     {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        builder = dbf.newDocumentBuilder();
        XPathFactory xpfactory = XPathFactory.newInstance();
        path = xpfactory.newXPath();
		  File file = new File(fileName);
        Document doc = builder.parse(file);
        resultMethod(doc);

    }

   /**
      Parses an XML file containing an item list.
      @param doc the name of the document
   */
    public void resultMethod(Document doc) throws XPathExpressionException {
          
    
        int itemCount = Integer.parseInt(path.evaluate("count(" + prefix + "Result)", doc));
        for (int i = 1; i <= itemCount; i++) {
            String loc1 = prefix + "Result[" + i + "]/";
            String title = path.evaluate(loc1 + "Title", doc);
            String address = path.evaluate(loc1 + "Address", doc);
            String phone = path.evaluate(loc1 + "Phone", doc);
            
            String loc2 = prefix + "Result[" + i + "]/Rating/";
            String avgRating = path.evaluate(loc2 + "AverageRating", doc);
            String totRating = path.evaluate(loc2 + "TotalRatings", doc);
            String date = path.evaluate(loc2 + "LastReviewDate", doc);
            humReadDate = dateConversion(date);
            Rating rate = new Rating(avgRating, totRating, humReadDate);
            Results res = new Results(title, address, phone, rate);
            results.add(res);

        }
    }
    
    
   /**
      This method writes XML file.
      @param String f, ArrayList<Results> res
   */
    public void writeXML(String f, ArrayList<Results> res) throws FileNotFoundException, XMLStreamException {
        fName = f + "_out.xml";

        ArrayList<Results> results = res;

        XMLStreamWriter xsw = XMLOutputFactory.newInstance().createXMLStreamWriter(
                new OutputStreamWriter(new FileOutputStream(new File(fName))));

        xsw.writeStartDocument();
        xsw.writeStartElement("Restaurant");
        for (Results resu : results) {

            xsw.writeStartElement("restaurant");
            xsw.writeStartElement("Title");
            xsw.writeCharacters(resu.getTitle());
            xsw.writeEndElement();
            xsw.writeStartElement("Address");
            xsw.writeCharacters(resu.getAddress());
            xsw.writeEndElement();
            xsw.writeStartElement("Phone");
            xsw.writeCharacters(resu.getPhone());
            xsw.writeEndElement();
            xsw.writeStartElement("Ratings");
            xsw.writeStartElement("AverageRatings");
            xsw.writeCharacters(resu.rating.getAvgRating());
            xsw.writeEndElement();
            xsw.writeStartElement("TotalRatings");
            xsw.writeCharacters(resu.rating.getTotRating());
            xsw.writeEndElement();
            xsw.writeStartElement("LastReviewDate");
            xsw.writeCharacters(resu.rating.getDate());
            xsw.writeEndElement();
            xsw.writeEndElement();
            xsw.writeEndElement();
        }
        xsw.writeEndElement();

        xsw.flush();
        xsw.close();
    }

    
   /**
      This method is for converting date into  human readable format.
      @param String date
      @returns convDate
   */
    public String dateConversion (String date){
        String convDate;
        if (!date.equals("")){
            long lstr = Long.parseLong(date);
            long ms = lstr*1000;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            convDate = sdf.format(new Date(ms));
        }
        else{
            return "N/A";
        }
        return convDate;
    }


}



