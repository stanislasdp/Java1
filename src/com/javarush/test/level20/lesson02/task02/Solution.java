package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class
Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
           // OutputStream outputStream = new FileOutputStream("/home/stas/test/output.txt");
            InputStream inputStream = new FileInputStream("/home/stas/test/input.txt");


       /*     JavaRush javaRush = new JavaRush();
            SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
            User user = new User();
            user.setFirstName("Stas");
            user.setLastName("Kiryan");
            user.setMale(true);
            user.setBirthDate(sf.parse(String.valueOf("10/22/1988")));
            user.setCountry(User.Country.UKRAINE);

            User use2 = new User();
            use2.setFirstName("AlyonA");
            use2.setLastName("Teteryatnik");
            use2.setMale(true);
            use2.setBirthDate(sf.parse(String.valueOf("01/10/1987")));
            use2.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user);
            javaRush.users.add(use2);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();*/

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject.users.get(0).getFirstName());
            System.out.println(loadedObject.users.get(0).getBirthDate());
            System.out.println(loadedObject.users.get(1).getFirstName());

            JavaRush loadedObject2 = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject2.users.get(0).getFirstName());
            System.out.println(loadedObject2.users.get(0).getBirthDate());
            System.out.println(loadedObject2.users.get(1).getFirstName());

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            //outputStream.close();
           inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        SimpleDateFormat sm = new SimpleDateFormat("MM dd yyyy");

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter pi = new PrintWriter(outputStream);
           if (users!=null)
               pi.println("@");
           {
               for (User u: users)
               {
                   if (u!=null)
                   {
                       pi.print(u.getLastName()+",");
                       pi.print(u.getFirstName()+",");
                       pi.print(u.isMale()+",");
                       pi.print(sm.format(u.getBirthDate())+",");
                       pi.print(u.getCountry());
                       pi.println();
                   }

               }
           }
            pi.flush();

        }

        public void load(InputStream inputStream) throws Exception
        {
            DataInputStream di = new DataInputStream(inputStream);
            Scanner sc = new Scanner(new InputStreamReader(inputStream));

            SimpleDateFormat sf = new SimpleDateFormat("MM dd yyyy");
            String curr_line = sc.nextLine();


             if (curr_line.equals("@") )
             {;
                 while (sc.hasNextLine())
                 {
                     String next_line = sc.nextLine();

                     if (next_line.equals("@"))
                     {
                       sc.reset();
                        inputStream.close();
                         break;
                     }
                     else
                     {
                         String [] user = next_line.split(",");
                         User new_loaded_user = new User();
                         new_loaded_user.setLastName(user[0]);
                         new_loaded_user.setFirstName(user[1]);
                         new_loaded_user.setMale(user[2].equals("true"));
                         new_loaded_user.setBirthDate(sf.parse(user[3]));
                         new_loaded_user.setCountry(User.Country.valueOf(user[4]));
                         users.add(new_loaded_user);
                     }
                 }

             }


        }
    }
}
