package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11382_ {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sum();

        System.out.println(answer);
    }
}
