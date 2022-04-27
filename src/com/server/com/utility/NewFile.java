package com.server.com.utility;

import java.io.File;

public class NewFile {
    public static void createFile(String fileName){
        try {
            // Возьмите файл
            File f = new File(fileName);
            System.out.print(f.getAbsolutePath());
            //Создайте новый файл
            // Убедитесь, что он не существует
            if (f.createNewFile())
                System.out.println("Файл создан");
            else
                System.out.println("Файл существует");
           
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
