package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService implements BookService {
    private List<Book> list;
    private static Long nextId = 1L;

    public MemoryBookService() {
        this.list = new ArrayList<>();
        list.add(new Book(getNextId(), "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(getNextId(), "9788328302341", "Czysty kod. Podręcznik dobrego programisty", "Robert C. Martin", "Helion", "programming"));
        list.add(new Book(getNextId(), "9788328357785", "Java. Podstawy. Wydanie XI", "Cay S. Horstmann", "Helion", "programming"));
        list.add(new Book(getNextId(), "9788328360679", "Java. Techniki zaawansowane. Wydanie XI", "Cay S. Horstmann", "Helion", "programming"));
        list.add(new Book(getNextId(), "9788328333550", "Wzorce projektowe. Rusz głową!", "Eric Freeman, Bert Bates, Kathy Sierra, Elisabeth Robson", "Helion", "programming"));
    }

    public static Long getNextId() {
        return nextId++;
    }

    //    Pobieranie listy wszystkich książek
    @Override
    public List<Book> getBooks() {
        return list;
    }

//    Pobieranie obiektu po wskazanym identyfikatorze.
    @Override
    public Book getBook(Long bookID) {
        for(Book book: list) {
            if (book.getId() == bookID) {
                return book;
            }
        }
        return null;
    }

//    Dodanie obiektu.
    @Override
    public boolean addBook(Book book) {
        book.setId(MemoryBookService.getNextId());
        return list.add(book);
    }

    //    Edycje obiektu.
    @Override
    public Book updateBook(Long bookID) {
        return null;
    }

//    Usuwanie obiektu.
    @Override
    public void deleteBook(Long bookID) {

    }
}
