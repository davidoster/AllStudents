package allstudents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllStudents {

    static List<Integer> theNumbers = new ArrayList<>(Arrays.asList(new Integer[]{500, 100, 300, 400}));

    public static void main(String[] args) {
        int i = 0;
        printNumbers();
        System.out.println(addNumbers());
        System.out.println(subtractNumbers());
        System.out.println(multiplyNumbers(10));
        System.out.println(divideNumbers(100));

    }

    public static Integer addNumbers() {
        Integer sum = 0;
//        for(int i = 0; i < theNumbers.size(); i++) sum += i;
        sum = theNumbers.stream().map((i) -> i).reduce(sum, Integer::sum);
//        sum = theNumbers.stream().map((i) -> i).reduce(sum, Integer::sum);
        return sum;
    }

    public static Integer subtractNumbers() {
        Integer sub = 0;
        for (Integer i : theNumbers) {
            sub -= i;
        }
//        sub = theNumbers.stream().map((i) -> i).reduce(sub, (accumulator, _item) -> accumulator - _item);
        return sub;
    }

    public static List<Integer> multiplyNumbers(Integer givenNumber) {
        List<Integer> intList = new ArrayList<>();
        int count = 0;
        for (Integer i : theNumbers) {
            intList.add(i * givenNumber);
            System.out.println("Multiply " + i + " by " + givenNumber + " Equals: " + intList.get(count));
            count++;
        }
        return intList;
    }

    public static List<Integer> divideNumbers(Integer givenNumber) {
        List<Integer> intList = new ArrayList<>();
        int count = 0;
        if (givenNumber == 0) {
            System.out.println("Division by zero is not possible. Returning null");
            return null;
        }
        for (Integer i : theNumbers) {
            intList.add(i / givenNumber);
            System.out.println("Divide " + i + " by " + givenNumber + " Equals: " + intList.get(count));
            count++;
        }
        return intList;
    }

    public static void printNumbers() {
        //for(Integer i : theNumbers) System.out.println("Number " + i);
        for (Integer i : theNumbers) {
            printANumber(i);
        }
        theNumbers.forEach((i) -> printANumber(i));
        theNumbers.forEach((i) -> {
            System.out.println("Number " + i);
        });
        System.out.println("Total Numbers : " + theNumbers.size());
    }

    public static void printANumber(Integer i) {
        System.out.println("i = " + i);
    }
    
}
