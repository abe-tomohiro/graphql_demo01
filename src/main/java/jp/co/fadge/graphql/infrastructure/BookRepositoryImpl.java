package jp.co.fadge.graphql.infrastructure;

import jp.co.fadge.graphql.infrastructure.mapper.BookMapper;
import jp.co.fadge.graphql.model.BookFactory;
import jp.co.fadge.graphql.model.BookRepository;
import jp.co.fadge.graphql.model.RegistBookFactory;
import jp.co.fadge.graphql.model.value.AuthorId;
import jp.co.fadge.graphql.model.value.Name;
import jp.co.fadge.graphql.types.Book;
import jp.co.fadge.graphql.types.RegistBookResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class BookRepositoryImpl implements BookRepository {

    private final BookFactory bookFactory;
    private final RegistBookFactory registBookFactory;
    private final BookMapper bookMapper;

    @Override
    public List<Book> getBooksByAuthorId(AuthorId authorId) {
        return bookFactory.create(bookMapper.getBooksByAuthorId(authorId.getValue()));
    }

    @Override
    public RegistBookResponse registBook(AuthorId authorId, Name name) {
        boolean isRegist = true;
        String error = null;
        try {
            bookMapper.registBook(authorId.getValue(), name.getValue());
        } catch (Exception ex) {
            isRegist = false;
            error = ex.getMessage();
        }

        return registBookFactory.create(authorId.getValue(), name.getValue(), isRegist, error);
    }
}
