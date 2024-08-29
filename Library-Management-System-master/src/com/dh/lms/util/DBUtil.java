package com.dh.lms.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {

    public Connection getConnection(){
        Connection conn=null;
      try{
        FileReader reader=new FileReader("D:/LIB/DB.properties");  
        Properties p=new Properties();  
        p.load(reader);  
        String DB_URL=p.getProperty("DB_URLS");
        String USER=p.getProperty("USERID");
        String PASS=p.getProperty("PASSWORD");
        conn= DriverManager.getConnection(DB_URL,USER,PASS);
        // conn.setAutoCommit(true);
      } catch(Exception e){
        e.printStackTrace();
      }
      return conn;
    }

    public void closeConnection(Connection conn) {
        try{
            if(conn!=null){
                conn.close();
            }
          } catch(SQLException e){
            e.printStackTrace();
          }
    }

    public void closePSandRS(PreparedStatement pst,ResultSet rs) {
        try{
            if(rs!=null){
                rs.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            try{
                if(pst!=null){
                    pst.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    

    }


