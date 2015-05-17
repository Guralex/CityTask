package game;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser implements Parsing{



public TreeSet<String> parse(Object obj){
		
	
	TreeSet<String> set = new TreeSet<String>();
	try
        {
			
            File fXmlFile = new File("src\\main\\resources\\city.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        	Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
         
        	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         
        	NodeList nList = doc.getElementsByTagName("City");
         
        	
        	System.out.println("------------"+nList.getLength()+"----------------");
         
        	for (int temp = 0; temp < nList.getLength(); temp++) {
         
        		Node nNode = nList.item(temp);
         
        		
         
        		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
         
        			Element eElement = (Element) nNode;
           			set.add(eElement.getAttribute("Name").toLowerCase());
        			
         
        		}
        	}
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
		
		return set;
	}


	
}
