package com.dh.lms;

import com.dh.lms.dao.UserDao;

import com.dh.lms.service.BookService;
import com.dh.lms.service.IssueBookService;
import com.dh.lms.service.ReportsService;
import com.dh.lms.service.UserService;
import com.dh.lms.util.Reader;

public class LMS
{
    public static void main(String[] args)
    {
      Reader sc=new Reader();
      UserService userservice=new UserService();
      ReportsService reportservice = new ReportsService();
      UserDao user = new UserDao();
      BookService bookservice=new BookService();
      IssueBookService issuedbookservice = new IssueBookService();
      int option=0;
      while(option!=-1 ){
        userservice.main();
        int temp=sc.nextInt();
        if(temp==1){
        	userservice.librarianLoginPage();
            userservice.librarianPage();
            int option1 = sc.nextInt();
            if(option1==1){
              issuedbookservice.issuebook();

            }else if(option1==2){
              issuedbookservice.returnbook();
            }else if(option1 == 3){
                  userservice.managebook();
                  int option2 = sc.nextInt();
                  if(option2==1){
                    bookservice.searchbook();
                  }else if(option2==2){
                    bookservice.addBook();
                  }else if(option2 == 3){
                    bookservice.updateBook();
                  }else if(option2==4){
                    bookservice.deleteBook();
                  }
            }else if(option1==4){
                reportservice.booksToReturned();
            }else{
                return;
            }       
         

        }
        else if(temp==2){
            userservice.studentloginpage();
            userservice.studentpage();
            int option1 = sc.nextInt();
            if(option1==1){
              bookservice.searchbook();
            }else if(option1==2){
              user.view();
            }else if(option1 == 3){
              bookservice.issuedbook();
            }else{
              return;
            }
        }
        
        else if(temp==3){
          userservice.userRegistration();   // user registration with user model
        }
        else {
          System.out.println("Please select valid option");  // user registration with user model
          return;
        }

     }
  }  
   
}






// String dateStr=sc.nextLine();
// DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-yyyy");

// // Try block to check for exceptions

// // Getting the Date from String
// LocalDate date= LocalDate.parse(dateStr, format);

// // Printing the converted date
// System.out.println(Date.valueOf(date));