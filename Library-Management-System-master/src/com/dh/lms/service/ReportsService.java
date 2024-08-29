package com.dh.lms.service;
import com.dh.lms.dao.ReportDao;
import com.dh.lms.model.Book;
import com.dh.lms.model.User;
//import com.dh.lms.util.LoginUtil;
import com.dh.lms.util.Reader;

// class for fumctioning of reports function in console;

public class ReportsService {
    
    ReportDao d=new ReportDao();
    Reader sc=new Reader();
    User u = new User();
    Book b = new Book();
    
    
    public void booksToReturned(){
        d.booksToReturned();
    }
}
