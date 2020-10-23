/**
 * Greedy Algorithm 1:
 * Activity Selection
 *
 * You are given n activities with their start and finish times.
 * Select the maximum number of activities that can be performed
 * by a single person, assuming that a person can only work on a
 * single activity at a time.
 *
 *  Example:
 *
 *  Example 1 : Consider the following 3 activities sorted by
 *  by finish time.
 *  start[]  =  {10, 12, 20};
 *  finish[] =  {20, 25, 30};
 *  A person can perform at most two activities. The
 *  maximum set of activities that can be executed
 *  is {0, 2} [ These are indexes in start[] and
 *  finish[] ]
 *
 *  Example 2 : Consider the following 6 activities
 *  sorted by by finish time.
 *  start[]  =  {1, 3, 0, 5, 8, 5};
 *  finish[] =  {2, 4, 6, 7, 9, 9};
 *  A person can perform at most four activities. The
 *  maximum set of activities that can be executed
 *  is {0, 1, 3, 4} [ These are indexes in start[] and
 *  finish[] ]
 *
 *  Reference:
 *  https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 */

public class ActivitySelection {
    public static void printMaxActivities(int s[], int f[], int n) {
        int i = 0;
        System.out.print(i + " ");

        // Note:
        // Make sure activities are sorted according to their finishing time
        // before proceeding with the logic.
        for (int j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 6, 7, 9, 9};
        int n = s.length;

        printMaxActivities(s, f, n);    // 0 1 3 4
    }
}
