package com.javarush.test.level31.lesson15.big01;

public enum Operation {
    CREATE,
    ADD,
    REMOVE,
    EXTRACT,
    CONTENT,
    EXIT;


   /* public static String getAllValuestoString ()
    {
        StringBuilder sb = new StringBuilder();

        for (int i =0; i <Operation.values().length; i++)
        {
            sb.append(" - ");
            sb.append(Operation.values()[i].ordinal());
            if (i!= Operation.values().length-1)

                sb.append(", ");
        }
        return sb.toString().trim();
    }*/
}
