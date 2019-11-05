package jp.co.fadge.graphql.types;

import jp.co.fadge.graphql.infrastructure.mapper.BookEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Author {
    private int id;
    private String name;
    private List<BookEntity> books;
}
