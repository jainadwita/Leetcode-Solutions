import java.util.*;

class Solution {
    private static final long M1 = 1_000_000_007L;
    private static final long M2 = 998_244_353L;

    private long[] h1, h2, p1, p2;
    private int n;

    public int smallestUniqueSubarray(int[] nums) {
        n = nums.length;
        Random rnd = new Random();
        long b1 = 100_003 + rnd.nextInt(500_000_000);
        long b2 = 100_003 + rnd.nextInt(500_000_000);

        h1 = new long[n + 1];
        h2 = new long[n + 1];
        p1 = new long[n + 1];
        p2 = new long[n + 1];
        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * b1 + nums[i]) % M1;
            h2[i + 1] = (h2[i] * b2 + nums[i]) % M2;
            p1[i + 1] = (p1[i] * b1) % M1;
            p2[i + 1] = (p2[i] * b2) % M2;
        }

        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (hasUnique(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // true if some window of length L appears exactly once
    private boolean hasUnique(int L) {
        int m = n - L + 1;
        long[] a = new long[m];

        for (int i = 0; i < m; i++) {
            long x1 = (h1[i + L] - h1[i] * p1[L] % M1 + M1) % M1;
            long x2 = (h2[i + L] - h2[i] * p2[L] % M2 + M2) % M2;
            a[i] = (x1 << 32) | x2;
        }

        Arrays.sort(a);

        for (int k = 0; k < m; k++) {
            boolean diffPrev = (k == 0) || a[k] != a[k - 1];
            boolean diffNext = (k == m - 1) || a[k] != a[k + 1];
            if (diffPrev && diffNext) return true;
        }
        return false;
    }
}