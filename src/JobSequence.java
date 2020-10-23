/**
 *  Greedy Algorithm 2:
 *  Job Sequencing
 *
 *  Given an array of jobs where every job has a deadline and
 *  associated profit if the job is finished before the
 *  deadline. It is also given that every job takes the single
 *  unit of time, so the minimum possible deadline for any job
 *  is 1. How to maximize total profit if only one job can be
 *  scheduled at a time.
 *
 *  Reference:
 *  https://www.geeksforgeeks.org/job-sequencing-problem/
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequence {
    char id;
    int deadline;
    int profit;

    public JobSequence(){}

    public JobSequence (char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    // arr = array list of jobs
    // t = number of jobs to schedule (chosen by user)
    public void printJobScheduling(List<JobSequence> arr, int t) {
        int n = arr.size();
        boolean[] timeslots = new boolean[t];
        char[] jobs = new char[t];

        // Sort jobs in decreasing order of profit
        Collections.sort(arr, (a, b) -> b.profit - a.profit);

        for (int i = 0; i < n; i++) {
            // Find a timeslot that is the most recent, available, and within the job deadline
            // We choose the most recent timeslot because if we choose the earlier timeslot,
            // it could prevent another profitable job from being done (try to think of a scenario
            // where two jobs have the same profit but the deadline is different)

            // For arr.get(i).deadline and t, we subtracted 1 from both because timeslot
            // from 0 to 1 is located at index 0, so if we have a job deadline = 1,
            // we cannot put the job at the most recent timeslot in index 1 but in index 0

            // For Math.min(t, arr.get(i).deadline), we get the minimum number between the two
            // (number of jobs and the job deadline) because if we have t = 2 and job deadline = 3,
            // we cannot put the job at the most recent timeslot in index 2 (after subtracting 1 from 3)
            // since the number of jobs to schedule is limited until index 1 (after subtracting 1 from 2),
            // so we can put it at index 1

            // Note:
            // Each job can be completed in a single unit of time.
            for (int j = Math.min(t , arr.get(i).deadline) - 1; j >= 0; j--) {
                if (timeslots[j] == false) {
                    timeslots[j] = true;
                    jobs[j] = arr.get(i).id;
                    break;
                }
            }
        }

        for (char job : jobs) {
            System.out.print(job + " ");
        }
    }

    public static void main(String[] args) {
        List<JobSequence> arr = new ArrayList<>();
        arr.add(new JobSequence('a', 2, 100));
        arr.add(new JobSequence('b', 1, 19));
        arr.add(new JobSequence('c', 2, 27));
        arr.add(new JobSequence('d', 1, 25));
        arr.add(new JobSequence('e', 3, 15));

        JobSequence job = new JobSequence();
        job.printJobScheduling(arr, 3);     // c a e
    }
}
