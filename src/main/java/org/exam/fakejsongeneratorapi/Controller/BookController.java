package org.exam.fakejsongeneratorapi.Controller;


import org.exam.fakejsongeneratorapi.Model.Books;
import org.exam.fakejsongeneratorapi.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    public List<Books> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/isbn/{isbn}")
    public Books getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }


    @GetMapping("/title/{title}")
    public ResponseEntity<Books> getBookByTitle(@PathVariable String title) {
        System.out.println("Received title for search: " + title);

        Books book = bookService.getBookByTitle(title);
        if (book != null) {
            System.out.println("Found book with title: " + book.getBookTitle());
            return ResponseEntity.ok(book);
        } else {
            System.out.println("No book found with title: " + title);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/publisher/{publisher}")
    public Books getBookPublisher(@PathVariable String publisher){
        return bookService.getBookPublisher(publisher);
    }

    @GetMapping("/author/{author}")
    public Books getBookAuthor(@PathVariable String author){
        return bookService.getBookAuthor(author);
    }



}
