package edu.nibm.crm.controller;

import edu.nibm.crm.dto.BookDto;
import edu.nibm.crm.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    //-------- ADD BOOK -------///
    @PostMapping
    public ResponseEntity<BookDto> createBook (@RequestBody BookDto bookDto){
        BookDto savedBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    //-------- GET BOOK --------//
    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id){
        BookDto bookDto = bookService.getBookById(id);
        return ResponseEntity.ok(bookDto);
    }

    //------ GET ALL BOOK ------//
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook(){
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    //-------- UPDATE BOOK -------//
    @PutMapping("{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long bookId,
                                               @RequestBody BookDto updatedBook){
        BookDto bookDto = bookService.updateBook(bookId, updatedBook);
        return ResponseEntity.ok(bookDto);
    }

    //-------DELETE BOOK ---------//
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted successfully!..");
    }
}
