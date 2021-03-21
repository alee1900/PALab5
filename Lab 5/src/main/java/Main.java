import exceptions.InvalidPathException;
import exceptions.InvalidYearException;
import items.Book;
import items.Movie;
import items.Song;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Catalog catalog = new Catalog("My Catalog", "E:/media/catalog.ser");
            catalog.add(new Book("1", "Hamlet", "E:/media/hamlet.pdf", "William Shakespeare"));
            catalog.add(new Movie("2", "Footloose", "E:/media/footloose.mp4", Arrays.asList("Julianne Hough", "Kenny Wormald", "Miles Teller", "Dennis Quaid")));
            catalog.add(new Song("3", "Black or white", "E:/media/black_or_white.mp3", "Michael Jackson", 1991));
            catalog.list();
            catalog.play("Footloose");
            catalog.play("Black or white");
            catalog.save();

            Catalog catalog1 = new Catalog();
            catalog1.load(catalog.getPath());
        } catch (InvalidPathException | InvalidYearException | ClassNotFoundException | IOException exception) {
            System.err.println(exception);
        }
    }
}
