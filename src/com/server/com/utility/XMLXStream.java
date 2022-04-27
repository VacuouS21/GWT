/*
 * package com.server.com.utility;
 * 
 * //import com.thoughtworks.xstream.XStream;
 * 
 * import com.server.com.xml.Well; import thoughtworks.xstream.XStream; import
 * com.server.com.xml.Equipment; import org.sqlite.JDBC;
 * 
 * import java.io.FileWriter; import java.io.IOException; import java.sql.*;
 * import java.util.ArrayList;
 * 
 * public class XMLXStream { public static void outputXML(String pathName,String
 * pathSQLDatabase){ XStream xstream = new XStream(); xstream.alias("well",
 * Well.class); xstream.alias("equipment", Equipment.class);
 * xstream.useAttributeFor(Well.class,"name");
 * xstream.useAttributeFor(Well.class,"id"); xstream.aliasAttribute("name",
 * "name"); xstream.useAttributeFor(Equipment.class,"name");
 * xstream.useAttributeFor(Equipment.class,"id"); NewFile.createFile(pathName);
 * 
 * String sqlForNameWell = "SELECT * FROM well;"; String
 * sqlForEquipment="Select * FROM equipment WHERE well_id=(?);";
 * 
 * 
 * try {
 * 
 * DriverManager.registerDriver(new JDBC()); Connection connection =
 * DriverManager.getConnection(pathSQLDatabase); PreparedStatement statementWell
 * = connection.prepareStatement(sqlForNameWell); PreparedStatement
 * statementEquipment = connection.prepareStatement(sqlForEquipment); //Масив
 * well ResultSet rs = statementWell.executeQuery(); //Массив eq для well с id
 * // statementEquipment.setString(1, rs.getString("id")); // ResultSet
 * rsEquipment = statementEquipment.executeQuery(); // FileWriter writer = new
 * FileWriter(pathName, false);
 * 
 * while(rs.next()) { String xml = ""; Well timeWell = new
 * Well(rs.getString("name"), rs.getInt("id"), null);
 * 
 * statementEquipment.setString(1, rs.getString("id"));
 * 
 * ResultSet rsEquipment = statementEquipment.executeQuery();
 * ArrayList<Equipment> eq=new ArrayList<>(); while (rsEquipment.next()) {
 * eq.add(new Equipment(rsEquipment.getString("name"),
 * rsEquipment.getInt("id")));
 * 
 * } timeWell.setEquipment(eq); xml=xstream.toXML(timeWell);
 * 
 * writer.append(xml);
 * 
 * } writer.flush(); connection.close();
 * 
 * } catch (SQLException e) { e.printStackTrace(); } catch (IOException e) {
 * e.printStackTrace(); }
 * 
 * 
 * } }
 */