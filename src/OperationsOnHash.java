import java.util.HashMap;
import java.util.Map;

public class OperationsOnHash {

    public static String[] movie_recommendor(Map<String, String>[] movie_array, int flight_length){
        Map<Integer, String> movie_times = new HashMap<>();
        for (Map<String, String> movie : movie_array){
            int runtime = Integer.parseInt(movie.get("runtime"));
            int difference = flight_length - runtime;
            if (movie_times.containsKey(difference)){
                return new String[]{movie_times.get(difference), movie.get("title")};
            }
            movie_times.put(runtime, movie.get("title"));
        }
        return new String[]{"no", "eh"};
    }
}
