package items;

import exceptions.InvalidPathException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString

/**
 * Class Book, which is an item
 */

public class Book extends Item {
    private String author;

    /**
     * Constructor with parameters
     * @param id represents the id of the book from the catalog
     * @param name represents the name of the book
     * @param path represents the path of the book
     * @param author represents the author of the book
     * @throws InvalidPathException when the path is invalid
     */

    public Book(String id, String name, String path, String author) throws InvalidPathException {
        super(id, name, path);
        this.author = author;
    }
}
