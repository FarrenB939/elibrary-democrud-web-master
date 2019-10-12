package edu.mum.cs.cs425.demos.elibrarydemocrudweb.repository;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // This interface definition relies on the public abstract methods
    // inherited from the super interface, CrudRepository<T, ID>
    // We may override any or add more methods here, if needed.
    Optional<Book> findBookByIsbn(String isbn);
    
    @Query("SELECT b FROM Book b WHERE b.title LIKE %?1%")
    Iterable<Book> findBooksByTitle(String title);
    
    @Query("SELECT b FROM Book b WHERE b.publisher LIKE %?1%")
    Iterable<Book> findBooksByPublisher(String publisher);
    
    @Query("SELECT b FROM Book b WHERE b.isbn LIKE ?1%")
    Iterable<Book> findBooksByIsbnStartingWith(String isbn);
}
