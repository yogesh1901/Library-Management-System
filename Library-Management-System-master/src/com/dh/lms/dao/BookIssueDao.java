package com.dh.lms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dh.lms.model.*;
import com.dh.lms.util.DBUtil;
import com.dh.lms.util.Reader;

import com.dh.lms.model.Book;

// class for executing database operation and get different book details and there

public class BookIssueDao {
    DBUtil db=new DBUtil();
    Connection conn=db.getConnection();
    Reader sc= new Reader(); 
    // User user = new User();
    // Book book = new Book();
    
    
    public void issuebook(Book book,User user) {
    	  ResultSet set = null;
          try{
              String sql = "insert into issue_book(user_id,book_id,issue_date,ecpected_return_date)values((select user_id from users where user_name=?),(select book_id from book where book_name=?),curdate(),DATE_ADD(curdate(),interval 7 day))";
              PreparedStatement pstm = conn.prepareStatement(sql); 
              pstm.setString(1,user.getUserName());
              pstm.setString(2,book.getBookName());
              
              pstm.executeUpdate();
              db.closePSandRS(pstm,set);

               sql ="update book set Quantity = Quantity-1 where book_id =(select book_id from book where book_name=?)";
               pstm = conn.prepareStatement(sql); 
               pstm.setString(1,book.getBookName());
               pstm.executeUpdate();
               db.closePSandRS(pstm,set);

          }catch(Exception e){
              e.printStackTrace();
          }
    }


    public void returnbook(Book book,User user){
        ResultSet set = null;
        try{
            
            String sql ="update users set total_due=total_due+100 where exists((select 1 from issue_book where curdate()>expected_return_date and user_id=(select user_id from users where user_name =?) and book_id = (select book_id from book where book_name=?)))";
            PreparedStatement pstm = conn.prepareStatement(sql); 
             pstm.setString(1,user.getUserName());
             pstm.setString(2,book.getBookName());
             pstm.executeUpdate();
             db.closePSandRS(pstm,set);

             sql ="update book set Quantity = Quantity+1 where book_name=?";
             pstm = conn.prepareStatement(sql); 
             pstm.setString(1,book.getBookName());
             pstm.executeUpdate();
             db.closePSandRS(pstm,set);


             sql ="delete from issue_book where user_id=(select user_id from users where user_name =?) and book_id=(select book_id from book where book_name=?) ";
             pstm = conn.prepareStatement(sql); 
             pstm.setString(1,user.getUserName());
             pstm.setString(2,book.getBookName());
             pstm.executeUpdate();
             db.closePSandRS(pstm,set);




        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void samdate(){
        ResultSet set = null;
        try{
            String sql = "insert into date(curr_date,next_date) values(curdate(),curdate()+5)";
             PreparedStatement pstm = conn.prepareStatement(sql); 
            //pstm.setInt(1,user.setUserId());
           // pstm.setInt(2,bo.getBookId());
            //pstm.setInt(3,bo.getBookId());
            pstm.executeUpdate();
             db.closePSandRS(pstm,set);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
