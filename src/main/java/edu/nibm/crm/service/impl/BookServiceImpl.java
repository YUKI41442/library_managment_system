package edu.nibm.crm.service.impl;

import edu.nibm.crm.dto.BookDto;
import edu.nibm.crm.entity.Book;
import edu.nibm.crm.exception.ResourseNotFoundException;
import edu.nibm.crm.mapper.BookMapper;
import edu.nibm.crm.repository.BookRepository;
import edu.nibm.crm.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {

        Book book = BookMapper.mapToBook(bookDto);
        Book savesBook = bookRepository.save(book);
        return BookMapper.mapToBookDto(savesBook);
    }

    @Override
    public BookDto getBookById(Long id) {
         Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourseNotFoundException("Books is not exists with given id : "+ id));
        return BookMapper.mapToBookDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((book) -> BookMapper.mapToBookDto(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(Long bookId, BookDto updateBook) {

        Book book = bookRepository.findById(bookId).orElseThrow(
                ()-> new ResourseNotFoundException("Book is not exist with given id: " +bookId)
        );
        book.setBookName(updateBook.getBookName());
        book.setAuthorName(updateBook.getAuthorName());
        book.setPrice(updateBook.getPrice());

        Book updateBookObj = bookRepository.save(book);

        return BookMapper.mapToBookDto(updateBookObj);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                ()-> new ResourseNotFoundException("Book is not exists with given id" + bookId)
        );
        bookRepository.deleteById(bookId);
    }
}
