package org.exam.fakejsongeneratorapi.Service;


import org.exam.fakejsongeneratorapi.Model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private RestTemplate restTemplate;

    public List<Books> getBooks() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Map> entity = restTemplate.exchange(
                "https://api.nytimes.com/svc/books/v3/lists/full-overview.json?api-key=PhhGb7A8fB0QzPSbXQ9Dhvat95ox4uJW",
                HttpMethod.GET, requestEntity, Map.class
        );

        List<Books> bookList = new ArrayList<>();

        if (entity.getStatusCode() == HttpStatus.OK && entity.getBody() != null) {
            Map<String, Object> results = (Map<String, Object>) entity.getBody().get("results");
            if (results != null) {
                List<Map<String, Object>> lists = (List<Map<String, Object>>) results.get("lists");
                if (lists != null) {
                    for (Map<String, Object> list : lists) {
                        List<Map<String, Object>> booksData = (List<Map<String, Object>>) list.get("books");
                        if (booksData != null) {
                            for (Map<String, Object> bookData : booksData) {
                                Books book = new Books();
                                book.setBookTitle((String) bookData.get("title"));
                                book.setBookAuthor((String) bookData.get("author"));
                                book.setBookImage((String) bookData.get("book_image"));
                                book.setBookDescription((String) bookData.get("description"));
                                book.setBookPublisher((String) bookData.get("publisher"));
                                book.setAmazonBookUrl((String) bookData.get("amazon_product_url"));
                                book.setBookIsbn((String) bookData.get("primary_isbn10"));
                                book.setBookRank((Integer) bookData.get("rank"));
                                bookList.add(book);
                            }
                        }
                    }
                }
            }
        }
        return bookList;
    }

    public Books getBookByIsbn(String isbn) {
        List<Books> allBooks = getBooks();

        for (Books book : allBooks) {
            if (book.getBookIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


    public Books getBookByTitle(String title) {
        List<Books> allBooks = getBooks();

        for (Books book : allBooks) {
            if (book.getBookTitle() != null && book.getBookTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }


    public Books getBookPublisher(String publisher) {
        List<Books> allBooks = getBooks();

        for (Books book : allBooks) {
            if (book.getBookTitle() != null && book.getBookPublisher().equals(publisher)) {
                return book;
            }
        }
        return null;
    }

    public Books getBookAuthor(String author){
        List<Books> allBooks = getBooks();

        for(Books book : allBooks){
            if(book.getBookAuthor() != null && book.getBookAuthor().equals(author)){
                return book;
            }
        }
        return null;
    }


}
