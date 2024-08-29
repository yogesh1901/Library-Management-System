package com.dh.lms.service;

import com.dh.lms.dao.UserDao;
import com.dh.lms.model.Book;
import com.dh.lms.model.User;
import com.dh.lms.util.LoginUtil;
import com.dh.lms.util.Reader;

// class for functioning of users function in console;

public class UserService {

    Book b=new Book();
    UserDao d=new UserDao();
    Reader sc=new Reader();
    User u = new User();
 
    public void userRegistration(){
        System.out.println("\nStudent Registration");
        try {
            newstudent();
        } catch (Exception e) {
            System.out.println("please try registering with different email");
            
        }
    }
    // new user information collection;
    private void newstudent() {
        User s=new User();
        System.out.println("\nEnter name of User");
        s.setUserName(sc.nextLine());

        System.out.println("\nEnter password");
        s.setPassword(sc.nextLine());

        System.out.println("\nEnter User phone no.");
        s.setPhoneNo(sc.nextLong());
         while (s.getPhoneNo() < 1000000000l || s.getPhoneNo()> 9999999999l) {// validating the length of mobile number
             System.out.println("Enter a 10 digit mobile number");
             s.setPhoneNo(sc.nextLong());
         }

        System.out.println("\nEnter User email");
        s.setUseremail(sc.nextLine());
       

        d.userRegistration(s);
    }


    // Librarian Login page for Authennticating librarian
    public void librarianLoginPage(){
        User u=new User();
        u.setUserType("admin");

        while(!u.isAuthenticated()){
            System.out.println("Enter Librarian Username yogiii");
            u.setUserName(sc.nextLine());

            System.out.println("Enter Password");
            u.setPassword(sc.nextLine());

            d.librarianlogin(u);
        }
        LoginUtil.setLoggedInUser(u);
    	

    }
    // Student LoginPage for Authenticating Students
    public void studentloginpage() {

        User u=new User();
        u.setUserType("student");

        while(!u.isAuthenticated()){
            System.out.println("Enter Student email");
            u.setUseremail(sc.nextLine());

            System.out.println("Enter Password");
            u.setPassword(sc.nextLine());

            d.studentlogin(u);
        }
          
        LoginUtil.setLoggedInUser(u);
    }

        public void main(){
            System.out.println("\nWelcome  to Library");
            System.out.println("choose one of the following options");
            System.out.println("1. Librarian");
            System.out.println("2. student ");
            System.out.println("3. student registration ");
    
        }

        public void librarianPage(){
          System.out.println("\nHELLO LIBRARIAN");
          System.out.println("choose one of the following options");
          System.out.println("1. ISSUE BOOK TO STUDENT");
          System.out.println("2. RETURN BOOK OF STUDENT ");
          System.out.println("3. MANAGE BOOK ");
          System.out.println("4. REPORT");
          System.out.println("5. EXIT");
        }

        public void managebook(){
            System.out.println("\n MANAGE BOOK SCREEN");
              
              System.out.println("choose one of the following options");
              System.out.println("1. SEARCH");
              System.out.println("2. ADD ");
              System.out.println("3. UPDATE ");
              System.out.println("4. DELETE");
        }

        public void studentpage(){
            System.out.println("\nHELLO STUDENT");
            System.out.println("choose one of the following options");
            System.out.println("1. SEARCH");
            System.out.println("2. VIEW ");
            System.out.println("3. ISSUED BOOKS ");
            System.out.println("4. EXIT");
        }

    
}
   



    

       

    
    


       

     


