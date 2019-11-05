package jp.co.fadge.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import jp.co.fadge.graphql.infrastructure.AuthorRepositoryImpl;
import jp.co.fadge.graphql.infrastructure.BookRepositoryImpl;
import jp.co.fadge.graphql.model.value.AuthorId;
import jp.co.fadge.graphql.model.value.Id;
import jp.co.fadge.graphql.model.value.Name;
import jp.co.fadge.graphql.types.Author;
import jp.co.fadge.graphql.types.RegistBookResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
@Slf4j
public class BookMutationResolver implements GraphQLMutationResolver {
    private final BookRepositoryImpl bookRepositoryImpl;
    private final AuthorRepositoryImpl authorRepositoryImpl;

    public RegistBookResponse registBook(String authorId, String name) throws Exception {
        // Author 存在チェック
        Id id = Id.of(Integer.valueOf(authorId));
        Author author = authorRepositoryImpl.getAuthorById(id);
        if (Objects.isNull(author)) {
            throw new Exception("not find author, authorId:" + authorId);
        }

        AuthorId authorIdValue = AuthorId.of(Integer.valueOf(authorId));
        Name nameValue = Name.of(name);

        return bookRepositoryImpl.registBook(authorIdValue, nameValue);
    }

}
