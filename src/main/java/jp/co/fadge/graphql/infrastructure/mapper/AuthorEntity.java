package jp.co.fadge.graphql.infrastructure.mapper;

import lombok.Data;

@Data
public class AuthorEntity {
    private int id;
    private String name;
    private int bookId;

}
