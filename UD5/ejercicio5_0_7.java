package ejercicio5_0_7;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejercicio5_0_7 {
	
	public static void main(String[] args) throws Exception{
		
		String xPathExpression = "//expediente[estudiante=\"Ferran Soler Puig\"]/modulos/modulo[@aprobado=\"true\"]";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File ("./src/ejercicio5_0_7/estudiantes.xml"));
		
		//Instancia de xPath
		XPath xpath = XPathFactory.newInstance().newXPath();
		
		NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, doc,  XPathConstants.NODESET);
		
		for (int i = 0; i < nodos.getLength(); i++) {
			
			Element e =(Element) nodos.item(i);
			
			System.out.println(e.getAttribute("nombre"));
			
		}
	}

}
