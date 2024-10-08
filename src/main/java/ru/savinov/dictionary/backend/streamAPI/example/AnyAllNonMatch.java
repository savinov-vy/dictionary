package ru.savinov.dictionary.backend.streamAPI.example;

import java.util.stream.Stream;

public class AnyAllNonMatch {
    public static void main(String[] args) {
        String answerYes = "Yes";
        String answerNo = "No";

        Stream<Integer> stream1 = Stream.of(10, -22, 3, 12, 85, 0, 142);

        String answerNegativeEvenNumbers = hasNegativeEvenNumbers(stream1) ? answerYes : answerNo;
        System.out.println("Any negative even numbers in the stream? " + answerNegativeEvenNumbers);

        Stream<Integer> stream2 = Stream.of(10, 22, 3, 12, 85, 142);

        String answerOnlyPositiveNumbers = hasOnlyPositiveNumbers(stream2) ? answerYes : answerNo;
        System.out.println("Only positive numbers in the stream? " + answerOnlyPositiveNumbers);

        Stream<Integer> stream3 = Stream.of(-10, -22, -3, -12, -85, -142);

        String answerOnlyNegativeNumbers = hasOnlyNegativeNumbers(stream3) ? answerYes : answerNo;
        System.out.println("Only negative numbers in the stream? " + answerOnlyNegativeNumbers);

        Stream<Integer> stream4 = Stream.of(-10, -22, -3, -12, -85, -142);

        String answerOnlyNegativeNumbers2 = hasOnlyNegativeNumbersNonMatch(stream4) ? answerYes : answerNo;
        System.out.println("Only negative numbers in the stream? " + answerOnlyNegativeNumbers2);
    }

    public static boolean hasNegativeEvenNumbers(Stream<Integer> stream) {
        return stream
                .anyMatch(i -> (i < 0) && (i % 2 == 0));
    }

    public static boolean hasOnlyPositiveNumbers(Stream<Integer> stream) {
        return stream
                .allMatch(i -> i > 0);
    }

    public static boolean hasOnlyNegativeNumbers(Stream<Integer> stream) {
        return stream
                .allMatch(i -> i < 0);
    }

    public static boolean hasOnlyNegativeNumbersNonMatch(Stream<Integer> stream) {
        return stream
                .noneMatch(i -> i > 0);
    }
}
