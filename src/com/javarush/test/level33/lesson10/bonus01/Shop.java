package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 9/26/16.
 */

@XmlRootElement
@XmlType(name = "shop")
public class Shop
{
    //@XmlElement(name ="names")
    @XmlElementWrapper(name ="goods", nillable = true)
    public  List<String> list = new ArrayList<>();

    @XmlElement(name ="count")
    int cnt;

    @XmlElement(name ="profit")
    double prft;

    @XmlElement(name ="secretData")
    public  List<String> sdata = new ArrayList<>();

    public Shop()
    {}

    public static void main(String[] args)
    {
        try
        {
            Shop clazz = new Shop();
            StringWriter sw = new StringWriter();
            clazz.list.add("S1");
            clazz.list.add("S2");
            clazz.cnt = 12;
            clazz.prft = 123.4;
            clazz.sdata.add("String1");
            clazz.sdata.add("String2");
            clazz.sdata.add("String3");
            clazz.sdata.add("String4");
            /*JAXBContext context = JAXBContext.newInstance(Shop.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(clazz, sw);
            System.out.println(sw.toString());*/
          String str=  Solution.toXmlWithComment(clazz,null,null);
            System.out.println(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
