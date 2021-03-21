package items;

import exceptions.InvalidPathException;
import lombok.Data;

import java.io.File;
import java.io.Serializable;

@Data

/**
 * Class Item
 * Describes the items in a catalog
 */

public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String path;

    /**
     * Constructor with parameters
     * @param id represents the id of the item
     * @param name represents the name of the item
     * @param path represents the path of the item
     * @throws InvalidPathException when the path is invalid
     */

    public Item(String id, String name, String path) throws InvalidPathException {
        this.id = id;
        this.name = name;
        this.path = path;

        File file = new File(path);

        if(!file.exists()) {
            throw new InvalidPathException("Invalid path");
        } else {
            this.path = path;
        }
    }
}