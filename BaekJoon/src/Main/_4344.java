package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _4344  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		/*
		 * double a = 2.0; double b = 5.0; double temp = a/b*100;
		 * System.out.println(temp);
		 */
		
		//test case
		int C = Integer.parseInt(br.readLine());
		
		List<Integer []> testCase = new ArrayList<>(C);
		int count;//점수의 총합
		int count_st;//평균이상의 학생수
		double avg[] = new double[C];
		double percent[] = new double[C];
		
		//arraylist에 배열 초기화
		for(int k=0; k<C;k++) {
			count = 0; count_st=0;
			st = new StringTokenizer(br.readLine());
			//학생수를 크기로 하는 1차원 배열 생성
			int student = Integer.parseInt(st.nextToken());
			Integer []test = new Integer[student];
			
			//값을 초기화 하고, 총합을 구한다.
			for(int i=0; i<test.length;i++){
				test[i] = Integer.parseInt(st.nextToken());
				count += test[i];
			}
			//평균배열에 평균값 넣기
			avg[k] = (double) (count / student);
			
			//System.out.println(avg[k]);
			//내림차순으로 정렬한 상태로 ArrayList에 add
			Arrays.sort(test, Collections.reverseOrder());
			
			testCase.add(test);
			
			for(int j=0 ; j<student;j++) {
				if(test[j] > avg[k]) {
					count_st++;
				}
			}
			//System.out.println(count_st);
			percent[k] = (count_st*1.0) / student*100;
		
		}
		
		for(double dd : percent) {
			System.out.printf("%.3f%%\n", dd);
		}
		
	}

}
