package misc_topics.lambdas;

//Step 1: Create a functional interface.
//Note there are many built in functional interfaces in java
//E.g. Runnable is a functional interface
@FunctionalInterface
interface Lambda {
    int processString(String s);
}

public class FuncInterfaceLambda {
    //Step 2: A function that has input parameter of lambda
    public static void strLength(Lambda lm, int a, int b) {
        System.out.println(lm.processString("Hello World!") + a / b);
    }

    public static void main(String[] args) {
        //Step 3: Calling a function that takes lambda and implement that function
        strLength(s -> s.length(), 5, 5);

        //Another way of using lambda.
        //Create the lambda and then call the lambda with input params
        Lambda l2 = (a) ->a.length();
        System.out.println("Length is .. " + l2.processString("Hi follks....!"));

    }
}
