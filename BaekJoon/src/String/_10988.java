package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10988 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if(palindrome(br.readLine())){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    private static boolean palindrome(String readLine) {

        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        for(int i=readLine.length()-1; i>=0; i--){
            sb.append(readLine.charAt(i));
        }

        if(readLine.equals(sb.toString())) flag = true;

        return flag;
    }
}
