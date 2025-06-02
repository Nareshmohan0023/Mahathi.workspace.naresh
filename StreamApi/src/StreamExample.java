import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(StringExample[] args) {

		// Create Stream from List
		List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Mark");

		List<String> result = names.stream() // Create stream
				.filter(name -> name.startsWith("A")) // Filter names starting with A
				.map(String::toUpperCase) // Convert to uppercase
				.collect(Collectors.toList()); // Collect to List

		System.out.println("Filtered Names: " + result); // Output: [ALICE, ANNA]

		//////////////////////

		// Create Stream from Array
		int[] numbers = { 1, 2, 3, 4, 5 };
		int sum = Arrays.stream(numbers) // IntStream
				.sum(); // Terminal operation

		System.out.println("Sum: " + sum); // Output: 15

		///////////////////////

		// Create Stream using Stream.of()
		List<String> list = java.util.stream.Stream.of("Java", "Python", "C++").collect(Collectors.toList());

		System.out.println("Languages: " + list); // Output: [Java, Python, C++]

		///////////////////////////////

		// FlatMap Example
		List<List<String>> nested = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C", "D"));

		List<String> flat = nested.stream().flatMap(innerList -> innerList.stream()).collect(Collectors.toList());

		System.out.println("Flattened List: " + flat); // Output: [A, B, C, D]

		/////////////////////////////////

//        DSA

		// 1 ->Square Of Even Numbers
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);

		List<Integer> result1 = numbers1.stream().filter(n -> n % 2 == 0) // Keep even numbers
				.map(n -> n * n) // Square them
				.sorted() // Sort the result
				.collect(Collectors.toList()); // Collect into list

		System.out.println("Squares of even numbers (sorted): " + result1); // Output: [4, 16, 36]

		// 2 ->frequency

		List<String> list1 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

		Map<String, Long> freq = list1.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		System.out.println(freq); // output: {orange=1, banana=2, apple=3}

		// for each
		List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie");
		List<String> uppercaseNames = new ArrayList<>();

		names1.stream().map(String::toUpperCase).forEach(name -> uppercaseNames.add(name));

		System.out.println(uppercaseNames); // [ALICE, BOB, CHARLIE]

	

	}
}
