
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathUtils {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in); // Create a Scanner object
		System.out.println("Please enter a list of numbers seperated by comma (,)");

		String myNumbers = myScanner.nextLine(); // Read user input
		if (isCommandPopulatedAndValid(myNumbers)) {
			processCommand(myNumbers);
		} else {
			System.out.println("Fail due to invalid command");
		}
		myScanner.close();

	}

	private static void processCommand(final String command) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers = Arrays.asList(splitCommandByComma(command)).stream().map(Integer::parseInt)
				.collect(Collectors.toList());

		if (isListGreaterThan5Indexs(numbers)) {
			System.out.println("Original List of numbers: " + numbers);
			System.out.println("Max Number: " + findMax(numbers));
			System.out.println("Min Number: " + findMin(numbers));
			System.out.println("Mean: " + findMean(numbers));
			System.out.println("Median: " + findMedian(numbers));
			System.out.println("List of numbers sorted ASC: " + sortAsc(numbers));
			System.out.println("List of numbers sorted DESC: " + sortDesc(numbers));
		} else {
			System.out.println("Failed due to  < 5 numbers");
		}

	}

	private static int findMax(final List<Integer> numbers) {
		return Collections.max(numbers);
	}

	private static int findMin(final List<Integer> numbers) {
		return Collections.min(numbers);
	}

	private static Double findMean(final List<Integer> numbers) {
		return numbers.stream().mapToDouble(number -> number).average().orElse(-1);
	}

	private static double findMedian(final List<Integer> numbers) {
		double median;
		if (numbers.size() % 2 == 0) {
			// use new list as numbers list is final and should not be changed
			List<Integer> sortedNumbers = sortAsc(numbers);
			int firstMiddleNum = sortedNumbers.get((sortedNumbers.size() / 2) - 1);
			int secondMiddleNum = sortedNumbers.get(sortedNumbers.size() / 2);
			sortedNumbers = sortedNumbers.stream()
					.filter(sortNum -> sortNum.equals(firstMiddleNum) || sortNum.equals(secondMiddleNum))
					.collect(Collectors.toList());
			median = findMean(sortedNumbers);
		} else {
			int indexToGet = numbers.size() / 2; // java already round
			median = numbers.get(indexToGet);
		}
		return median;
	}

	private static List<Integer> sortAsc(final List<Integer> numbers) {
		Collections.sort(numbers); // returns null
		return numbers;
	}

	private static List<Integer> sortDesc(final List<Integer> numbers) {
		Collections.sort(numbers, Collections.reverseOrder()); // returns null
		return numbers;

	}

	private static boolean isListGreaterThan5Indexs(final List<Integer> list) {
		return list.size() >= 5;
	}

	private static boolean isCommandPopulatedAndValid(final String command) {
		return (!command.equals("") && !command.equals(null) && (splitCommandByComma(command).length > 1));
	}

	private static String[] splitCommandByComma(final String command) {
		return command.trim().split("\\s*,\\s*");
	}
}
