package StepDefinition_RickAndMorty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Episode {
    String id;
    String name;
    String airDate;
    String episode;
    ArrayList<String> characters;
    String url;
    String created;

    @JsonCreator
    public Episode(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("air_date") String airDate,
            @JsonProperty("episode") String episode,
            @JsonProperty("characters") ArrayList<String> characters,
            @JsonProperty("url") String url,
            @JsonProperty("created") String created) {
        this.id = id;
        this.name = name;
        this.airDate = airDate;
        this.episode = episode;
        this.characters = characters;
        this.url = url;
        this.created = created;
    }
}

