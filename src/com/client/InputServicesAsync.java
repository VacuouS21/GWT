package com.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InputServicesAsync {

	
	void newEquipment(String nameWell, int countEquipment,AsyncCallback<String> callback);
	void getCountEquipment(String wellName,AsyncCallback<String> callback);
	void createXML(String fileName,AsyncCallback<String> callback);
	void renameWell(String oldName,String newName,AsyncCallback<String> callback);
	void getAllWell(String str,AsyncCallback<String> callback);
	void createFile(AsyncCallback<String> callback);
}
