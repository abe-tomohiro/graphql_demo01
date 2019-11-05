package jp.co.fadge.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import jp.co.fadge.graphql.infrastructure.BookRepositoryImpl;
import jp.co.fadge.graphql.model.value.AuthorId;
import jp.co.fadge.graphql.types.Author;
import jp.co.fadge.graphql.types.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Author> {
    private final BookRepositoryImpl bookRepositoryImpl;

    public List<Book> books(Author author) {
        AuthorId authorId = AuthorId.of(author.getId());
        return bookRepositoryImpl.getBooksByAuthorId(authorId);

    }
}
