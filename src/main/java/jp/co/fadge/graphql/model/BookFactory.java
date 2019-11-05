package jp.co.fadge.graphql.model;

import jp.co.fadge.graphql.infrastructure.mapper.BookEntity;
import jp.co.fadge.graphql.types.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BookFactory {

    /**
     * create Books for BookEntities
     * @param bookEntities bookEntities
     * @return Books
     */
    public List<Book> create(List<BookEntity> bookEntities) {
        List<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            Book book = Book.builder().id(bookEntity.getId()).authorId(bookEntity.getAuthorId()).name(bookEntity.getName()).build();
            books.add(book);
        }

        return books;
    }
}
