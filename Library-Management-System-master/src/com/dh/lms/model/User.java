package com.dh.lms.model;

// public class model for user 

public class User {

    private String userName;
    private long phoneNo;
    private String useremail;
    private String password;
    private String userType;
    private boolean Authenticated;
    private int issueid;

   
    public boolean isAuthenticated() {
        return Authenticated;
    }
    public void setAuthenticated(boolean authenticated) {
        Authenticated = authenticated;
    }
    private int userId;

    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getUseremail() {
        return useremail;
    }
    public void setUseremail(String string) {
        this.useremail = string;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String string) {
        this.password = string;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public int getIssueid() {
        return issueid;
    }
    public void setIssueid(int issueid) {
        this.issueid = issueid;
    }
   
   
    
}
