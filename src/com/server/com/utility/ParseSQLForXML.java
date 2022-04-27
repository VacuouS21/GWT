package com.server.com.utility;

import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;

public class ParseSQLForXML {

	public static void inputInfoInFile(String pathName, String pathSQLDatabase) {

		NewFile.createFile(pathName);

		String sqlForNameWell = "SELECT * FROM well;";
		String sqlForEquipment = "Select * FROM equipment WHERE well_id=(?);";
		try {

			DriverManager.registerDriver(new JDBC());
			Connection connection = DriverManager.getConnection(pathSQLDatabase);
			PreparedStatement statementWell = connection.prepareStatement(sqlForNameWell);
			PreparedStatement statementEquipment = connection.prepareStatement(sqlForEquipment);

			ResultSet rs = statementWell.executeQuery();

			FileWriter writer = new FileWriter(pathName, false);

			writer.append("<dbinfo>\n");
			while (rs.next()) {
				writer.append("<well name=\"" + rs.getString("name") + "\" id=\"" + rs.getInt("id") + "\">");
				writer.append('\n');
				// System.out.println("< well name=\""+rs.getString("name")+"\"
				// id=\""+rs.getInt("id")+"\">");
				statementEquipment.setString(1, rs.getString("id"));
				ResultSet rsEquipment = statementEquipment.executeQuery();
				while (rsEquipment.next()) {
					writer.append("<equipment name=\"" + rsEquipment.getString("name") + "\" id=\""
							+ rsEquipment.getInt("id") + "\"/>");
					writer.append('\n');
					// System.out.println("< equipment name=\""+rsEquipment.getString("name")+"\"
					// id=\""+rsEquipment.getInt("id")+"\"/>");
				}
				writer.append("</well>");
				writer.append('\n');

			}
			writer.append("</dbinfo>");

			writer.flush();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String readStream(String pathName) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(pathName)));

			String line;
			StringBuilder sb = new StringBuilder();

			while ((line = br.readLine()) != null) {
				sb.append(line.trim()+"\n");
			}

			return sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Не открылся файл";
	}
}
/*
 * <dbinfo> <well name="АААА" id="123"> <equipment name=”EQ0033" id="12"/>
 * <equipment name=”EQ0034" id="13"/> </well> <well name="BBBB" id="124">
 * <equipment name=”EQ0038" id="11"/> <equipment name=”EQ0039" id="14"/> </well>
 * </dbinfo >
 */