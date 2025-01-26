package edu.nibm.crm.service;

import edu.nibm.crm.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(Long id);

    List<BookDto> getAllBooks();

    BookDto updateBook(Long bookId, BookDto updateBook);

    void deleteBook(Long bookId);
}
