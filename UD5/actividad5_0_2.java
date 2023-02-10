package actividad5_0_2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class Actividad5_0_2 extends DefaultHandler{
private StringBuffer sb;
	
	public static void main (String[] args) {
		
		
		
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		try {
			SAXParser parser = saxParserFactory.newSAXParser();
			DefaultHandler handler = new Actividad5_0_2();
			
			File f = new File("./src/actividad5_0_2/estudiantes.xml");
			
			parser.parse(f, handler);
			
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		sb = new StringBuffer();
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(qName.equals("estudiante")) {
			sb = new StringBuffer();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println(sb);
		if(qName.equals("estudiante")) {
			System.out.println(sb);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		sb.append(Arrays.copyOfRange(ch, start, start+length));
		
		
	}

}
