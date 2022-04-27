package com.server.com.services;

import com.server.com.utility.ForCheckWellWithName;
import com.server.com.utility.NameForEquipment;
import org.sqlite.JDBC;

import java.sql.*;

public class EquipmentService {

    //Количество оборудования для всех скважин, для уникальных имён.
    private static int countAllEquipment = 0;

    //Singletone
    private static EquipmentService instance = null;
    public static synchronized EquipmentService getInstance(String pathSQLDatabase) {
        if (instance == null)
            instance = new EquipmentService(pathSQLDatabase);
        return instance;
    }


 private String pathSQLDatabase="";
  

    //Работа с бд
    private EquipmentService(String pathSQLDatabase) {
      this.pathSQLDatabase=pathSQLDatabase;
    
    }

    //Создание n оборудования для скважины wellName
    public void createEquipment(String wellName, int countClientEquipment) {
    	 
    	  try {
    		  DriverManager.registerDriver(new JDBC());
    		  System.out.println(countClientEquipment);
    		  Connection connection = DriverManager.getConnection(pathSQLDatabase);
    	 
     
            //Создаём well с заданным wellName, если такой ещё нет
            if(!ForCheckWellWithName.isForCheckWell(wellName,connection).getBoolean(1)) {
                ForCheckWellWithName.createWell(wellName,connection);
            }
        //

        //Получение общего количества оборудования, для уникального имени.
        numCountAllEquipment(connection);

        //Нахождение id скважины по её имени, для дальнейшей записи в well_id у equipment
        int idWellWithClientName=findIdWithName(wellName,connection);

        if(idWellWithClientName==-1){
            System.out.println("Такая скважина отсутсвует");
        }
       else {
            //Создание ун. имени и запись в в базу
            for (int i = 0; i < countClientEquipment; i++) {

                //Генерируем имя.
                String nameUnique = NameForEquipment.createName(countAllEquipment);
                //Для уникального имени.
                countAllEquipment++;
                //Создаём оборудование.
                System.out.println("В цикле (номер)"+i+" "+idWellWithClientName +" "+ nameUnique);
                doNewEquipment(idWellWithClientName, nameUnique,connection);
            }
        }
        connection.close();
            
            
          } catch (SQLException e) {
              e.printStackTrace();
          }
    	  
    }

    //ВТорой выбор, для подсчёта количества оборудования на скважине wellName
    public String countEquipment(String wellName) {
       
        //Работа с бд
        try {
        	DriverManager.registerDriver(new JDBC());
        	 String sql = "SELECT count() FROM equipment JOIN well w on w.id = equipment.well_id WHERE w.name=(?);";
        	 System.out.println(wellName);
   	        Connection connection = DriverManager.getConnection(pathSQLDatabase);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, wellName);
            int result= statement.executeQuery().getInt(1);
            connection.close();
            return("Кол-во оборудования на скважине " + wellName + ": " +result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return "Ошибка";

    }

    //подсчёт всего оборудования, для уникального имени
    private void numCountAllEquipment(Connection connection) {
        try {
            this.countAllEquipment = connection.createStatement().executeQuery("SELECT count() FROM equipment").getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Добавление новых оборудованием.
    private void doNewEquipment(int wellId,String equipmentName,Connection connection){
        String sqlForAddEquipment = "INSERT INTO equipment  VALUES (null,(?),(?))";
        try {
        System.out.println("Не в цикле "+wellId+ " "+equipmentName);
            PreparedStatement statement = connection.prepareStatement(sqlForAddEquipment);
            statement.setString(1, equipmentName);
            statement.setInt(2, wellId);
            statement.executeUpdate();
           
            //Выполняете сам запрос в базу.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Поиск Id скважины по её имени, для добавления новых оборудований к этой скважине.
    private int findIdWithName(String wellName,Connection connection){
        String sqlForNameWell = "SELECT id FROM well Where name =(?);";
        try {
        
   	       
   	       PreparedStatement statement = connection.prepareStatement(sqlForNameWell);
            statement.setString(1, wellName);
   	     
            return statement.executeQuery().getInt(1);
            //Выполняете сам запрос в базу.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
