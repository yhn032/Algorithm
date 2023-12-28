package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Grade implements Comparable<Grade>{
    int exam;
    int interview;

    public Grade(int exam, int interview) {
        this.exam = exam;
        this.interview = interview;
    }

    @Override
    public int compareTo(Grade o) {//기본이 오름차순
        //양수 (자리바꿈), 0;음수(그대로)
        return this.exam - o.exam;
    }
}

public class Sort_bakjoon_1946_신입사원 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        //Test Case T개
        while(T --> 0) {
            //시험 지원자수 N명
            int N = Integer.parseInt(br.readLine());

            ArrayList<Grade> gradeList = new ArrayList<>(N);


            for(int i=0; i<N; i++){
                String[] test = br.readLine().split(" ");
                gradeList.add(new Grade(Integer.parseInt(test[0]), Integer.parseInt(test[1])));
            }


            Collections.sort(gradeList);

            int answer = 1;
            int min = gradeList.get(0).interview;

            for(int i=1; i<N; i++){
                if(gradeList.get(i).interview < min) {
                    answer++;
                    min = gradeList.get(i).interview;
                }
            }

            sb.append(answer);
            if(T > 0) sb.append("\n");
        }//end while

        System.out.println(sb.toString());
    }
}
