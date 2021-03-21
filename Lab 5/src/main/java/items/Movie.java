package items;

import exceptions.InvalidPathException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString

/**
 * Class Movie, which is an item
 */

public class Movie extends Item {
    private List<String> actors;

    /**
     * Constructor with parameters
     * @param id represents the id of the movie from the catalog
     * @param name represents the name of the movie
     * @param path represents the path of the movie
     * @param actors represents the actors from the movie
     * @throws InvalidPathException when the path is invalid
     */

    public Movie(String id, String name, String path, List<String> actors) throws InvalidPathException {
        super(id, name, path);
        this.actors = actors;
    }
}
