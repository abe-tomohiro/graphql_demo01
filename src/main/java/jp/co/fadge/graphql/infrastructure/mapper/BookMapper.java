package jp.co.fadge.graphql.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookEntity> getBooksByAuthorId(@Param("authorId") int authorId);
    void registBook(@Param("authorId") int authorId, @Param("name") String name);
}
