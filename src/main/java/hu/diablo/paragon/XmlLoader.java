package hu.diablo.paragon;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Class for loading the .xml file.
 * @author Dyingsoul
 */

public class XmlLoader {
	/**
	 * Creating new logger.
	 */
	protected static Logger logger = LoggerFactory.getLogger(XmlLoader.class);
	/**
	 * Loads the database from paragonexp.xml file.
	 * @return Returns the List of levels.
	 * @throws ParserConfigurationException is the Exception upon ParserConfiguration.
	 * @throws SAXException is the Exception upon SAX.
	 * @throws IOException	is the Exception upon IO.
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
