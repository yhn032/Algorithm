package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class Sort_bakjoon_1026_보물 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        //A배열 초기화
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        //B는 list에 초기화
        for(int i=0; i<N; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        //A는 오름차순 정렬 작은것 -> 큰 것
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        int S = 0;
        for(int i=0; i<N; i++){
            S += A.get(i) * B.get(i);
        }

        System.out.println(S);
    }
}