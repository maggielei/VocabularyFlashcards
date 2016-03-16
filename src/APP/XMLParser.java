package APP;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class XMLParser {
    public static void main(String[] args) {
        try{
            // Parse the definitions file
            File masterFile = new File("src/vocabularyflashcards/APP/definitions.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document parsedMasterFile = docBuilder.parse(masterFile);
            parsedMasterFile.getDocumentElement().normalize();

            NodeList definitionList = parsedMasterFile.getElementsByTagName("word");
            HashMap definitionMap = new HashMap();

            for(int i = 0; i < definitionList.getLength(); i++){
                Node node = definitionList.item(i);
                Element element = (Element) node;
                definitionMap.put(element.getElementsByTagName("english").item(0).getTextContent(),
                                  element.getElementsByTagName("german").item(0).getTextContent());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
