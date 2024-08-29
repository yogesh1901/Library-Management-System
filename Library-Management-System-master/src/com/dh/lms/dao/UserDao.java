package com.dh.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dh.lms.model.Book;
import com.dh.lms.model.User;
import com.dh.lms.util.DBUtil;
import com.dh.lms.util.Reader;

public class UserDao {
    DBUtil db=new DBUtil();
    Connection conn=db.getConnection();
    Reader sc = new Reader();
    public static User loggedInUser=new User();
   // class for executing database operation for registering user;

    public void userRegistration(User s) {

        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql=null;
        try{
        
        sql="select user_id from users where user_email=? or user_phone=?";
        pst= conn.prepareStatement(sql);
        pst.setString(1, s.getUseremail());
        pst.setLong(2, s.getPhoneNo());
        rs=pst.executeQuery();

        if(!rs.next()){

          db.closePSandRS(pst, rs);

         sql="insert into users (user_name, user_password,user_phone, user_email) values(?,?,?,?)";
        
  
          pst= conn.prepareStatement(sql);
          pst.setString(1, s.getUserName());
          pst.setString(2, s.getPassword());
          pst.setLong(3, s.getPhoneNo());
          pst.setString(4, s.getUseremail());
          
          
           pst.executeUpdate();
           System.out.println("user inserted successfully");
        }else{
          System.out.println("\nEmail/Phone number is already used for registration");
          System.out.println("\nPlease try registering with different email/Phone number");
        }
        } catch(SQLException e)
        {
          e.printStackTrace();
        }
        finally {
          db.closePSandRS(pst, rs);
        }
      }

      public User librarianlogin(User user){
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select admin_id as id from librarian where admin_username=? and admin_password=?";
        try{
          pst= conn.prepareStatement(sql);
          pst.setString(1, user.getUserName());
          pst.setString(2, user.getPassword());
          
          rs=pst.executeQuery();
          if(rs.next()){
            System.out.println("User Authenticated successfully");
            user.setUserId(rs.getInt("id"));
            user.setAuthenticated(true);
          }else{
            user.setAuthenticated(false);
            System.out.println("provided username or password in incorrect");

          }
          db.closePSandRS(pst, rs);

        }
        catch(SQLException e)
        {
          e.printStackTrace();
        } finally {
          db.closePSandRS(pst, rs);
        }
        
        return user;

      }

      public User studentlogin(User user) {

        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select user_id as id from users where user_email=? and user_password=?";
        try{
          pst= conn.prepareStatement(sql);
          pst.setString(1, user.getUseremail());
          pst.setString(2, user.getPassword());
          
          rs=pst.executeQuery();
          if(rs.next()){
            System.out.println("User Authenticated successfully");
            user.setUserId(rs.getInt("id"));
            loggedInUser.setUserId(rs.getInt(1));
            user.setAuthenticated(true);
          }else{
            user.setAuthenticated(false);
            System.out.println("provided username or password in incorrect");

          }
          db.closePSandRS(pst, rs);

        }
        catch(SQLException e)
        {
          e.printStackTrace();
        } finally {
          db.closePSandRS(pst, rs);
        }
        
        return user;
      }
      public void issuedbook(User user){
        // System.out.println("\n update BOOK PAGE");
        try{
          
          String sql = "select * from book where book_id in (select book_id from issue_book where user_id=?)";
          PreparedStatement stmt = conn.prepareStatement(sql); 
          stmt.setInt(1,user.getUserId());
          ResultSet set = stmt.executeQuery();
         
          while(set.next()){
            System.out.println("Book Id = " + set.getInt(1));
            System.out.println("Book Name = "+set.getString(2));
          }
          
          db.closePSandRS(stmt,set);

        }catch(Exception e){
          e.printStackTrace();
        }
      }

      public void view(){
          try{
            
            String sql = "select book_id,book_name from book";
    
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            
            while(set.next()){
              System.out.println( "Book ID="+set.getInt(1)+"  " + "Book Name= "+ set.getString(2));
              System.out.println();
              
            }
            db.closePSandRS(stmt,set);
    
          }catch(Exception e){
            e.printStackTrace();
          }
        }

        public void searchbook(Book b){
      
          try{
      
            String sql = "select * from book where book_name like(concat('%',?,'%'))";
            PreparedStatement stmt = conn.prepareStatement(sql); 
            stmt.setString(1,b.getBookName());
            ResultSet set = stmt.executeQuery();
            
            while(set.next()){
              System.out.println("BOOK ID: " + set.getInt(1));
              System.out.println("BOOK Name: " + set.getString(2));
              System.out.println("author ID: " + set.getInt(3));
              System.out.println("ISBN ID: "+set.getInt(4));
              System.out.println("QUANTITY: "+set.getInt(5));
              
              System.out.println();
            }
            db.closePSandRS(stmt,set);
    
          }catch(Exception e){
            e.printStackTrace();
          }
        }
}
