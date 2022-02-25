package net.codejava;

import net.codejava.Book;
import net.codejava.Page;
import net.codejava.BookRepository;
import net.codejava.PageRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
  

    @Bean
    public CommandLineRunner mappingDemo(BookRepository bookRepository,
                                         PageRepository pageRepository) {
        return args -> {

            // create a new book
            Book book = new Book("Java 101", "John Doe", "123456");
            
            System.out.println("After book creation");

            // save the book
            bookRepository.save(book);
            
            System.out.println("After book save");

            // create and save new pages
            pageRepository.save(new Page(1, "Intro content", "{'registrationCode':'ABC123'}", book));
            pageRepository.save(new Page(65, "Java 8 contents","{'registrationCode':'ABC123'}", book));
            pageRepository.save(new Page(95, "Concurrency contents", "{'registrationCode':'ABC123'}", book));
            
            System.out.println("After page creation");
        };
    }
}