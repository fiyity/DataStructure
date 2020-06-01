package com.firstgroup.bean;

import javax.swing.*;

public class Resources {
    private String teachernumber;
    private int resourcesNumber;
    private int classNumber;
    private String resourcesContent;

    public String getTeachernumber() {
        return teachernumber;
    }

    public void setTeachernumber(Object teachernumber) {
        this.teachernumber = (String) teachernumber;
    }

    public int getResourcesNumber() {
        return resourcesNumber;
    }

    public void setResourcesNumber(Object resourcesNumber) {
        this.resourcesNumber = (Integer) resourcesNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Object classNumber) {
        this.classNumber = (Integer) classNumber;
    }

    public String getResourcesContent() {
        return resourcesContent;
    }

    public void setResourcesContent(Object resourcesContent) {
        this.resourcesContent = (String) resourcesContent;
    }
}
