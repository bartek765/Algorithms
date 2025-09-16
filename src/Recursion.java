import java.util.Random;
import java.util.Scanner;

public class Recursion {
    static final Random RAND = new Random();

    public static void main(String[] args) {
        //exercise 1
        int[] arr = randomArray(50);
        System.out.println("for:");
        printFor(arr);
        System.out.println("rekurencyjnie: ");
        printRec(arr);
        //exercise 2
        int[] arr10 = randomArray(10);
        System.out.print("tablica: ");
        printFor(arr10);
        System.out.println("suma (for): " + sumFor(arr10));
        System.out.println("suma (rekurencyjnie): " + sumRec(arr10));
        //exercise 3
        int[] sorted100 = ascendingArray(100, 0, 2);
        int key = 42;
        System.out.println("szukany klucz: " + key);
        System.out.println("index (for): " + binarySearchFor(sorted100, key));
        System.out.println("index (rekurencyjnie): " + binarySearchRec(sorted100, key));
        //exercise 4
        int n = 10;
        System.out.println("silnia (for): " + factorialFor(n));
        System.out.println("silnia (rekurencyjnie): " + factorialRec(n));
        //exercise 5
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("binarnie (for): " + toBinaryFor(x));
        System.out.println("binarnie (rekurencyjnie): " + toBinaryRec(x));
    }


    static int[] randomArray(int len) {
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) a[i] = RAND.nextInt(100);
        return a;
    }

    static int[] ascendingArray(int len, int start, int step) {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) a[i] = start + i * step;
        return a;
    }


    static void printFor(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) System.out.print(" ");
        }
        System.out.println();
    }

    static void printRec(int[] a) {
        printRec(a, 0);
    }

    private static void printRec(int[] a, int i) {
        if (i == a.length) {
            return;
        }
        System.out.print(a[i]);
        if (i < a.length - 1) System.out.print(" ");
        printRec(a, i + 1);
    }

    static int sumFor(int[] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) s += a[i];
        return s;
    }

    static int sumRec(int[] a) {
        return sumRec(a, 0);
    }

    private static int sumRec(int[] a, int i) {
        if (i == a.length) return 0;
        return a[i] + sumRec(a, i + 1);
    }

    static int binarySearchFor(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            if (a[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    static int binarySearchRec(int[] a, int key) {
        return binarySearchRec(a, key, 0, a.length - 1);
    }

    private static int binarySearchRec(int[] a, int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == key) return mid;
        if (a[mid] < key) return binarySearchRec(a, key, mid + 1, hi);
        return binarySearchRec(a, key, lo, mid - 1);
    }

    static long factorialFor(int n) {
        if (n < 0) throw new IllegalArgumentException("n musi być >= 0");
        long res = 1L;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    static long factorialRec(int n) {
        if (n < 0) throw new IllegalArgumentException("n musi być >= 0");
        if (n <= 1) return 1L;
        return n * factorialRec(n - 1);
    }

    static String toBinaryFor(int n) {
        if (n == 0) return "0";
        boolean neg = n < 0;
        long v = Math.abs((long) n);
        StringBuilder sb = new StringBuilder();
        while (v > 0) {
            sb.append(v & 1L);
            v >>= 1;
        }
        if (neg) sb.append('-');
        return sb.reverse().toString();
    }

    static String toBinaryRec(int n) {
        if (n == 0) return "0";
        if (n < 0) return "-" + toBinaryRecPos(-(long) n);
        return toBinaryRecPos((long) n);
    }

    private static String toBinaryRecPos(long v) {
        StringBuilder sb = new StringBuilder();
        toBinaryRecHelper(v, sb);
        return sb.toString();
    }

    private static void toBinaryRecHelper(long v, StringBuilder sb) {
        if (v == 0) return;
        toBinaryRecHelper(v / 2, sb);
        sb.append(v % 2);
    }

    static void printBinaryByDivision(int n) {
        if (n == 0) {
            System.out.println("0");
            return;
        }
        if (n < 0) {
            System.out.print("-");
            n = -n;
        }

        int[] bits = new int[32];
        int len = 0;
        while (n > 0) {
            bits[len++] = n % 2;
            n /= 2;
        }
        for (int i = len - 1; i >= 0; i--) System.out.print(bits[i]);
        System.out.println();
    }

    static void printBinaryByDivisionRec(int n) {
        if (n == 0) {
            System.out.println("0");
            return;
        }
        if (n < 0) {
            System.out.print("-");
            n = -n;
        }
        printBits(n);
        System.out.println();
    }

    private static void printBits(int v) {
        if (v >= 2) printBits(v / 2);
        System.out.print(v % 2);
    }
}