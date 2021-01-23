package pl.coderslab.model;

import java.util.List;

public interface BookService {
//    Pobieranie listy wszystkich książek
    List<Book> getBooks();
//    Pobieranie obiektu po wskazanym identyfikatorze.
    Book getBook(Long bookID);
//    Dodanie obiektu.
    boolean addBook(Book book);
//    Edycje obiektu.
    Book updateBook(Long bookID);
//    Usuwanie obiektu.
    void deleteBook(Long bookID);
}
