package lesson10_bonus01;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.
Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
 */

public class Solution1
{
	public static String toXmlWithComment(Object obj, String tagName, String comment)
	{
		Document document = null;
		StringWriter stringWriter = new StringWriter();
		StringBuilder sb = new StringBuilder();
		
		  try
		  {
			  JAXBContext context = JAXBContext.newInstance(obj.getClass());
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				marshaller.marshal(obj, stringWriter);
				
				String str = stringWriter.toString();
				Pattern patternForTag = Pattern.compile("<"+tagName);
				Matcher matherForTag = patternForTag.matcher(str);
				List<Integer> tags = new ArrayList<>();
						
				while (matherForTag.find())
				{
					tags.add(matherForTag.start());
				}
				Pattern patternForCDATA = Pattern.compile("<!\\[CDATA\\[.*?\\]\\]>");
				//разобраться с regex
				Matcher matherForCDATA = patternForCDATA.matcher(str);
				
				while (matherForCDATA.find())
				{
					int start = matherForCDATA.start();
					int end = start + matherForCDATA.group().length();
					
				
					for (int i =0; i <tags.size(); i++)
					{
						//if founded tag inside CDATA tag we remove tag's position from the list
						if (tags.get(i)> start && tags.get(i)< end)
						{
							tags.remove(i);
						}
					}
				}
				//enter comments before tags
				sb.append(str);
				
	
				for (int i = tags.size()-1; i >= 0; i--) 
				{
		            sb.insert(tags.get(i), "<!--"+comment+"-->\n");
		        }

		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
		  }
		return sb.toString();
		//return stringWriter.toString();
	}
}
