package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
    String name;
    int kor;
    int mat;
    int eng;

    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    @Override
    public int compareTo(Student o) {
        if(this.kor == o.kor) {
            if(this.eng == o.eng){
                if(this.mat == o.mat){
                    return this.name.compareTo(o.name);
                }else return o.mat - this.mat;
            }
            else return this.eng-o.eng;
        }else {
            return o.kor - this.kor;
        }
    }
}

public class Sort_bakjoon_10825_±¹¿µ¼ö {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> studentList = new ArrayList<>(N);

        while(N --> 0){
            st = new StringTokenizer(br.readLine());
            studentList.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(studentList);

        studentList.forEach(s -> System.out.println(s.name));
    }
}
