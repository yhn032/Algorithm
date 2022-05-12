package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2470_�������͵ο�� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//����� ����
		int N = Integer.parseInt(br.readLine());
		int list[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		int result[] = two_pointer(list, N);
		
		for(int i : result) {
			System.out.print(i + " ");
		}
		br.close();
	}

	private static int[] two_pointer(int[] list, int n) {
		// TODO Auto-generated method stub
		int result[] = new int[2];
		int start = 0; 
		int end = n-1;
		
		//�ּڰ��� �񱳱������� ����� �ִ�
		int maxdiff = 2000000000;
		
		while(start < end) {
			int sum = list[start] + list[end];
			
			if(Math.abs(sum) < maxdiff) {
				result[0] = list[start];
				result[1] = list[end];
				maxdiff = Math.abs(sum);
			}
			
			if(sum > 0) { //end���� ������ �� ũ��.
				end--;
			} else { //������ ũ�Ⱑ ���ų�, start���� ���밪�� �� ũ��.
				start++;
			}
		}
		
		return result;
	}

}
