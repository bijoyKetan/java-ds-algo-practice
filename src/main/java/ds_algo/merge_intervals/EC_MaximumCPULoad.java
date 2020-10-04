package ds_algo.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class EC_MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        // TODO: Write your code here
        //sort all the jobs by start time
        jobs.sort((j1, j2) -> j1.start - j2.start);

        
        return -1;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + EC_MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + EC_MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + EC_MaximumCPULoad.findMaxCPULoad(input));
    }
}

