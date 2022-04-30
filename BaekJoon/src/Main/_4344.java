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
		int count;//������ ����
		int count_st;//����̻��� �л���
		double avg[] = new double[C];
		double percent[] = new double[C];
		
		//arraylist�� �迭 �ʱ�ȭ
		for(int k=0; k<C;k++) {
			count = 0; count_st=0;
			st = new StringTokenizer(br.readLine());
			//�л����� ũ��� �ϴ� 1���� �迭 ����
			int student = Integer.parseInt(st.nextToken());
			Integer []test = new Integer[student];
			
			//���� �ʱ�ȭ �ϰ�, ������ ���Ѵ�.
			for(int i=0; i<test.length;i++){
				test[i] = Integer.parseInt(st.nextToken());
				count += test[i];
			}
			//��չ迭�� ��հ� �ֱ�
			avg[k] = (double) (count / student);
			
			//System.out.println(avg[k]);
			//������������ ������ ���·� ArrayList�� add
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
