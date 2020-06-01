package com.firstgroup.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseDAO {
    DataSource dataSource;
    public DataBaseDAO(){
        try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/ssystem");
        }catch(NamingException ne){
            System.out.println("Exception:"+ne);
        }
    }
    //返回一个连接对象
    public Connection getConnection()throws Exception{
        return dataSource.getConnection();
    }
}
