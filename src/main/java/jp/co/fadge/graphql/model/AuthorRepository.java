package jp.co.fadge.graphql.model;

import jp.co.fadge.graphql.model.value.Id;
import jp.co.fadge.graphql.model.value.Name;
import jp.co.fadge.graphql.types.Author;
import jp.co.fadge.graphql.types.RegistAuthorResponse;

public interface AuthorRepository {
    Author getAuthorById(Id id);
    RegistAuthorResponse registAuthor(Name name);
}
