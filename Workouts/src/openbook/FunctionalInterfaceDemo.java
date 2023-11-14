package openbook;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // 1. Predicate Example
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        // Define a Predicate to check if a number is even
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // Use the Predicate to filter even numbers
        System.out.print("Even numbers: ");
        numbers.stream().filter(isEven).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // 2. Function Example
        // Define a Function to double a number
        Function<Integer, Integer> doubleFunction = num -> num * 2;

        // Use the Function to double each number and print the result
        System.out.print("Doubled numbers: ");
        numbers.stream().map(doubleFunction).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // 3. Consumer Example
        // Define a Consumer to print a number
        Consumer<Integer> printConsumer = num -> System.out.print(num + " ");

        // Use the Consumer to print each number
        System.out.print("Printed numbers: ");
        numbers.forEach(printConsumer);
        System.out.println();

        // 4. Supplier Example
        // Define a Supplier to generate random numbers
        Supplier<Integer> randomSupplier = () -> (int) (Math.random() * 100);

        // Use the Supplier to generate and print three random numbers
        System.out.print("Random numbers: ");
        for (int i = 0; i < 3; i++) {
            int randomNum = randomSupplier.get();
            System.out.print(randomNum + " ");
        }
    }
}

