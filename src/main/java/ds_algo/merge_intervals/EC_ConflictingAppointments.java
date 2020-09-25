package ds_algo.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EC_ConflictingAppointments {
    //Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
    public static boolean canAttendAllAppointments(int[][] intervals) {
        if (intervals.length < 2) return true;
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testConflictAppointment(){
        System.out.println(canAttendAllAppointments(new int[][]{{1,4}, {2,5}, {7,9}})); //false
        System.out.println(canAttendAllAppointments(new int[][]{{6,7}, {2,4}, {8,12}})); //true
        System.out.println(canAttendAllAppointments(new int[][]{{4,5}, {2,3}, {3,6}})); //false
    }
}
