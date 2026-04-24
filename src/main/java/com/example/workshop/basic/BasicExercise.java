package com.example.workshop.basic;

import java.util.*;

public class BasicExercise {
    public static void main(String[] args) {

        List<int[]> numberArrays = new ArrayList<>();
        int[] array1 = {1, 1, 3, 5};
        int[] array2 = {1, 6, 8, 10};
        int[] array3 = {1, 2, 4, 5};

        numberArrays.add(array1);
        numberArrays.add(array2);
        numberArrays.add(array3);

        List<int[]> result = findArraysWithAtLeast2Numbers(numberArrays);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

        List<List<Integer>> integerListsList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(10);
        list2.add(11);
        list2.add(13);
        list2.add(15);

        list3.add(52);
        list3.add(55);
        list3.add(59);

        list4.add(1);
        list4.add(13);
        list4.add(23);
        list4.add(32);
        list4.add(45);
        list4.add(54);
        list4.add(111);

        integerListsList.add(list1);
        integerListsList.add(list2);
        integerListsList.add(list3);
        integerListsList.add(list4);

        findMedianaAndCalculateAverage(integerListsList);


        String[] numbers = {"1", "3", "6", "10", "12", "14", "15", "18" };
        int sum = calculateSumFromFirstNumbers(numbers);
        System.out.println("My sum equals: " + sum);

    }

    //napisz metode ktora jako argument pobiera liste tablice intow a jako wynik zwraca te tablice ktore mają minimum dwie liczby parzyste

    public static List<int[]> findArraysWithAtLeast2Numbers(List<int[]> arraysList) {

        List<int[]> result = new ArrayList<>();
        if (arraysList == null && arraysList.isEmpty()) {
            throw new IllegalArgumentException("Your list is null or empty");
        }
        for (int[] ints : arraysList) {
            int count = 0;
            if (ints.length == 0) {
                throw new IllegalArgumentException("Your array is empty");
            }
            for (int number : ints) {
                if (number % 2 == 0) {
                    count++;
                }
            }
            if (count >= 2) {
                result.add(ints);
            }
        }
        return result;
    }


    //Masz listę list liczb całkowitych.
    //Twoim zadaniem jest:
    //
    //Spłaszczyć strukturę (List<List<Integer>>)
    //Wyznaczyć:
    //średnią arytmetyczną
    //medianę
    //
    //2 osobne metody

    public static void findMedianaAndCalculateAverage(List<List<Integer>> numbersList) {
        if (numbersList == null || numbersList.isEmpty()) {
            throw new IllegalArgumentException("Your list of integer lists is null or empty");
        }

        List<Integer> numbers = new ArrayList<>();
        int medianaResult;
        double averageResult = 0;

        numbersList.stream()
                .map(list -> Optional.ofNullable(list)
                        .filter(l -> !l.isEmpty())
                        .orElseThrow(() -> new IllegalArgumentException("Your integer list is null or empty")))
                .forEach(numbers::addAll);

        medianaResult = findMediana(numbers);
        System.out.println("Mediana: " + medianaResult);

        double average = calculateAverage(numbers, averageResult);
        System.out.println("Average: " + average);
    }

    private static double calculateAverage(List<Integer> numbers, double averageResult) {
        for (Integer number : numbers) {
            int sum = +number;
            averageResult = (double) sum / numbers.size();
        }
        return averageResult;
    }

    private static int findMediana(List<Integer> numbers) {
        int result;
        Collections.sort(numbers);
        int half = numbers.size() / 2;
        if (numbers.size() % 2 != 0) {
            result = numbers.get(half);
        } else {
            result = (numbers.get(half) + numbers.get(half + 1) / 2);
        }
        return result;
    }

    //rozwiniecie zadania
    //
    //Spłaszczenie danych
    //pomiń null listy i null wartości
    //
    //usuń duplikaty
    //
    //uwzględnij tylko liczby z zakresu <0, 1_000_000>
    //
    //Dodatkowe wymagania
    //nie używaj .toList() jeśli dane > 1 mln (stream processing)
    //
    //obsłuż puste dane (Optional / wyjątek)
    //
    //unikaj podwójnego przetwarzania (performance)


    //Napisz metode która z tablicy Stringw wyciagnie wszystkie liczby pierwsze i zwróci ich sume

    public static int calculateSumFromFirstNumbers(String[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Your array is null or empty");
        }
        int sum = 0;
        for (String number : numbers) {
            if (number == null) {
                throw new IllegalArgumentException("Your number in array is null");
            }
            int temp = Integer.parseInt(number);
            if (temp > 0) {
                if (temp % 1 == 0 && temp % temp == 0) {
                    sum += temp;
                }
            }
        }
        return sum;
    }


}
