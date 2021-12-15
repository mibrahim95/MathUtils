package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathUtils {

	public int findMax(final List<Integer> numbers) {
		return Collections.max(numbers);
	}

	public int findMin(final List<Integer> numbers) {
		return Collections.min(numbers);
	}

	public Double findMean(final List<Integer> numbers) {
		return numbers.stream().mapToDouble(number -> number).average().orElse(-1);
	}

	public double findMedian(final List<Integer> numbers) {
		double median;
		if (numbers.size() % 2 == 0) {
			List<Integer> sortedNumbers = this.sortAsc(numbers);
			int firstMiddleNum = (sortedNumbers.size() / 2) - 1;
			int secondMiddleNum = sortedNumbers.size() / 2;
			List<Integer> middleNums = new ArrayList<Integer>();
			middleNums.add(sortedNumbers.get(firstMiddleNum));
			middleNums.add(sortedNumbers.get(secondMiddleNum));
			median = this.findMean(middleNums);
		} else {
			int indexToGet = numbers.size() / 2; // java already round
			median = numbers.get(indexToGet);
		}
		return median;
	}

	public List<Integer> sortAsc(final List<Integer> numbers) {
		List<Integer> sortAsc = new ArrayList<Integer>(numbers);
		Collections.sort(sortAsc);
		return sortAsc;
	}

	public List<Integer> sortDesc(final List<Integer> numbers) {
		List<Integer> sortDesc = new ArrayList<Integer>(numbers);
		Collections.sort(sortDesc, Collections.reverseOrder());
		return sortDesc;

	}

}
