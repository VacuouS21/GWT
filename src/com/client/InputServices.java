package com.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service")
public interface InputServices extends RemoteService {
	String newEquipment(String nameWell, int countEquipment);
	String getCountEquipment(String wellName);
	String createXML(String fileName);
	String renameWell(String oldName,String newName);
	String getAllWell(String str);
	String createFile();
}
