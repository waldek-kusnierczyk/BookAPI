package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService {
    private List<Book> bookList;
    private static Long nextId = 1L;

    public MemoryBookService() {
        this.bookList = new ArrayList<>();
        bookList.add(new Book(getNextId(), "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        bookList.add(new Book(getNextId(), "9788328302341", "Czysty kod. Podręcznik dobrego programisty", "Robert C. Martin", "Helion", "programming"));
        bookList.add(new Book(getNextId(), "9788328357785", "Java. Podstawy. Wydanie XI", "Cay S. Horstmann", "Helion", "programming"));
        bookList.add(new Book(getNextId(), "9788328360679", "Java. Techniki zaawansowane. Wydanie XI", "Cay S. Horstmann", "Helion", "programming"));
        bookList.add(new Book(getNextId(), "9788328333550", "Wzorce projektowe. Rusz głową!", "Eric Freeman, Bert Bates, Kathy Sierra, Elisabeth Robson", "Helion", "programming"));
    }

    public static Long getNextId() {
        return nextId++;
    }

    // Pobieranie listy wszystkich książek
    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    // metoda dodająca nową książkę do listy
    @Override
    public Optional<Book> getBook(Long id) {
        return bookList.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    // Dodanie obiektu.
    @Override
    public boolean addBook(Book book) {
        book.setId(MemoryBookService.getNextId());
        return bookList.add(book);
    }

    // Edycje obiektu.
    @Override
    public void updateBook(Book book) {
        if (this.getBook(book.getId()).isPresent()) {
            int id = bookList.indexOf(this.getBook(book.getId()).get());
            bookList.set(id, book);
        }
    }

    // Usuwanie obiektu.
    @Override
    public void deleteBook(Long bookID) {
        if (getBook(bookID).isPresent()) {
            bookList.remove(this.getBook(bookID).get());
        }
    }
}
