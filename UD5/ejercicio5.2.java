package ejercicio5_20;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ejercicio5_20 {
	
private static final String RUTA_SALIDA= "./src/";
	
	public static void main(String[] args) {
		
		// Proceso de creación del objeto en memoria
		Document document = crearDocumentEstudiantes();
		
		// Almacenamiento en fichero de texto
		guardarDocument(document);
				
	}
	
	 protected static Document crearDocumentEstudiantes() {
		 
		 Document document = null;
		 
		 try {
			 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			 DocumentBuilder db;
			
			 db = dbf.newDocumentBuilder();
			 document = db.newDocument();

			
			// Elemento raíz
			Element elementAnimales = document.createElement("animales");
			
			Element elementAnimal = document.createElement("animal");
	
			// Elemento nombreComun
			Element elementNombreComun = document.createElement("nombreComun");
			Text textNCom = document.createTextNode("Tigre de Bengala");
			elementNombreComun.appendChild(textNCom);
			// Elemento nombre cientifico
			Element elementNombreCientifico = document.createElement("nombreCientifico");
			Text textNcien = document.createTextNode("Panthera tigris tigris");
			elementNombreCientifico.appendChild(textNcien);
			//Elemento hábitat
			Element elementHabitat = document.createElement("habitat");
			Text textHab = document.createTextNode("Bosque tropical");
			elementHabitat.appendChild(textHab);

			//Nodo continentes
			Element elementContinentes = document.createElement("continentes");
			// Nodos 
			Element elementContinente= document.createElement("continente");
			
			
			//Atributo continente
			Attr attibuteCont = document.createAttribute("continente");
			// Atributo "nº de especies"
			Attr attibuteNumeroEspecies = document.createAttribute("numeroEspecies");
			// Atributo "peligro"
			Attr attibutePeligro = document.createAttribute("peligroExtinción");
		
			// Se modifica el valor de los atributos 
			attibuteCont.setValue("Asia");
			attibuteNumeroEspecies.setValue("3.800 ");
			attibutePeligro.setValue("Si");
	

			// Se añaden los hijos del elemento "animales"
			elementAnimal.appendChild(elementNombreComun);
			elementAnimal.appendChild(elementNombreCientifico);
			elementAnimal.appendChild(elementHabitat);
			elementAnimales.appendChild(elementAnimal);
			// Se le añaden los atributos al elemento "continente"
			elementContinente.setAttributeNode(attibuteCont);
			elementContinente.setAttributeNode(attibuteNumeroEspecies);
			elementContinente.setAttributeNode(attibutePeligro);
			
			
			elementAnimal.appendChild(elementContinentes);
			elementContinentes.appendChild(elementContinente);
			
			
			
			
			
			
			
			//Animal2
			Element elementAnimal2 = document.createElement("animal");
			
			// Elemento nombreComun
			Element elementNombreComun2 = document.createElement("nombreComun");
			Text textNCom2 = document.createTextNode("Mamba negra");
			elementNombreComun2.appendChild(textNCom2);
			// Elemento nombre cientifico
			Element elementNombreCientifico2 = document.createElement("nombreCientifico");
			Text textNcien2 = document.createTextNode("Dendroaspis polylepsis");
			elementNombreCientifico2.appendChild(textNcien2);
			//Elemento hábitat
			Element elementHabitat2 = document.createElement("habitat");
			Text textHab2 = document.createTextNode("Sabana");
			elementHabitat2.appendChild(textHab2);

			//Nodo continentes
			Element elementContinentes2 = document.createElement("continentes");
			// Nodos 
			Element elementContinente2= document.createElement("continente");
			
			
			//Atributo continente
			Attr attibuteCont2 = document.createAttribute("continente");
			// Atributo "nº de especies"
			Attr attibuteNumeroEspecies2 = document.createAttribute("numeroEspecies");
			// Atributo "peligro"
			Attr attibutePeligro2 = document.createAttribute("peligroExtinción");
		
			// Se modifica el valor de los atributos 
			attibuteCont2.setValue("África");
			attibuteNumeroEspecies2.setValue("30.900 ");
			attibutePeligro2.setValue("No");
	

			// Se añaden los hijos del elemento "animales"
			elementAnimal2.appendChild(elementNombreComun2);
			elementAnimal2.appendChild(elementNombreCientifico2);
			elementAnimal2.appendChild(elementHabitat2);
			elementAnimales.appendChild(elementAnimal2);
		

			// Se le añaden los atributos al elemento "continente"
			elementContinente2.setAttributeNode(attibuteCont2);
			elementContinente2.setAttributeNode(attibuteNumeroEspecies2);
			elementContinente2.setAttributeNode(attibutePeligro2);
			
			
			elementAnimal2.appendChild(elementContinentes2);
			elementContinentes2.appendChild(elementContinente2);
			
			// Se añade elemento raíz animales como hijo del elemento Document
			document.appendChild(elementAnimales);
			

			
			
	
			
			

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return document;
			
	 }
	

	 
	 private static void guardarDocument(Document document){
			
	 	
	 	DOMSource domSource = new DOMSource(document);
	 	
		try {
		
		 	//Creo un objeto FileWriter para escribir en la ruta del fichero "animales.xml"
		 	FileWriter fileWriter;
		
			fileWriter = new FileWriter(RUTA_SALIDA + "animales.xml");
			
		 	StreamResult streamResult = new StreamResult(fileWriter);

		 	TransformerFactory transformerFactory = TransformerFactory.newInstance();

		 	Transformer transformer = transformerFactory.newTransformer();

		 	transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		 	transformer.transform(domSource, streamResult);

		 	fileWriter.close();
	 	
		} catch (IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}