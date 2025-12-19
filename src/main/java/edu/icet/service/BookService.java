package edu.icet.service;

import edu.icet.model.dto.Book;
import edu.icet.model.entity.BookEntity;
import edu.icet.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllDetails() {
        List<BookEntity> bookEntityList =bookRepository.findAll();
        List<Book> books=new ArrayList<>();

        for(BookEntity bookEntity:bookEntityList){
            books.add(new Book(
                    bookEntity.getId(),
                    bookEntity.getTitle(),
                    bookEntity.getPublisher(),
                    bookEntity.getAuthor(),
                    bookEntity.getCategory(),
                    bookEntity.getIsbm(),
                    bookEntity.getAvailableCopies()
            ));
        }

        return books;

    }

    public void add(Book book) {


        BookEntity bookEntity=new BookEntity(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbm(),
                book.getCategory(),
                book.getAvailableCopies()
        );
        System.out.println(bookEntity);
        bookRepository.save(bookEntity);



    }

    public Book getById(String id){
        Optional<BookEntity> byId = bookRepository.findById(Long.parseLong(id));

        BookEntity bookEntity = byId.orElseThrow();

        return new Book(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getPublisher(),
                bookEntity.getIsbm(),
                bookEntity.getCategory(),
                bookEntity.getAvailableCopies()
        );

    }

}
