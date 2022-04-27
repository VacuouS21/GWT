package com.server.com.entity;

import ru.ep.sdo.Entity;
import ru.ep.sdo.annotations.Xml;

import java.beans.PropertyChangeSupport;
@Xml(name = "ROW")
public class Well extends Entity {
    public static final String PROPERTYNAME_WELL_ID = "wellId";

    public static final String PROPERTYNAME_NAME = "name";

    @Xml(name = "ID")
    private int wellId;

    @Xml(name = "NAME")
    private String name;

    public Well()
    {
    }

    public Well(int wellId, String name)
    {
        this.setWellId(wellId);
        this.setName(name);
    }

    public int getWellId() {
        return wellId;
    }

    public void setWellId(int wellId) {
        int oldValue = this.wellId;
        this.wellId = wellId;
        firePropertyChange(PROPERTYNAME_WELL_ID, oldValue, wellId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        firePropertyChange(PROPERTYNAME_NAME, oldValue, name);
    }




}
