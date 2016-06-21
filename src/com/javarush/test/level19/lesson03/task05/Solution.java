package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static
    {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static class DataAdapter implements RowItem {

        Customer cu;
        Contact co;

        public DataAdapter(Customer customer, Contact contact)
        {
            this.cu=customer;
            this.co=contact;
        }

        @Override
        public String getCountryCode()
        {
            String code="";
            for (Map.Entry<String,String> pair: countries.entrySet())
            {
                if (pair.getValue().equals(cu.getCountryName()))
                {
                    code= pair.getKey();
                }

            }
            return code;

        }

        @Override
        public String getCompany()
        {
            return cu.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            return co.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName()
        {
            return co.getName().split(", ")[0];
        }

        @Override
        public String getDialString()
        {
            String phone =co.getPhoneNumber();
            return "callto://" +phone.replaceAll("[()-]","");
        }


    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }



    public static void main(String[] args)
    {
        Customer cu = new Customer()
        {
            @Override
            public String getCompanyName()
            {
                return "My Company";
            }

            @Override
            public String getCountryName()
            {
                return "Ukraine";
            }
        };

        Contact contact = new Contact()
        {
            @Override
            public String getName()
            {
                return "Kirayn, Saas";
            }

            @Override
            public String getPhoneNumber()
            {
                return "+38(093)197-03-84";
            }
        };

        RowItem ra = new DataAdapter(cu,contact);
        System.out.println(ra.getCompany());
        System.out.println(ra.getContactFirstName());
        System.out.println(ra.getContactLastName());
        System.out.println(ra.getDialString());
        System.out.println(ra.getCountryCode());


    }
}