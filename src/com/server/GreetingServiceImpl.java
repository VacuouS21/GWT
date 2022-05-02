package com.server;


import com.client.InputServices;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.server.com.sdo.SDOServiceWell;
import com.server.com.utility.NewDatabase;
import com.server.com.utility.NewFile;
import com.server.com.utility.ParseSQLForXML;
import com.server.com.services.EquipmentService;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements InputServices{
	
	private static final String CON_STR = "jdbc:sqlite:test.db";
	final EquipmentService equipmentService = EquipmentService.getInstance(CON_STR);
	final SDOServiceWell serviceWell = SDOServiceWell.getInstance(CON_STR);
	
	@Override
	public String createFile() {
		NewFile.createFile("test.db");

		NewDatabase.createDatabase(CON_STR);
		return null;
	}
	@Override
	public String newEquipment(String nameWell, int countEquipment) {
		// TODO Auto-generated method stub

		createNEquipment(nameWell, countEquipment, equipmentService);
		return "В скважину " +nameWell+" добавлено оборудований:  "+countEquipment;
	}

	@Override
	public String getCountEquipment(String wellName) {
		// TODO Auto-generated method stub
		
		String names=outputAllInformationAboutWell(wellName, equipmentService);
		return names;
	}

	@Override
	public String createXML(String fileName) {
		// TODO Auto-generated method stub
		String xmlString=exportXMLFile(fileName);
		return "Был создан файл "+fileName+".xml\n "+xmlString;
	}

	@Override
	public String renameWell(String oldName, String newName) {
		// TODO Auto-generated method stub
		updateWell(oldName,newName, serviceWell);
		return "Название скважины "+ oldName+" было заменено на "+newName;
	}

	@Override
	public String getAllWell(String str) {
		// TODO Auto-generated method stub
		createFile();
		String list=serviceWell.getAll();
		return list;
	}
	
	private static void createNEquipment(String wellName, int countEquipment, EquipmentService equipmentService) {

		equipmentService.createEquipment(wellName, countEquipment);
	}

	private static String outputAllInformationAboutWell(String strName, EquipmentService equipmentService) {

		String[] arrName = strName.split(",");
		String all="";
		for (String wellName : arrName) {
			if (wellName != null || !wellName.equals(""))
				all+=equipmentService.countEquipment(wellName)+"\n";
			else
				return ("Имя скважины не может быть пустым");
		}
		return all;

	} // Вывод в xml

	private static String exportXMLFile(String pathName) {
		pathName += ".xml";
	  ParseSQLForXML.inputInfoInFile(pathName, CON_STR);
	  return ParseSQLForXML.readStream(pathName);
	}

	private static void updateWell(String oldName, String newName, SDOServiceWell serviceWell) {
		serviceWell.renameObject(oldName, newName);
	}



}
