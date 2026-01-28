package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice1 {

	public static void main(String[] args) {

		// JAVA 8

		List<Integer> numbers = Arrays.asList(7, 2, 10, 0, 5, 9, 3, 1, 6, 8, 4);

		Map<Boolean, List<Integer>> seperatedNumbers = numbers.stream()
				.collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("even " + seperatedNumbers.get(true));
		System.out.println("odd " + seperatedNumbers.get(false));

		numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
		System.out.println();

		List<String> words = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		words.stream().distinct().forEach(System.out::println);

		String inputString = "Java Concept Of The Day, Java";
		Map<Character, Long> frequency = inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequency);

		Map<String, Long> frequency2 = words.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequency2);

		numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		Optional<Integer> secondSmallest = numbers.stream().sorted().skip(1).findFirst();
		System.out.println(secondSmallest);

		Optional<Integer> secondLargest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println(secondLargest);

		numbers.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
		numbers.stream().min(Comparator.naturalOrder()).ifPresent(System.out::println);

		int[] array1 = { 5, 2, 8, 1, 7 };
		int array2[] = { 9, 4, 6, 3, 7 };
		int[] resultArray = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).distinct().sorted().toArray();
		System.out.println(Arrays.toString(resultArray));
		
		int number = 123456789;
		System.out.println(String.valueOf(number).chars().map(Character::getNumericValue).sum());

		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		listOfStrings.stream().map(s -> s.toUpperCase()).forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.println(Arrays.stream(array1).sum());
		System.out.println(Arrays.stream(array1).average());

		List<Integer> numbers2 = Arrays.asList(17, 2, 10, 0, 15, 9, 13, 1, 16, 8, 4);
		numbers.stream().filter(numbers2::contains).forEach(n -> System.out.print(n + " "));
		System.out.println();

		Arrays.stream(inputString.split(" ")).map(w -> new StringBuffer(w).reverse())
				.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		System.out.println(IntStream.range(1, 10).sum());
		
		IntStream.rangeClosed(1, 10).map(n -> n * 2).forEach(n -> System.out.print(n + " "));
		
		String word2 = "racecar";
		boolean r = IntStream.range(0, word2.length() / 2)
				.allMatch(i -> word2.charAt(i) == word2.charAt(word2.length() - 1 - i));
		System.out.println("palindrom: " + r);

		List<String> words2 = Arrays.asList("Java", "1Python", "C#", "2Java", "Kotlin", "3Python");
		words2.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(n -> System.out.print(n + " "));

		List<Integer> listOfNumbers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		Set<Integer> setOfNumbers = new HashSet<>();
		Set<Integer> repeated = listOfNumbers.stream().filter(n -> !setOfNumbers.add(n)).collect(Collectors.toSet());
		System.out.println(repeated);
		
		inputString.replaceAll("\\s+", " ").toLowerCase();
		Set<String> setOfStrings = new HashSet<>();
		Set<String> repeated2 = Arrays.stream(inputString.split(" ")).filter(ch -> !setOfStrings.add(ch))
				.collect(Collectors.toSet());
		System.out.println(repeated2);
		
		Arrays.stream(array1).skip(array1.length - 1).findFirst().ifPresent(System.out::println);
		
		Set<Character> seen = new HashSet<>();
		Optional<Character> firstRepeated = word2.chars().mapToObj(c -> (char) c).filter(ch -> !seen.add(ch))
				.findFirst();
		System.out.println(firstRepeated);
		
		System.out.println(numbers2.stream().max(Integer::compare).get());

		int[] array3 = { 1, 2, 3, 1 };
		Set<Integer> setOfNumbers2 = new HashSet<>();
		System.out.println(Arrays.stream(array3).anyMatch(a -> !setOfNumbers2.add(a)));
		
		
		
		
		
		



		/*
		 * int[] array1 = { 7, 2, 10, 0, 5, 9, 3, 1, 6, 8, 4, 4, 4 };
		 * 
		 * Integer frequency3 = Arrays.stream(array1).boxed()
		 * .collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting())).entrySet();
		 */


	}

}