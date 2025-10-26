package edu.icet.service;

import edu.icet.model.Book;
import edu.icet.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void getAllDetails() {
        bookRepository.findAll();
    }

    public void add() {
        Book book = new Book(
                2L,
                "Madol Duwa",
                "Martin Wickramasinghe",
                "Sarasavi",
                "978-955-31-0525-7",
                "Sinhala Literature",
                10
        );

        //bookRepository.save(book);
        System.out.println(bookRepository.findAll());

    }

}
