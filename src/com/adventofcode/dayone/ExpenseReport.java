package com.adventofcode.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseReport {
	static int TARGET = 2020;

	public static void main(String[] args) {
	
		ArrayList<Integer> expenses = loadList();
		
		System.out.println(answer(expenses));
	}

	private static ArrayList<Integer> loadList() {
		ArrayList<Integer> expenses = new ArrayList<>();
		
		try (Scanner scanner = new Scanner(
				new File("/Users/s.keshmiri/eclipse-workspace/AdventOfCode/src/com/adventofcode/dayone/input.txt"))) {
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
			int current = list.get(i);
			for (int j = 1; j < list.size(); j++) {
				int next = list.get(j);
				
				if (current + next == TARGET) {
					return current * next;
				}
			}
		}
		return 0;
	}
	
	

}
