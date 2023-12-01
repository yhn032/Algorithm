package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class Sort_bakjoon_1026_���� {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        //A�迭 �ʱ�ȭ
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        //B�� list�� �ʱ�ȭ
        for(int i=0; i<N; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        //A�� �������� ���� ������ -> ū ��
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        int S = 0;
        for(int i=0; i<N; i++){
            S += A.get(i) * B.get(i);
        }

        System.out.println(S);
    }
}