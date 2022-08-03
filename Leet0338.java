import java.util.Arrays;

public class Leet0338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(32)));
    }
    public static int[] countBits(int n) {
        int[] ret = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ret[i] = count(i);
        }
        return ret;
    }

    private static int count(int i) {
        int count = 0;
        while (i != 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }
}
