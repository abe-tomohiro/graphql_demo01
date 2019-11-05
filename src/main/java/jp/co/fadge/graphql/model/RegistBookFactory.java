package jp.co.fadge.graphql.model;

import jp.co.fadge.graphql.types.RegistBookResponse;
import org.springframework.stereotype.Component;

@Component
public class RegistBookFactory {

    /**
     * create authorId, name for RegistBookResponse
     * @param authorid authorId
     * @param name name
     * @param regist regist
     * @param error error
     * @return RegistBookResponse
     */
    public RegistBookResponse create(int authorid, String name, boolean regist, String error) {
        return RegistBookResponse.builder().authorId(authorid).name(name).regist(regist).errorMessage(error).build();
    }
}
