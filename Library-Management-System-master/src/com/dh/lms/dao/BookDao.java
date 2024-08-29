package com.dh.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.dh.lms.util.DBUtil;
import com.dh.lms.util.Reader;
import com.dh.lms.model.Book;

// class for executing database operation and get different book details and there

public class BookDao {

  DBUtil db = new DBUtil();
  Connection conn = db.getConnection();
  Reader sc = new Reader();
  Book bo = new Book();

  public void addBook(Book b) {
    System.out.println("\n ADD BOOK PAGE");
    try {
      ResultSet set = null;
      String sql = "insert into book(book_name,author_id,isbn_id,Quantity)values(?,?,?,?)";
      PreparedStatement pstm = conn.prepareStatement(sql);

      pstm.setString(1, b.getBookName());
      pstm.setInt(2, b.getAuthorid());
      pstm.setInt(3, b.getIsbnId());
      pstm.setInt(4, b.getQuantity());

      pstm.executeUpdate();
      db.closePSandRS(pstm, set);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void updateBook(Book book) {
    try {
      ResultSet set = null;
      String sql = "update book set Quantity = Quantity+? where book_name=? ";

      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(2, book.getBookName());
      pstm.setInt(1, book.getQuantity());
      pstm.executeUpdate();
      System.out.println("Book Added successfully");

      db.closePSandRS(pstm, set);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deletebook(Book  book) {
    try {
      ResultSet set = null;
      String sql = "delete from book where book_name = ?";
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, book.getBookName());
      pstm.executeUpdate();

      db.closePSandRS(pstm, set);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
