package com.server.com.utility;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewDatabase {
    private static Connection connection;

    public static void createDatabase(String pass) {

        try {
            connection = null;
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new JDBC());
            // Выполняем подключение к базе данных
            connection = DriverManager.getConnection(pass);
            Statement statmt = connection.createStatement();
            statmt.executeUpdate(

                    "CREATE TABLE IF NOT EXISTS well(" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "name VARCHAR(32) NOT NULL)" );
            statmt.executeUpdate("CREATE TABLE IF NOT EXISTS equipment(" +
                    "  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "name VARCHAR(32) NOT NULL," +
                    "  well_id INTEGER NOT NULL," +
                    "  FOREIGN KEY(well_id) REFERENCES well(id))");
            if(connection!=null) connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Таблица создана или уже существует.");
    }

    /*
    public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

		System.out.println("Таблица создана или уже существует.");
	   }*/
}
