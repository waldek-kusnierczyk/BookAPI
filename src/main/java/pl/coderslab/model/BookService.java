package pl.coderslab.model;

import java.util.List;
import java.util.Optional;

public interface BookService {
//    Pobieranie listy wszystkich książek
    List<Book> getBooks();

//    Pobieranie obiektu po wskazanym identyfikatorze.
    Optional<Book> getBook(Long id);

//    Dodanie obiektu.
    boolean addBook(Book book);

//    Edycje obiektu.
    Book updateBook(Long bookID);

//    Usuwanie obiektu.
    void deleteBook(Long bookID);
}
