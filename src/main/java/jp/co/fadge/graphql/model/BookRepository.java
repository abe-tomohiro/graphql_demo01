package jp.co.fadge.graphql.model;

import jp.co.fadge.graphql.model.value.AuthorId;
import jp.co.fadge.graphql.model.value.Name;
import jp.co.fadge.graphql.types.Book;
import jp.co.fadge.graphql.types.RegistBookResponse;

import java.util.List;

public interface BookRepository {
    List<Book> getBooksByAuthorId(AuthorId authorId);
    RegistBookResponse registBook(AuthorId authorId, Name name);
}
