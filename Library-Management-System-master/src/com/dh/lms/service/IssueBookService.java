package com.dh.lms.service;

import com.dh.lms.dao.BookIssueDao;
import com.dh.lms.model.Book;
import com.dh.lms.model.User;
import com.dh.lms.util.Reader;

// class for function issuebooks

public class IssueBookService{
    
    BookIssueDao d=new BookIssueDao();
    Reader sc=new Reader(); 
    User u=new User();
    Book b = new Book();

    public void issuebook(){
        System.out.println("ENTER BOOK NAME");
        b.setBookName(sc.nextLine());
        System.out.println("ENTER User NAME");
        u.setUserName(sc.nextLine());
        d.issuebook(b,u);

    }

    public void returnbook(){

        System.out.println("ENTER BOOK NAME");
        b.setBookName(sc.nextLine());
        System.out.println("ENTER User NAME");
        u.setUserName(sc.nextLine());
        d.returnbook(b,u);

    }
}
