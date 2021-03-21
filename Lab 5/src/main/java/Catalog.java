import items.Item;
import lombok.Data;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data

/**
 * Class Catalog
 * Can contain items such as books, movies, songs
 */

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    /**
     * Constructor with no parameters
     */

    public Catalog() {
    }

    /**
     * Constructor with parameters
     * @param name represents the name of the catalog
     * @param path represents the path of the catalog
     */

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    /**
     * Constructor with parameters
     * @param name represents the name of the catalog
     * @param path represents the path of the catalog
     * @param items represents a list of items to be added in the catalog
     */

    public Catalog(String name, String path, List<Item> items) {
        this.name = name;
        this.path = path;
        this.items = items;
    }

    /**
     * Method for adding a new entry into the catalog
     * @param item represents the item to be added in the catalog
     */

    public void add(Item item) {
        items.add(item);
    }

    /**
     * Method for printing the content of the catalog
     */

    public void list() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    /**
     * Method for playing an item in the catalog
     * @param name represents the name of the item to be played
     * @throws IOException when the item is not found
     */

    public void play(String name) throws IOException {
        File file = new File(this.findByName(name).getPath());
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

    /**
     * Method for saving the catalog to an external file
     * @throws IOException when the path is invalid
     */

    public void save() throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.getPath()))) {
            outputStream.writeObject(this);
        }
    }

    /**
     * Method for loading a catalog from a given path
     * @param path represents the path of the catalog
     * @throws IOException when the path is invalid
     * @throws ClassNotFoundException when the class is not found
     */

    public void load(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            Catalog catalog = (Catalog) inputStream.readObject();
            this.name = catalog.name;
            this.path = path;
            this.items = catalog.items;
        }
    }

    /**
     * Method for finding an item with a given name in the catalog
     * @param name represents the name of the item
     * @return the item with the given name
     */

    public Item findByName(String name) {
        return items.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
}
