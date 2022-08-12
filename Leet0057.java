// https://leetcode.com/problems/insert-interval/
import java.util.*;

public class Leet0057 {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] newInterval = {4,8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i<intervals.length;  i++)
        {
            if (newInterval == null || intervals[i][1] < newInterval[0])
            {
                res.add(intervals[i]);
            }
            else if (intervals[i][0] > newInterval[1] )
            {
                res.add(newInterval);
                res.add(intervals[i]);
                newInterval = null;
            }
            else
            {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
