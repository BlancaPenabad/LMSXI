package actividad5_0_2;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class actividad5_0_4 {
private static final String RUTA_SALIDA= "./src/";
	
	public static void main(String[] args) {
	
		
		Document document= actividad5_0_3.crearDocumentLibro();
		
		String ExpedientesXml = getExpedientesXml(document);
		
		almacenamientoBd(ExpedientesXml);
		
		Document documentLeido =lecturaBd();
		
		String expedientesXMLLeido = getExpedientesXml(documentLeido);
		
		System.out.println(expedientesXMLLeido);
			
	}
	
	
	 
	 private static Connection abrirConexion() {
		 
		String url = null;
		Connection con = null;
		String database = "Institutos";
		
		url = "jdbc:mysql://localhost:3306/" + database;
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, "root", "root");
			
			System.out.println("Conexión creada");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return con;
								
	 }
	 
	 
	 private static void cerrarConexion(Connection con) {
		 	
		try {
			// Se cierra la conexión
			con.close();
			
			System.out.println("Conexión cerrada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
	 }
	 
	 private static Document lecturaBd() {
		
		 Connection conexion = abrirConexion();
		 
		
		 String sql = "SELECT * from institutos where nombre= ?";
		 
		 Document document = null;
		 try {
			 
			
			PreparedStatement ps = conexion.prepareStatement(sql);
			
			String nombre = "San Clemente";
					
			ps.setString(1, nombre);
		
			ResultSet resultSet = ps.executeQuery();
			
			resultSet.next();
			
			String ExpedientesXml = resultSet.getString("xml");
			
			cerrarConexion(conexion);
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			StringReader sr = new StringReader(ExpedientesXml);
			
			InputSource inputS= new InputSource(sr);
			
			document = dBuilder.parse(inputS);
				
		} catch (SQLException | ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return document;
		 
	 }
	 
	 
	 private static void almacenamientoBd(String ExpedientesXml) {
		 
			Connection con = abrirConexion();
			
			String sql = "INSERT INTO institutos(nombre,xml) VALUES(?,?)";
			PreparedStatement ps;
			try {
				
				ps = con.prepareStatement(sql);
				
				ps.setString(1, "San Clemente");
				
				ps.setString(2, ExpedientesXml);
				
				ps.executeUpdate();
				
				cerrarConexion(con);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	 }
	 
	 
	 private static String getExpedientesXml(Document document) {
		 
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			
			Transformer transformer;
			String ExpedientesXml= null;
			try {
				
				transformer = transformerFactory.newTransformer();
				
				StringWriter stringWriter = new StringWriter();
				
				DOMSource domSource = new DOMSource(document);
				
				transformer.transform(domSource, new StreamResult(stringWriter));
				
				ExpedientesXml = stringWriter.toString();
			} catch (TransformerException e) {
				
				e.printStackTrace();
			}
			
			
			return ExpedientesXml;
		 
	 }
	 

}
