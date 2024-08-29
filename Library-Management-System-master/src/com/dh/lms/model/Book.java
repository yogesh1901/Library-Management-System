package com.dh.lms.model;

public class Book {
    private int bookId;
    private String bookName;
    private int quantity;
    private int isbnId;
    private long isbnNo;
    private String genreType;
    private String authorName;
    private int authorid;


    
    public long getIsbnNo() {
        return isbnNo;
    }
    public void setIsbnNo(long isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getGenreType() {
        return genreType;
    }
    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getAuthorid() {
        return authorid;
    }
    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }
    public int getIsbnId() {
        return isbnId;
    }
    public void setIsbnId(int isbnId) {
        this.isbnId = isbnId;
    }
  
     
}
