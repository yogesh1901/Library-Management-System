package com.dh.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dh.lms.util.DBUtil;

// class for executing database operation and get reports

public class ReportDao {
    DBUtil db=new DBUtil();
    Connection conn=db.getConnection();
    
    public void booksToReturned(){
  
            try{
              
              String sql = "select book_id,book_name from book where book_id in (select book_id from issue_book where ecpected_return_date < curdate())";
      
              PreparedStatement stmt = conn.prepareStatement(sql);
              ResultSet set = stmt.executeQuery();
              int count=0;
              while(set.next()){
                count++;
                System.out.println( "Book Id = "+set.getInt(1));
                System.out.println( "Book Name = "+ set.getString(2));
                
              }
              if(count==0)
                System.out.println("THERE IS NO BOOKS TO BE RETURNED TODAY");
              db.closePSandRS(stmt,set);
      
            }catch(Exception e){
              e.printStackTrace();
            }
    }
}
    

