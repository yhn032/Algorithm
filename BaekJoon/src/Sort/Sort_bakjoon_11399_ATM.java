package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort_bakjoon_11399_ATM {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // 문제에서 푸는 방법을 알려줬다. 처리시간이 짧은 사람부터 오름차순으로 정렬하라..
        // 대기시간을 최소화 해야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time_sum_min=0;
        int N = Integer.parseInt(br.readLine());

        int []wait = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++) {
            wait[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(wait);


        for(int i=0; i<N;i++) {
            time_sum_min += wait[i]*(N-i);
        }
        System.out.println(time_sum_min);
    }

}
