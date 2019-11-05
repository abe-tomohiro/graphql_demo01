package jp.co.fadge.graphql.types;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistAuthorResponse {
    private String name;
    private String errorMessage;
    private boolean regist;
}
