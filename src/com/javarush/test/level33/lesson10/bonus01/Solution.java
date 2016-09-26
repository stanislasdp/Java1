package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.validation.Schema;
import java.io.StringWriter;

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
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment)
    {
        class MyMarshallerListener extends Marshaller.Listener
        {
            private XMLStreamWriter xsw;

            public  MyMarshallerListener(XMLStreamWriter xsw)
            {
                this.xsw = xsw;
            }
            @Override
            public void beforeMarshal(Object source)
            {
                try {
                    xsw.writeComment("Before comment");
                    //xsw.writeCData("11");
                    //xsw.writeComment("Before:  " + source.toString());
                } catch(XMLStreamException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterMarshal(Object source)
            {
                try {
                    xsw.writeComment("After comment");
                    //xsw.writeComment("Before:  " + source.toString());
                } catch(XMLStreamException e)
                {
                    e.printStackTrace();
                }
            }
        }

        StringWriter stringWriter = new StringWriter();
        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        XMLStreamWriter xsw = null;
        try
        {
            xsw = xof.createXMLStreamWriter(stringWriter);
        }
        catch (XMLStreamException xmle)
        {
            xmle.printStackTrace();
        }

        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setListener(new MyMarshallerListener(xsw));
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);



            marshaller.marshal(obj, stringWriter);
        }
        catch (JAXBException je)
        {
            je.printStackTrace();
        }
        ;
        return stringWriter.toString();
    }

    //http://info.javarush.ru/JavaRush_tasks_discussion/2015/01/15/level33-lesson10-bonus01.html
}
