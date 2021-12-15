package main;


import java.util.List;

public class Validator {



	public boolean isListPopulated(final List<String> list) {
		return !list.isEmpty();
	}

	public boolean isListGreaterThan5Indexs(final List<Integer> list) {
		return (!list.isEmpty() && list.size() >= 5);
	}

}
