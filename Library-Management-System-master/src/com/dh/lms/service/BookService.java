package com.dh.lms.service;

import com.dh.lms.dao.BookDao;
import com.dh.lms.dao.UserDao;
import com.dh.lms.model.Book;
import com.dh.lms.model.User;
import com.dh.lms.util.Reader;

// class for fumctioning of manage function in console;

public class BookService {
  // instead of scanner we are using user defined reader ;
  BookDao bookdao = new BookDao();
  Reader sc = new Reader();
  Book book = new Book();
  User user = new User();
  UserDao userdao = new UserDao();

  public void addBook() {

    System.out.println("\n ENTER BOOK NAME");
    book.setBookName(sc.nextLine());

    System.out.println("ENTER AUTHOR ID");
    book.setAuthorid(sc.nextInt());
    System.out.println("ENTER ISBN ID");
    book.setIsbnId(sc.nextInt());
    System.out.println("QUANTITY");
    book.setQuantity(sc.nextInt());

    bookdao.addBook(book);
  }

  public void searchbook() {
    System.out.println("\n search BOOK PAGE");
    System.out.println("ENTER BOOK NAME");
    book.setBookName(sc.nextLine());
    userdao.searchbook(book);

  }

  public void issuedbook() {
    User user=new User();
    user.setUserId(UserDao.loggedInUser.getUserId());
    userdao.issuedbook(user);

  }

  public void updateBook() {
    Book book=new Book();
    System.out.println("ENTER BOOK NAME");
    book.setBookName(sc.nextLine());
    System.out.println("\n ENTER QUANTITY OF BOOK TO BE ADDED");;
    book.setQuantity(sc.nextInt());
    bookdao.updateBook(book);
  }

  public void deleteBook(){
    Book book = new Book();
    System.out.println("delete BOOK PAGE");
    System.out.println();
    System.out.println("Enter Book Name");
    book.setBookName(sc.nextLine());
    bookdao.deletebook(book);
    System.out.println("Book deleted Successfully");

  }

}
