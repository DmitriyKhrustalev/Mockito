import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void testAddAndFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        assertArrayEquals(new String[]{"Movie 1", "Movie 2"}, manager.findAll());
    }

    @Test
    public void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
        manager.addMovie("Movie 6");

        assertArrayEquals(new String[]{"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"}, manager.findLast());
    }

    @Test
    public void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");

        assertArrayEquals(new String[]{"Movie 4", "Movie 3", "Movie 2"}, manager.findLast());
    }

    @Test
    public void testFindLastWithFewerMoviesThanLimit() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        assertArrayEquals(new String[]{"Movie 2", "Movie 1"}, manager.findLast());
    }
}
