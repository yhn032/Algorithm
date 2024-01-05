package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class college implements Comparable<college>{
    String name;
    int spend;

    public college(String name, int spend) {
        this.name = name;
        this.spend = spend;
    }

    @Override
    public int compareTo(college o) {
        return o.spend - this.spend;
    }
}
public class Sort_bakjoon_11557_¾çÁ¶Àå {
    public static void main(String[] args) throws Exception{
        /* 11557 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            ArrayList<college> collegeList = new ArrayList<>();
            for(int i=0; i<N;i++){
                st = new StringTokenizer(br.readLine(), " ");
                collegeList.add(new college(st.nextToken(), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(collegeList);
            sb.append(collegeList.get(0).name);
            if(T > 0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
