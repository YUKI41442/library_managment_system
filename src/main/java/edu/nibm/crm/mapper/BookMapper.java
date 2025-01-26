package edu.nibm.crm.mapper;

import edu.nibm.crm.dto.BookDto;
import edu.nibm.crm.entity.Book;

public class BookMapper {

    public static BookDto mapToBookDto(Book book){
        return new BookDto(
                book.getId(),
                book.getBookName(),
                book.getAuthorName(),
                book.getPrice()
        );
    }
    public static Book mapToBook(BookDto bookDto){
        return  new Book(
                bookDto.getId(),
                bookDto.getBookName(),
                bookDto.getAuthorName(),
                bookDto.getPrice()
        );
    }


}
