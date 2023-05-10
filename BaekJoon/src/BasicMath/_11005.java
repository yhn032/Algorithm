package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11005 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while(true){
            int mok = N / B;
            int mod = N % B;

            if(mok < B) {

                if(mod >= 10) {
                    sb.append((char)(mod+55));
                }else {
                    sb.append(mod);
                }
                if(mok != 0){

                    if(mok >= 10) {
                        sb.append((char)(mok+55));
                    }else {
                        sb.append(mok);
                    }
                }
                break;
            }else {

                if(mod >= 10) {
                    sb.append((char)(mod+55));
                }else {
                    sb.append(mod);
                }
            }

            N = mok;
        }
        for(int i=sb.toString().length()-1; i>=0; i--){
            sb2.append(sb.toString().charAt(i));
        }
        System.out.println(sb2.toString());
    }
}
