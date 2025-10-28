package edu.icet.controller;

import edu.icet.model.dto.Book;
import edu.icet.model.entity.BookEntity;
import edu.icet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public String getAuthor1(){
        return "author";
    }

    @GetMapping("/author")
    public String getAuthor(){
        return "Martin Wickramasinghe";
    }

    @GetMapping("/{author}")
    public String getAuthor(@PathVariable String author){

        return author;
    }

    @GetMapping("/all")
    public List<Book> getAllDetails(){
        List<Book> bookList =bookService.getAllDetails();
        return bookList;

    }

    @PostMapping
    public void add(@RequestBody Book book){
        //System.out.println(book);
        bookService.add(book);
    }

}

//Book book = new Book(
//        1L,
//        "Madol Duwa",
//        "Martin Wickramasinghe",
//        "Sarasavi",
//        "978-955-31-0525-7",
//        "Sinhala Literature",
//        10
//);