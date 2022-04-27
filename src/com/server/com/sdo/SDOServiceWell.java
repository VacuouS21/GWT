package com.server.com.sdo;

import com.server.com.entity.Well;
import ru.ep.sdo.Session;
import ru.ep.sdo.SessionFactory;
import ru.ep.sdo.def.SessionMetaData;
import ru.ep.sdo.filter.LikeFilter;
import ru.ep.sdo.list.XMLListModel;

import java.util.Iterator;
import java.util.Properties;

public class SDOServiceWell implements ServiceSDO {
	private static SDOServiceWell instance = null;
	private static String path = null;

	public static SDOServiceWell getInstance(String pathSQLDatabase) {
		if (instance == null)
			instance = new SDOServiceWell(pathSQLDatabase);
		return instance;
	}

	private SDOServiceWell(String pathSQLDatabase) {
		path = pathSQLDatabase;

	}

	public Session createProperties() {
		Properties properties = new Properties();
		properties.setProperty(SessionMetaData.PROPERTY_DRIVER_CLASS_NAME, "org.sqlite.JDBC");
		properties.setProperty(SessionMetaData.PROPERTY_CONNECTION_STRING, path);
		return SessionFactory.getInstance().createSessionFromFile("my.xml", properties);
	}

	public String getAll() {
		Session session = createProperties();

		String list = "";
		XMLListModel listModel = session.getListModel("SDOSQlite.Well");

		Iterator iterator = listModel.iterator();

		if (!iterator.hasNext())
			System.out.println("Скважин ещё нет");
		while (iterator.hasNext()) {
			Well well = (Well) iterator.next();
			list += "Скважина " + well.getName() + System.lineSeparator() + "";
			// System.out.println(iterator.next());
		}
		session.close();
		return list;
	}

	public void renameObject(String oldName, String newName) {
		Session session = createProperties();

		XMLListModel listModel = session.getListModel("SDOSQlite.Well");
		listModel.fetchAll();
		listModel.setWhereClauseParam(0, oldName);
		
		if (listModel.isEmpty()) {
			System.out.println("Такой скважины нет");
		} else {
			Well well = (Well) listModel.get(0);
			System.out.print(well.getName() + " заменено на ");
			well.setName(newName);
			System.out.println(well.getName());
			session.commit();
			
		}
		session.close();
	}
}
