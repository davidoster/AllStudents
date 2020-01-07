/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allstudents;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mac
 */
public class AllStudents {

    /**
     * @param args the command line arguments
     */
    private static List<Integer> numbers;
    static Random rand = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double multiplicationFactor = rand.nextDouble() * rand.nextInt(100);
        double divisor = rand.nextDouble() * rand.nextInt(100);
        setNumbers();
        printNumbers();
        System.out.println("Addition result: " + addNumbers());
        System.out.println("Subraction result: " + subtractNumbers());
        System.out.format("Multiplication by %.2f results in: ", multiplicationFactor);
        System.out.println(multiplyNumbers(multiplicationFactor));
        if (divisor != 0) {
            System.out.format("Division by %.2f results in: ", divisor);
            System.out.println(divideNumbers(divisor));
        } else {
            System.out.println("Division by 0 is undefined!");
        }
    }

    public static void setNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        int count = rand.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            Integer currentInteger = rand.nextInt(100);
            randomNumbers.add(currentInteger);
        }
        numbers = randomNumbers;
    }

    public static Integer addNumbers() {
        Integer sum = 0;
        sum = numbers.stream().map((number) -> number).reduce(sum, Integer::sum);
        return sum;
    }

    public static Integer subtractNumbers() {
        Integer difference = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            difference -= numbers.get(i);
        }
        return difference;
    }

    public static List<Integer> multiplyNumbers(double factor) {
        List<Integer> productList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            productList.add((Integer) (Math.round((float) (numbers.get(i) * factor))));
        }
        return productList;
    }

    public static List<Integer> divideNumbers(double divisor) {
        List<Integer> quotientList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            quotientList.add((Integer) (Math.round((float) (numbers.get(i) / divisor))));
        }
        return quotientList;
    }

    public static void printNumbers() {
        numbers.forEach((i) -> {
            System.out.println("Number: " + i);
        });
    }

}
