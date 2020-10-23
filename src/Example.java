public class Example {
//        The Fibonacci numbers are the numbers in the following integer sequence.
//        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }

        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        int[] f = new int[n+1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n ; i++) {
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    public static int fib3(int n) {
        if (n == 0) {
            return n;
        }

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        int result1 = fib1(9);
        System.out.println(result1);    // 34

        int result2 = fib2(9);
        System.out.println(result2);    // 34

        int result3 = fib3(9);
        System.out.println(result3);    // 34
    }
}
