package jp.co.fadge.graphql.infrastructure;

import jp.co.fadge.graphql.infrastructure.mapper.AuthorMapper;
import jp.co.fadge.graphql.model.AuthorFactory;
import jp.co.fadge.graphql.model.AuthorRepository;
import jp.co.fadge.graphql.model.RegistAuthorFactory;
import jp.co.fadge.graphql.model.value.Id;
import jp.co.fadge.graphql.model.value.Name;
import jp.co.fadge.graphql.types.Author;
import jp.co.fadge.graphql.types.RegistAuthorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorMapper authorMapper;
    private final AuthorFactory authorFactory;
    private final RegistAuthorFactory registAuthorFactory;

    @Override
    public Author getAuthorById(Id id) {
        return authorFactory.create(authorMapper.getAuthorById(id.getValue()));
    }

    @Override
    public RegistAuthorResponse registAuthor(Name name) {
        boolean isRegist = true;
        String errorMessage = null;
        try{
            authorMapper.registAuthor(name.getValue());
        } catch (Exception ex) {
            isRegist = false;
            errorMessage = ex.getMessage();
        }

        return registAuthorFactory.create(name.getValue(), isRegist, errorMessage);
    }
}
