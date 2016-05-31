// XMLParser.java parses the XML file in ASSETS directory and creates the essential HashMap for the game

package APP;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class XMLParser {
    private HashMap definitionMap;

    public XMLParser() {
        try {
            // Parse the definitions file
            File masterFile = new File("src/ASSETS/definitions.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document parsedMasterFile = docBuilder.parse(masterFile);
            parsedMasterFile.getDocumentElement().normalize();

            NodeList definitionList = parsedMasterFile.getElementsByTagName("word");
            definitionMap = new HashMap();

            // Store English/German key-value pairs into 'definitionMap'
            for (int i = 0; i < definitionList.getLength(); i++) {
                Node node = definitionList.item(i);
                Element element = (Element) node;
                definitionMap.put(element.getElementsByTagName("english").item(0).getTextContent(),
                        element.getElementsByTagName("german").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap getDefinitionMap(){
        return this.definitionMap;
    }
}
