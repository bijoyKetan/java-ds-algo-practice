package core;

import core.Util.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

public class TipsTricks {

    @Test
    public void iteratorExample() {
        //Set ups
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3);
        queue.offer(9);

        //Iterate over a collection
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            var a = it.next();
            System.out.println("Queue item: " + a);
        }

        Map<String, String> map = new HashMap<>();
        map.put("Name", "Kyle");
        map.put("Location", "NY");
        map.put("Car", "Toyota");
        //Iterate over a map with iterator
        for (Map.Entry<String, String> e : map.entrySet()) {
            var key = e.getKey();
            var value = e.getValue();
            System.out.format("%s : %s\n", key, value);
        }

        //Iterate map in Java 8 way
        //Note: for void functions use forEach.
        // Otherwise use standard map function with streams
        map.forEach((k, v) -> {
            System.out.println(String.format("Key is %s & value is %s", k, v));
        });
    }


    @Test
    public void ifElseExample() {
        //CASE 1 - Multiple if: each condition is checked independently
        for (int i = 0; i < 10; i += 2) { //0, 2, 4, 6, 8
            if (i < 5) System.out.printf(" %s < 5, \t", i);
            if (i < 6) System.out.printf(" %s < 6, \t", i);
            if (i < 7) System.out.printf(" %s < 7, \t", i);
            if (i < 8) System.out.printf(" %s < 8, \t", i);
            System.out.println(" Final statement");
        }
        //CASE 1 RESULT
        /*
         0 < 5, 	 0 < 6, 	 0 < 7, 	 0 < 8, 	 Final statement
         2 < 5, 	 2 < 6, 	 2 < 7, 	 2 < 8, 	 Final statement
         4 < 5, 	 4 < 6, 	 4 < 7, 	 4 < 8, 	 Final statement
         6 < 7, 	 6 < 8, 	 Final statement
        Final statement
        */

        System.out.println("\n\n");

        //CASE 2 - if + else if: each else if is dependent on the previous if/ else if condition
        //and will be executed only if the previous checks are not satisfied
        for (int i = 0; i < 10; i += 2) { //0, 2, 4, 6, 8
            if (i < 5) System.out.printf(" %s < 5, \t", i);
            else if (i < 6) System.out.printf(" %s < 6, \t", i);
            else if (i < 7) System.out.printf(" %s < 7, \t", i);
            else if (i < 8) System.out.printf(" %s < 8, \t", i);
            else System.out.println(" Final statement");
        }
        //CASE 2 RESULT
        //  0 < 5, 	 2 < 5, 	 4 < 5, 	 6 < 7, 	 Final statement
    }

    @Test
    public void miscTricks() {
        int a = 10, b = 20;
        System.out.println(String.format("A is %s, and B is %s", a, b));
    }

    @Test
    public void orderOfExecution() {
        int[] arr = new int[]{1, 2, 3, 4};

        int i = 0;
        while (i < arr.length) {
            //if (i < arr.length - 1 && i % 2 == 0) {
            if (i % 2 == 0 && i < arr.length - 1) {
                var num = arr[i + 1];
                System.out.println(num);
                i++;
            } else {
                i++;
            }
        }
    }

    @Test
    //Succinct way to return boolean on two conditions
    public void returnBooleanSuccinct() {
        int n = 1;
        // if n == 1 then return true;
        //else return false
        System.out.println((n == 1));
    }


    @Test
    public void getRangeOfInts() {
        //A list of even integers from 0 to 10 (NOT including 10)
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 10).forEach(x -> {
            if (x % 2 == 0) list.add(x);
        });
        System.out.println(list.toString());
        //[0, 2, 4, 6, 8]
    }

    @Test
    //Sample code to access the digits of an integer
    public void digitsOfInteger() {
        int num = 12345;
        Deque<Integer> stack = new ArrayDeque<>();
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }

        //Iterating a stack gives items in LIFO order
        for (int i : stack) {
            System.out.println("Num is " + i);
        }
    }

    @Test
    //To end a function without doing anything (e.g. void), simply return;
    public void demoReturn() {
        ListNode head = null;
        if (head == null || head.next == null) {
            System.out.println("Return demo");
            return;
        }
        //The following will not be executed if return condition is met
        int a = 10;
        System.out.println(String.format("The value of a is, %s", a));
    }

    //LinkedList reversal
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //Find middle of a linkedList
    public ListNode findMiddleLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Test
    //do something with each of the digits of a number
    public void sumSquare() {
        int num = 23;
        int sum = 0;
        while (num > 0) {
            //Math.pow -> Double
            sum += (int) Math.pow(num % 10, 2);
            num = num / 10;
        }
        System.out.println(sum);
    }

    @Test
    public void testBreakStatement() {
        //when break condition == true, break out of the
        // for/while loop right above the if condition
        int i = 0;
        List<Integer> results = new ArrayList<>();
        while (i < 10) {
            results.add(i);
            if (i == 7) {
                break;
            }
            i++;
        }
        System.out.println(results.toString());
        //[0, 1, 2, 3, 4, 5, 6, 7]
    }

    @Test
    public void testWhileLoopCond() {
        boolean isResult = false;
        int n = 19;
        Set<Integer> sumSet = new HashSet<>();
        int sum = n;
        while (!sumSet.contains(sum)) {
            //sum = doSomething(sum); // incorrect location to change the sum
            // 1. Add first to a tracker
            // 2. Check or success
            // 3. Modify
            sumSet.add(sum);
            if (sum == 1) {
                isResult = true;
            }
            sum = doSomething(sum); //Correct place to modify the sum
        }
    }

    private int doSomething(int sum) {
        return 0;
    }

    //A trick for quickly checking for zero condition (often used in DP)
    public void testIfOneIsZero() {
        int a = 0;
        int b = 5;
        int result;
        if (a * b == 0) {
            result = a + b;
        }
    }

    @Test
    public void charFrequency() {
        String s = "TestCharacter";
        //256 encodings in ASCII
        //freq[][1] -> frequency
        int[][] freq = new int[256][2];
        char[] charArr = s.toCharArray();
        for (Character c : charArr) {
            freq[c][0] = c;
            freq[c][1] += 1;
        }
    }

    @Test
    //Get closest to target in sorted array
    public int whileLoopUpdate(int[] arr, int target) {
        if (arr.length == 1) return arr[0];
        int left = 0; //left bound
        int right = arr.length - 1; //right bound
        int mid = (left + right) / 2; //midpoint

        if (arr[left] == target) return target;
        else if (arr[right] == target) return target;
        //both conditions needed, e.g. arr[1,2] and arr[1,2,3]
        while (left < mid && right > mid) {
            if (arr[mid] == target) return target;
            else if (arr[mid] > target) right = mid;
            else left = mid;
            //Note: vars in while condition must be updated before entering next iteration
            mid = (left + right) / 2;
        }
        return target - arr[left] <= arr[right] - target ? arr[left] : arr[right];
    }

}
