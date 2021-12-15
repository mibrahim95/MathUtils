package main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandHandler {

	public void processCommand(final String command) {
		MathUtils mathUtil = new MathUtils();
		Validator validator = new Validator();

		List<String> stringNumbers = Arrays.asList(command.trim().split("\\s*,\\s*"));
		if (validator.isListPopulated(stringNumbers)) {
			List<Integer> intNumbers = stringNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());

			if (validator.isListGreaterThan5Indexs(intNumbers)) {
				int max = mathUtil.findMax(intNumbers);
				int min = mathUtil.findMin(intNumbers);
				double mean = mathUtil.findMean(intNumbers);
				double median = mathUtil.findMedian(intNumbers);
				List<Integer> ascSort = mathUtil.sortAsc(intNumbers);
				List<Integer> descSort = mathUtil.sortDesc(intNumbers);

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

}
