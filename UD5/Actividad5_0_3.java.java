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

public class Actividad5_0_3 {
	
private static final String RUTA_SALIDA= "./src/";
	
	public static void main(String[] args) {
		
		// Proceso de creación del objeto en memoria
		Document document = crearDocumentLibro();
		
		// Almacenamiento en fichero de texto
		guardarDocument(document);
				
	}
	
	 protected static Document crearDocumentLibro() {
		 
		 // Se declara el tipo de objeto a devolver
		 Document document = null;
		 
		 try {
			 //1. Se obtiene una instancia de la clase DocumentBuilderFactory
			 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			 DocumentBuilder db;
			
				
			 //2. Se obtiene una instancia de la clase DocumentBuilder
			 db = dbf.newDocumentBuilder();
		
			
			 /*3. Se crea un objecto tipo Document, 
				que representará en memoria el objeto XML
			  */
			 document = db.newDocument();
			
			/*4. Creamos los objetos que heredan de la superinterfaz Node: 
			 * Element(elementos), Attr(atributos) y Text(textos)
			 */
			
			// Se crea el objeto Element "expedientes"
			Element elementExpedientes= document.createElement("expedientes");
			
			Element elementExpediente= document.createElement("expediente");
			
			// Se crea el objeto Element "titulacion"
			Element elementTitulacion= document.createElement("titulacion");
			
			// Se crea el objeto Element "estudiante"
			Element elementEstudiante= document.createElement("estudiante");
			// Se crea el objeto Element "modulos"
			Element elementModulos= document.createElement("modulos");
			// Se crea el objeto Element "modulo"
			Element elementModulo= document.createElement("modulo");

			// Se crea el objeto Attr "nombre"
			Attr attibuteNombre = document.createAttribute("nombre");
			// Se crea el objeto Attr "aprobado"
			Attr attibuteAprobado = document.createAttribute("aprobado");
			// Se crea el objeto Attr "curso"
			Attr attibuteCurso = document.createAttribute("curso");

			// Se modifica el valor de los atributos 
			attibuteNombre.setValue("Sistemas Informáticos");
			attibuteAprobado.setValue("true");
			attibuteCurso.setValue("Primero");
			
			// Se crea el Text 
			Text textTitulacion = document.createTextNode("DAM");
			Text textEstudiante = document.createTextNode("Ainhoa Gárate Lizarraga");
			
			
			/*5. Construimos las relaciones jerarquicas del arbol XML
			 * en orden de las ramificaciones hacia la raíz del documento XML
			 */
			
			// Se añaden los hijos del elemento "titulo"
			//elementTitulacion.appendChild(textTitulacion);
			
			// Se añaden los hijos del elemento "expedientes"
			elementExpedientes.appendChild(elementExpediente);
			elementExpediente.appendChild(elementTitulacion);
			elementExpediente.appendChild(elementEstudiante);
			elementExpediente.appendChild(elementModulos);
			elementModulos.appendChild(elementModulo);

			
			// Sel añaden los atributos al elemento "modulo"
			elementModulo.setAttributeNode(attibuteNombre);
			elementModulo.setAttributeNode(attibuteAprobado);
			elementModulo.setAttributeNode(attibuteCurso);

			
			// Se añade elemento raíz libro como hijo del elemento Document
			document.appendChild(elementExpedientes);
			

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return document;
			
	 }
	

	 
	 private static void guardarDocument(Document document){
			
	 	/* 1. Se crea un objeto DOMSource que permite crear un objeto
	 	 * en memoria a partir del arbol creado en el objeto Document
	 	 */
	 	DOMSource domSource = new DOMSource(document);
	 	
		try {
		
		 	//2. Se crea un objeto FileWriter para escribir en la ruta del fichero "estudiantes5_0_3.xml"
		 	FileWriter fileWriter;
		
			fileWriter = new FileWriter(RUTA_SALIDA + "estudiantes5_0_3.xml");
			
		 	
		 	/*3. Se crea un objeto de la clase StreamResult y se le pasa como 
		 	 * parámetro el objeto fileWriter. StreamResult adaptará el objeto
		 	 * fileWriter para que almacene XML
		 	*/
		 	StreamResult streamResult = new StreamResult(fileWriter);
		 	
		 	/* 4.,5., Las clases TransformerFactory y Transformer sirven 
		 	 * para volcar el objeto de la clase DOMSource en el fichero indicado
		 	*/
		 	
		 	//4. Se crea una instancia de la clase TransformerFactory
		 	TransformerFactory transformerFactory = TransformerFactory.newInstance();
		 	
		 	//5. Se crea una instancia de la clase Transformer
		 	Transformer transformer = transformerFactory.newTransformer();
		 	
		 	/*6. Se invoca al método setOutputProperty, se modifica el valor de la
		 	propieda OutputKeys.INDENT, se pone a "yes" para 
		 	que el documento XML aparezca sangrado y no en una única línea
		 	*/
		 	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		 	
		 	/*7. Se invoca al método transform y se le pasan los parámetros
		 	 * domSource, streamResult
		 	 */
		 	transformer.transform(domSource, streamResult);
		 	
		 	//8. Se cierra el flujo de escritura al fichero
		 	fileWriter.close();
	 	
		} catch (IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
