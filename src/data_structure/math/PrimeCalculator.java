package data_structure.math;

import java.util.*;

public class PrimeCalculator {
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public List<Integer> EratosthenesPrimeSieve(int n) {
        boolean[] vis = new boolean[n + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                res.add(i);
                vis[i] = true;
                for (int j = i * i; j <= n; j += i) {
                    vis[j] = true;
                }
            }
        }
        return res;
    }
    public List<Integer> EulerPrimeSieve(int n) {
        int[] f = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (f[i] == 0) {
                f[i] = i;
                res.add(i);
            }
            for (int j = 0; j < res.size(); j++) {
                int m = res.get(j);
                if (m > f[i] || m > n / i) break;
                f[m * i] = m;
            }
        }
        return res;
    }
}
