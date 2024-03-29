package jp.co.fadge.graphql.model.value;

import lombok.Value;

@Value(staticConstructor = "of")
public class Id {
    private int value;

    public String toString() {
        return String.valueOf(value);
    }
}
