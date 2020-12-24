package com.adventofcode.day.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/***
 * find the three entries that sum to 2020 and then multiply those three numbers together
 * 
 * @author s.keshmiri
 *
 */
public class ExpenseReportPartTwo {

	static int TARGET = 2020;

	public static void main(String[] args) {
		ArrayList<Integer> expenses = loadList();

		System.out.println(answer(expenses));

	}

	private static ArrayList<Integer> loadList() {
		ArrayList<Integer> expenses = new ArrayList<>();

		try (Scanner scanner = new Scanner(
				new File("/Users/s.keshmiri/eclipse-workspace/AdventOfCode/src/com/adventofcode/day/one/input.txt"))) {
			while (scanner.hasNextLine()) {
				Integer number = Integer.valueOf(scanner.nextLine());
				expenses.add(number);
			}
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		}
		return expenses;
	}

	private static int answer(List<Integer> list) {

		for (int i = 0; i < list.size(); i++) {
			int first = list.get(i);
			for (int j = 1; j < list.size(); j++) {
				int second = list.get(j);
				for (int k = 2; k < list.size(); k++) {
					int third = list.get(k); 
					if (first + second + third == TARGET) {
						return first * second * third;
					}
				}
			}
		}
		return 0;
	}

}
