import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/*
 * @author: Tawfik Yasser
 * @ID: 20180075
 * @G: IS1
 * @Course: SOA
 */
public class Main {
	private static final String FILENAME = "C:\\Users\\tawfe\\eclipse-workspace\\A1\\src\\main\\java\\DatainXML.xml";
	public static boolean is_new = true;
	public static void main(String[] args) throws SAXException, IOException {
		
		//Main menu for the user
		int option = 0 ;
		System.out.println("------------------------------");
		System.out.println("Welcome to XML Application");
		System.out.println("1. Add new CD");
		System.out.println("2. Search for a CD");
		System.out.println("3. Get all CDs");
		Scanner oin = new Scanner(System.in);
		option = oin.nextInt();
		switch (option) {
			case 1: {
				add_cd();
				break;
			}
			case 2:{
				search_cd();
				break;
			}
			case 3:{
				get_cds();
				break;
			}
		}
		
	}
	
	public static void add_cd() throws SAXException, IOException {
		  //Asking the user to enter the number of CDs
		  int noc = 0;
		  Scanner in = new Scanner(System.in);
		  System.out.print("Enter the number of CDs: ");
		  noc = in.nextInt();

		  try {
			  
			  DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		      Document doc = null;
		      Element rootElement = null;
			  if(is_new) {
			      doc = docBuilder.newDocument();
			      rootElement = doc.createElement("Catalogue");		    	 
			      doc.appendChild(rootElement);
			      
			      is_new = false;
			  }else {
			        doc = docBuilder.parse(new File(FILENAME));
			        rootElement = doc.getDocumentElement();
			  }

		      Scanner xmlData = new Scanner(System.in);
		      
		      for(int i = 0 ; i < noc ; i++) {
			      //add elements
			      Element cd = doc.createElement("CD");
			      
			      Element title = doc.createElement("Title");
			      Element artist = doc.createElement("Artist");
			      Element country = doc.createElement("Country");
			      Element company = doc.createElement("Company");
			      Element price = doc.createElement("Price");
			      Element year = doc.createElement("Year");
			      rootElement.appendChild(cd);
			      
			      System.out.println("Adding the element #"+(i+1));
			      
			      System.out.println("Type the Title: ");
			      title.setTextContent(xmlData.nextLine());
			      cd.appendChild(title);
			      
			      System.out.println("Type the Artist: ");
			      artist.setTextContent(xmlData.nextLine());
			      cd.appendChild(artist);
			      
			      System.out.println("Type the Country: ");
			      country.setTextContent(xmlData.nextLine());
			      cd.appendChild(country);
			      
			      System.out.println("Type the Company: ");
			      company.setTextContent(xmlData.nextLine());
			      cd.appendChild(company);
			      
			      System.out.println("Type the Price: ");
			      price.setTextContent(xmlData.nextLine());
			      cd.appendChild(price);
			      
			      System.out.println("Type the Year: ");
			      year.setTextContent(xmlData.nextLine());
			      cd.appendChild(year);
			      

			      TransformerFactory transformerFactory = TransformerFactory.newInstance();
			      Transformer transformer = transformerFactory.newTransformer();

			      // pretty print
			      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			      DOMSource source = new DOMSource(doc);
			      

			      FileOutputStream output = new FileOutputStream("C:\\Users\\tawfe\\eclipse-workspace\\A1\\src\\main\\java\\DatainXML.xml");
			      StreamResult result = new StreamResult(output);
			      transformer.transform(source, result);
			      
		      }

		     
		  }catch (ParserConfigurationException | TransformerException e) {
		      e.printStackTrace();
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		  main(null);
		  
	}
	public static void search_cd() throws SAXException, IOException {
		
		  Scanner in = new Scanner(System.in);
		  System.out.println("Enter Title of Artist to search for: ");
		  String search_query = in.nextLine();
		  
		  boolean found = false;

		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  try {
		  dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(new File(FILENAME));
		  doc.getDocumentElement().normalize();
		
		  System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
		  System.out.println("------");
		  NodeList list = doc.getElementsByTagName("CD");
		
		  for (int temp = 0; temp < list.getLength(); temp++) {
		
		      Node node = list.item(temp);
		
		      if (node.getNodeType() == Node.ELEMENT_NODE) {
		
		          Element element = (Element) node;
		
		          String title = element.getElementsByTagName("Title").item(0).getTextContent();
		          String artist = element.getElementsByTagName("Artist").item(0).getTextContent();
		          String country = element.getElementsByTagName("Country").item(0).getTextContent();
		          String company = element.getElementsByTagName("Company").item(0).getTextContent();
		          String price = element.getElementsByTagName("Price").item(0).getTextContent();
		          String year = element.getElementsByTagName("Year").item(0).getTextContent();
		
			          if(title.equalsIgnoreCase(search_query) || artist.equalsIgnoreCase(search_query)) {
			        	  found = true;
				          System.out.println("Current Element #" + (temp+1) +": "+ node.getNodeName());
				          System.out.println("Title : " + title);
				          System.out.println("Artist : " + artist);
				          System.out.println("Country : " + country);
				          System.out.println("Company : " + company);
				          System.out.println("Price : " + price);
				          System.out.println("Year : " + year);
			          }
		          }
		      }
		
		  } catch (ParserConfigurationException | SAXException | IOException e) {
		      e.printStackTrace();
		  }	
		  main(null);
	}
	public static void get_cds() throws SAXException, IOException {
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  try {
		  dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(new File(FILENAME));
		  doc.getDocumentElement().normalize();
		
		  System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
		  System.out.println("------");
		  NodeList list = doc.getElementsByTagName("CD");
		
		  for (int temp = 0; temp < list.getLength(); temp++) {
		
		      Node node = list.item(temp);
		
		      if (node.getNodeType() == Node.ELEMENT_NODE) {
		
		          Element element = (Element) node;
		
		          String title = element.getElementsByTagName("Title").item(0).getTextContent();
		          String artist = element.getElementsByTagName("Artist").item(0).getTextContent();
		          String country = element.getElementsByTagName("Country").item(0).getTextContent();
		          String company = element.getElementsByTagName("Company").item(0).getTextContent();
		          String price = element.getElementsByTagName("Price").item(0).getTextContent();
		          String year = element.getElementsByTagName("Year").item(0).getTextContent();
		
		          System.out.println("Current Element #" + (temp+1) +": "+ node.getNodeName());
		          System.out.println("Title : " + title);
		          System.out.println("Artist : " + artist);
		          System.out.println("Country : " + country);
		          System.out.println("Company : " + company);
		          System.out.println("Price : " + price);
		          System.out.println("Year : " + year);
		          
		          }
		      }
		
		  } catch (ParserConfigurationException | SAXException | IOException e) {
		      e.printStackTrace();
		  }	
		  main(null);
	}

}
