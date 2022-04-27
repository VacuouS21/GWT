package com.server.com.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForCheckWellWithName {
    public static ResultSet isForCheckWell( String wellName, Connection connection){
        String sql="SELECT EXISTS(SELECT id FROM well WHERE name=(?))";
        ResultSet checklWell=null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, wellName);
            checklWell=statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checklWell;
    }
    public static void createWell(String wellName,Connection connection){
        String newWell ="INSERT INTO well  VALUES (null,(?))";

        try {
            PreparedStatement statement = connection.prepareStatement(newWell);
            statement.setString(1, wellName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
