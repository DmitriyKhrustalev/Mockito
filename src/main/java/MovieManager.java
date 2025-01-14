import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private final List<String> movies = new ArrayList<>();
    private final int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }
    public void addMovie(String movie) {
        movies.add(movie);
    }

    public List<String> findAll() {
        return new ArrayList<>(movies);
    }
    public List<String> findLast() {
        int resultLength = Math.min(limit, movies.size());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < resultLength; i++) {
            result.add(movies.get(movies.size() - 1 - i));
        }
        return result;
    }

    public static void main(String[] args) {
        MovieManager manager = new MovieManager(3);

        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");

        System.out.println("All movies: " + manager.findAll());
        System.out.println("Last movies: " + manager.findLast());
    }
}
