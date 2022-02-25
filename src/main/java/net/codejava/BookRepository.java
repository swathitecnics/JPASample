package net.codejava;

import net.codejava.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	    Book findByIsbn(String isbn);
	    
}