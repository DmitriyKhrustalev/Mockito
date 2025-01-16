import java.util.Arrays;

public class MovieManager {

    private String[] movies;
    private int size;
    private final int limit;

    public MovieManager() {
        this.limit = 5;
        this.movies = new String[0];
        this.size = 0;
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new String[0];
        this.size = 0;
    }

    public void addMovie(String movie) {
        if (size == movies.length) {
            movies = Arrays.copyOf(movies, size + 1);
        }
        movies[size] = movie;
        size++;
    }

    public String[] findAll() {
        return Arrays.copyOf(movies, size);
    }

    public String[] findLast() {
        int resultLength = Math.min(limit, size);
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[size - 1 - i];
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

        System.out.println("All movies: " + Arrays.toString(manager.findAll()));
        System.out.println("Last movies: " + Arrays.toString(manager.findLast()));
    }
}
