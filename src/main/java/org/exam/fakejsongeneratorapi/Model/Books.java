package org.exam.fakejsongeneratorapi.Model;


import java.util.Date;

public class Books {

    private String bookTitle;
    private String bookImage;
    private String bookDescription;
    private String bookAuthor;
    private String bookPublisher;
    private String amazonBookUrl;
    private String bookIsbn;
    private Integer bookRank;


    public Books() {
    }

    public Books(String bookTitle, String bookImage, String bookDescription, String bookAuthor, String bookPublisher, String amazonBookUrl, String bookIsbn, Integer bookRank) {
        this.bookTitle = bookTitle;
        this.bookImage = bookImage;
        this.bookDescription = bookDescription;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.amazonBookUrl = amazonBookUrl;
        this.bookIsbn = bookIsbn;
        this.bookRank = bookRank;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookTmage) {
        this.bookImage = bookTmage;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getAmazonBookUrl() {
        return amazonBookUrl;
    }

    public void setAmazonBookUrl(String amazonBookUrl) {
        this.amazonBookUrl = amazonBookUrl;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Integer getBookRank() {
        return bookRank;
    }

    public void setBookRank(Integer bookRank) {
        this.bookRank = bookRank;
    }

}
