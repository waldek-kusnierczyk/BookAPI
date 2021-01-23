package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    @RequestMapping("/books/{bookID}")
    public Book getBook(@PathVariable Long bookID) {
        return this.bookService.getBook(bookID);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
//        return
        this.bookService.addBook(book);
        System.out.println(book);
        //return book.toString();
    }

}
