package com.javarush.test.level33.lesson05.home04;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* Конвертация из одного класса в другой используя JSON
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

Два класса имеют одинаковые поля, но не имеют общий суперкласс. Пример, классы First и Second.
Реализовать логику метода convertOneToAnother, который должен возвращать объект класса resultClassObject,
значения полей которого равны значениям полей в объекте one.
Известно, что у классов есть Json аннотация, у которой значение проперти равно имени класса в нижнем регистре.
На примере класса First, это className="first"
Классы First и Second не участвуют в тестировании, они предоставлены в качестве тестовых данных.
*/
public class Solution
{
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);

    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        mapper.writeValue(stringWriter,one);
       ObjectNode objectNode = (ObjectNode) mapper.readTree(stringWriter.toString());
        objectNode.put("className", resultClassObject.getSimpleName());
        mapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
        StringReader stringReader = new StringReader(objectNode.toString());
        //return mapper.readValue(stringReader,resultClassObject);
        return null;


    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}
