package actividad5_0_1;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




	public class Actividad5_0_1 {
	


		public static void main(String[] args) {
			String filexml = "./src/actividad5_0_1/estudiantes.xml";
			
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(filexml);
				
				procesaAprobado(doc);
				
			} catch (ParserConfigurationException | SAXException | IOException e) {
				
				e.printStackTrace();
			}
		}
		
		private static void procesaAprobado (Document doc) {
			Element expedientes = doc.getDocumentElement();
			
			NodeList listaModulos = expedientes.getElementsByTagName("modulos");
			Element e = (Element) listaModulos.item(1);
			NodeList modulos = e.getElementsByTagName("modulo");
		
			
			
			for (int i = 0; i < modulos.getLength(); i++) {
				Element mod = (Element)modulos.item(i);
				//if (estudiante.getNodeType() == Node.ELEMENT_NODE) {
				
				Boolean aprobado = Boolean.parseBoolean(mod.getAttribute("aprobado"));
			
				if(aprobado) {
					System.out.println(mod.getAttribute("nombre")); //.getTextContent());
					
				}
				
				
				
				}
				
			}
		}