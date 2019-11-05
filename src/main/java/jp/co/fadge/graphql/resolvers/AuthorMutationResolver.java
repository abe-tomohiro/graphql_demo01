package jp.co.fadge.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import jp.co.fadge.graphql.infrastructure.AuthorRepositoryImpl;
import jp.co.fadge.graphql.model.value.Name;
import jp.co.fadge.graphql.types.RegistAuthorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class AuthorMutationResolver implements GraphQLMutationResolver {
    private final AuthorRepositoryImpl authorRepositoryImpl;

    public RegistAuthorResponse registAuthor(String name) {
        Name nameValue = Name.of(name);
        return authorRepositoryImpl.registAuthor(nameValue);
    }
}
