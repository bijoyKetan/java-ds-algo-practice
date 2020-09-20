package misc_topics.try_catch_finally;

public class ExceptionFlow {

    //Case - exception thrown in try and caught in catch block
    public static String tryCatchWithException() {
        int a = 0;
        int b = 10;
        String result = "";
        try {
            System.out.println("Before exception inside try block");
            result = String.valueOf(b / a);//throws exception
            System.out.println("After exception inside try block");
        } catch (ArithmeticException e) {
            result = "Undefined";
            System.out.println("Inside catch block");
        }
        System.out.println("After and outside try-catch block");
        return "The result is: " + result;
    }

    public static String tryCatchFinallyWithException() {
        int a = 0;
        int b = 10;
        String result = "";
        try {
            System.out.println("Before exception inside try block");
            result = String.valueOf(b / a);//throws exception
            System.out.println("After exception inside try block");
        } catch (ArithmeticException e) {
            result = "Undefined";
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Inside the finally block");
        }
        System.out.println("After and outside try-catch block");
        return "The result is: " + result;
    }


    public static String tryCatchFinallyNoException() {
        int a = 1;
        int b = 10;
        String result = "";
        try {
            System.out.println("Before exception inside try block");
            result = String.valueOf(b / a);//no exception
            System.out.println("No exception in try block");
        } catch (ArithmeticException e) {
            result = "Undefined";
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Inside the finally block");
        }
        System.out.println("After and outside try-catch block");
        return "The result is: " + result;
    }

    public static String tryCatchFinallyExceptionOutsideTry() {
        int a = 0;
        int b = 10;
        String result = "";
        int errorInt = b/a; //Exception thrown here and is not handled, so execution stops here.
        //No code below this gets executed
        try {
            System.out.println("Inside try block");
        } catch (ArithmeticException e) {
            result = "Undefined";
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Inside finally block");
        }
        System.out.println("After and outside try-catch block");
        return "The result is: " + result;
    }

    public static void main(String[] args) {
//        tryCatchWithException();
//        tryCatchFinallyWithException();
//        tryCatchFinallyNoException();
        tryCatchFinallyExceptionOutsideTry();
    }
}
