/**
 *  Greedy Algorithm 3:
 *  Minimum Number of Coins
 *
 *  Given a value V, if we want to make a change for V Rs, and we
 *  have an infinite supply of each of the denominations in Indian currency,
 *  i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000}
 *  valued coins/notes, what is the minimum number of coins and/or notes
 *  needed to make the change?
 *
 *  Examples:
 *
 *  Input: V = 70
 *  Output: 2
 *  We need a 50 Rs note and a 20 Rs note.
 *
 *  Input: V = 121
 *  Output: 3
 *  We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.
 *
 *  Reference:
 *  https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
 */

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfCoins {
    public static int[] denom = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
    public static int n = denom.length - 1;

    // Note:
    // This approach will not work for all denominations. For example, it doesn’t work for
    // denominations {9, 6, 5, 1} and amount = 11. This would print 9, 1 and 1 instead of 5 and 6.
    // For general input, below dynamic programming approach can be used:
    // https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
    public static void findMin(int amount) {
        List<Integer> coins = new ArrayList<>();

        // Note:
        // Make sure denomination is sorted in ascending order
        // before proceeding with the logic.
        for (int i = n; i >= 0; i--) {
            while (amount >= denom[i]) {
                amount -= denom[i];
                coins.add(denom[i]);
            }
        }

        for (int coin : coins) {
            System.out.print(coin + " ");
        }
    }

    public static void main(String[] args) {
        int n = 93;
        findMin(n);     // 50 20 20 2 1
    }
}
