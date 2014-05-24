import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Class for loading the .xml file.
 * @author Dyingsoul
 *
 */

public class XmlLoader {
	/**
	 * Loads the database from paragonexp.xml file.
	 * @return Returns the List of levels.
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static NodeList getLevels() throws ParserConfigurationException,
			SAXException, IOException {
		
		InputStream in = XmlLoader.class.getResourceAsStream("/paragonexp.xml");
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
		Document doc = dBuilder.parse(in);

		NodeList levels = doc.getElementsByTagName("level");

		return levels;

	}
}
