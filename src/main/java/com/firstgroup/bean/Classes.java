package com.firstgroup.bean;

public class Classes {
    private int classNumber;
    private String className;
    private int tNumbet;
    private String begainDate;
    private String endDate;

    public void setClassNumber(Object obj){this.classNumber=(Integer)obj;}
    public void setClassName(Object obj){this.className= (String) obj;}
    public void setTNumbet(Object obj){this.tNumbet=(Integer)obj;}
    public void setBegainDate(Object obj){this.begainDate= (String) obj;}
    public void setEndDate(Object obj){this.endDate= (String) obj;}

    public int getClassNumber(){return classNumber;}
    public String getClassName(){return className;}
    public int getTNumbet(){return tNumbet;}
    public String getBegainDate(){return begainDate;}
    public String getEndDate(){return endDate;}

}
