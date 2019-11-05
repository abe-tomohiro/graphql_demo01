package jp.co.fadge.graphql.model;

import jp.co.fadge.graphql.infrastructure.mapper.AuthorEntity;
import jp.co.fadge.graphql.types.Author;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthorFactory {

    /**
     * create Author for AuthorEntity
     * @param authorEntity authorEntity
     * @return Author
     */
    public Author create(AuthorEntity authorEntity) {
        if (Objects.isNull(authorEntity)) {
            return null;
        }

        return Author.builder().id(authorEntity.getId()).name(authorEntity.getName()).build();
    }
}
