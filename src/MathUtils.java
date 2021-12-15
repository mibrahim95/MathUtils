
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
		processCommand(myNumbers);
		myScanner.close();

	}

	public static void processCommand(final String command) {
		List<String> stringNumbers = Arrays.asList(command.trim().split("\\s*,\\s*"));
		if (isListPopulated(stringNumbers)) {
			List<Integer> intNumbers = stringNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());

			if (isListGreaterThan5Indexs(intNumbers)) {
				int max = findMax(intNumbers);
				int min = findMin(intNumbers);
				double mean = findMean(intNumbers);
				double median = findMedian(intNumbers);
				List<Integer> ascSort = sortAsc(intNumbers);
				List<Integer> descSort = sortDesc(intNumbers);

				System.out.println("Original List of numbers: " + intNumbers);
				System.out.println("Max Number: " + max);
				System.out.println("Min Number: " + min);
				System.out.println("Mean: " + mean);
				System.out.println("Median: " + median);
				System.out.println("List of numbers sorted ASC: " + ascSort);
				System.out.println("List of numbers sorted DESC: " + descSort);

			} else {
				System.out.println("Failed due to  < 5 numbers");
			}
		} else {
			System.out.println("Fail due to empty String ArrayList");
		}
	}

	public static int findMax(final List<Integer> numbers) {
		return Collections.max(numbers);
	}

	public static int findMin(final List<Integer> numbers) {
		return Collections.min(numbers);
	}

	public static Double findMean(final List<Integer> numbers) {
		return numbers.stream().mapToDouble(number -> number).average().orElse(-1);
	}

	public static double findMedian(final List<Integer> numbers) {
		double median;
		if (numbers.size() % 2 == 0) {
			List<Integer> sortedNumbers = sortAsc(numbers);
			int firstMiddleNum = (sortedNumbers.size() / 2) - 1;
			int secondMiddleNum = sortedNumbers.size() / 2;
			List<Integer> middleNums = new ArrayList<>();
			middleNums.add(sortedNumbers.get(firstMiddleNum));
			middleNums.add(sortedNumbers.get(secondMiddleNum));
			median = findMean(middleNums);
		} else {
			int indexToGet = numbers.size() / 2; // java already round
			median = numbers.get(indexToGet);
		}
		return median;
	}

	public static List<Integer> sortAsc(final List<Integer> numbers) {
		List<Integer> sortAsc = new ArrayList<>(numbers);
		Collections.sort(sortAsc);
		return sortAsc;
	}

	public static List<Integer> sortDesc(final List<Integer> numbers) {
		List<Integer> sortDesc = new ArrayList<>(numbers);
		Collections.sort(sortDesc, Collections.reverseOrder());
		return sortDesc;

	}

	public static boolean isListPopulated(final List<String> list) {
		return !list.isEmpty();
	}

	public static boolean isListGreaterThan5Indexs(final List<Integer> list) {
		return (!list.isEmpty() && list.size() >= 5);
	}

}
