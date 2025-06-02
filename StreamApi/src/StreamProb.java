import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamProb {

    public static void main(StringExample[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Create a Stream from the list
        Stream<String> namesStream = names.stream();
        namesStream.forEach(System.out::println);

        //(this will cause an IllegalStateException)
        try {
            long count = namesStream.count();  // ERROR: stream has already been operated upon or closed
            System.out.println("Count: " + count);
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: Cannot reuse a stream after a terminal operation.");
        }

        // Correct way: create a new stream if you want to reuse
        long count = names.stream().count();
        System.out.println("Count after creating new stream: " + count);
    }
}
