package edu.mum.cs.cs425.demos.elibrarydemocrudweb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.Book;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.repository.BookRepository;

@SpringBootApplication
public class ElibraryDemocrudWebApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(ElibraryDemocrudWebApplication.class, args);
    }
    
    public void saveBook(Book book) {
    	bookRepository.save(book);
    }
    
    @Override
	public void run(String... args) throws Exception {
    	LocalDate newDate1 = LocalDate.of(1990, 12, 5);
		Book book1 = new Book(1, "12345678", "The First Book", 10.0, "Penguin Books", newDate1);
		saveBook(book1);
		
		LocalDate newDate2 = LocalDate.of(1992, 5, 10);
		Book book2 = new Book(2, "8765421", "The Second Book", 5.0, "Purdue", newDate2);
		saveBook(book2);
	}

}
