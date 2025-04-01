package com.synergisticit.RESTController;

import com.synergisticit.entity.Book;
import com.synergisticit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Book")
public class RESTBookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Integer id){
        Optional<Book> book = bookService.findBookByBookId(id);
        if(book.isPresent()){
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Integer id){
        bookService.deleteBookByBookId(id);
        return ResponseEntity.noContent().build();
    }
}
