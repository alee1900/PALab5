package items;

import exceptions.InvalidPathException;
import exceptions.InvalidYearException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString

/**
 * Class Song, which is an item
 */

public class Song extends Item {
    private String singer;
    private int releaseYear;

    /**
     * Constructor with parameters
     * @param id represents the id of the song from the catalog
     * @param name represents the name of the song
     * @param path represents the path of the song
     * @param singer represents the singer of the song
     * @param releaseYear represents the release year of the song
     * @throws InvalidPathException when the path is invalid
     * @throws InvalidYearException when the release year is invalid
     */

    public Song(String id, String name, String path, String singer, int releaseYear) throws InvalidPathException, InvalidYearException {
        super(id, name, path);
        this.singer = singer;

        if(releaseYear < 1900) {
            throw new InvalidYearException("Invalid year");
        } else {
            this.releaseYear = releaseYear;
        }
    }
}
