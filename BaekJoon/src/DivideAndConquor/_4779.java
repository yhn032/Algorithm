package DivideAndConquor;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class _4779 {

    private static String ll = "";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while(true){
            String s = br.readLine();
            if(s == null) break;

            int N = Integer.parseInt(s);
            String line [] = new String[(int)Math.pow(3, N)];
            Arrays.fill(line, "-");


            kantor(line, 0, N-1);
            ll = Arrays.stream(line).collect(Collectors.joining());

            sb.append(ll).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void kantor(String[] line, int start, int end) {

        if(start == end ) return;

        int size = (end-start) + 1;

        kantor(line, 0, start+size-1);
        for(int k = start+size; k<end-size; k++ ){
            line[k] = " ";
        }
        kantor(line, end-size+1, end);
    }


}
