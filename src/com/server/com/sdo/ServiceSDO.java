package com.server.com.sdo;

import ru.ep.sdo.Session;

public interface ServiceSDO {
    public Session createProperties();
    public String getAll();
    public void renameObject(String oldName,String newName);
}
