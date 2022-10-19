package StepDefinition_RickAndMorty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    String name;
    String url;

    @JsonCreator
    public Location(
            @JsonProperty("name") String name,
            @JsonProperty("url") String url) {
        this.name = name;
        this.url = url;
    }
}
