package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class _27433 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Long N = Long.parseLong(br.readLine());

        Long answer = factorial(N);

        System.out.println(answer);
    }

    private static Long factorial(long n) {
        if(n == 1) return 1L;
        else return factorial(n-1) * n;
    }

}
