package misc_topics.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

//Functional interface has only one abstract method
//Java provides many built in functional interfaces so custom functional interfaces not always required
@FunctionalInterface
interface FuncInterface {
    String processString(int s);
}

public class LambdaDemo {
    //with anonymous inner class
    public static void printSomeNumbersLAnonymousInnerCls(List<Integer> listOfInts) {
        FuncInterface funcInterface = new FuncInterface() { //anonymous inner class created here
            @Override
            public String processString(int s) {
                return "The number with inner class is: " + s;
            }
        };
        for (var number : listOfInts) {
            System.out.println(funcInterface.processString(number));
        }
    }

    //With lambda
    public static void printSomeNumbersLambda(List<Integer> listOfInts) {
        FuncInterface functionalInterface = (inputNum) -> "The number with lambda is: " + inputNum;
        for (var number : listOfInts) {
            System.out.println(functionalInterface.processString(number));
        }
    }

    //with built in functional interface
    public static void printWithBuiltFunctionalInterfaceJava(List<Integer> listOfInts) {
        //Function is a built in functional interface
        Function<Integer, String> function = (inputNum) -> "The number with built in functional interface is: " + inputNum;
        for (var number : listOfInts) {
            System.out.println(function.apply(number));
        }
    }

    //classic use case: the behavior, i.e. the lambda, is left for the caller to define
    public static void lambdaAsParam(List<Integer> listOfInts, Function<Integer, String> function) {
        for (var number : listOfInts) {
            System.out.println(function.apply(number));
        }
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        printSomeNumbersLambda(input);
        printSomeNumbersLAnonymousInnerCls(input);
        printWithBuiltFunctionalInterfaceJava(input);
        lambdaAsParam(input, (x) -> "The number with lambda param is: " + x);
    }
}


