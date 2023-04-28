package MapSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _7785 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> sawon = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            sawon.put(temp[0], temp[1]);
        }

        List<String> enter = sawon.entrySet().stream()
                .filter(e -> e.getValue().equals("enter"))
                .map(Map.Entry::getKey)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        for(String s : enter){
            System.out.println(s);
        }
    }
}

