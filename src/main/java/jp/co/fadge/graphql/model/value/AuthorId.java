package jp.co.fadge.graphql.model.value;

import lombok.Value;

@Value(staticConstructor = "of")
public class AuthorId {
    private int value;

    public String toString() {
        return String.valueOf(value);
    }
}
