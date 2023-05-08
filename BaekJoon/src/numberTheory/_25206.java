package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25206 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double sum = 0;
        int count = 0;

        for(int i=0; i<20; i++){
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            double gradePoints;
            if(grade.equals("P")) continue;

            switch (grade){
                case "A+":
                    gradePoints = 4.5; break;
                case "A0":
                    gradePoints = 4.0; break;
                case "B+":
                    gradePoints = 3.5; break;
                case "B0":
                    gradePoints = 3.0; break;
                case "C+":
                    gradePoints = 2.5; break;
                case "C0":
                    gradePoints = 2.0; break;
                case "D+":
                    gradePoints = 1.5; break;
                case "D0":
                    gradePoints = 1.0; break;
                case "F":
                    gradePoints = 0.0; break;
                default:
                    gradePoints = 0.0; break;
            }

            count++;
            sum += gradePoints * score;
        }

        System.out.println(sum / count);
    }
}
