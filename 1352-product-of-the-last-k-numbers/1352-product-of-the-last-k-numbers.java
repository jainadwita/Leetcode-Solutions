import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1); // sentinel so the first division works
    }

    public void add(int num) {
        if (num == 0) {
            // any product spanning this zero is 0, so reset
            prefix = new ArrayList<>();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = prefix.size();
        // fewer than k nonzero numbers since the last zero -> a zero is in range
        if (k >= n) return 0;
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}