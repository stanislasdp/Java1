package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        String incoming_file_name = args[0];
        String outgoing_file_name = args[1];

        ArrayList<String> arr_incom_file = new ArrayList<>();


        FileInputStream fi = new FileInputStream(incoming_file_name);
        FileOutputStream fo = new FileOutputStream(outgoing_file_name);
        byte [] buff = new byte[fi.available()];
        fi.read(buff);
        String s = new String(buff,Charset.forName("UTF-8"));
        FileWriter fw = new FileWriter(outgoing_file_name);
        fo.write(s.getBytes("windows-1251"));
        fi.close();
        fo.close();

    }
}
