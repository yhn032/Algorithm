package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654_�����ڸ��� {
	static int k, n;
	static long ransun[];
	static int count;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		//Ž�� ����� �ڸ� ������ ����
		//�̿����� �������� ������ ������ m�ΰ�� �� �ִ밪�� ���ϱ� -> ������ ã�� �޼ҵ� 
		
		ransun = new long[k];
		
		for(int i=0; i<k; i++) {
			ransun[i] = Integer.parseInt(br.readLine());
		}
		
		//������ ���� k�� �ִ��� 10000�̹Ƿ� ���Ŀ����� �ð����⵵�� ���x
		Arrays.sort(ransun);
		
		//Ž�� ����� �ڸ� ������ ����. �� ����� ������ ���̿� ���� �������� ������ ���� 
		long min = 1;
		long max = ransun[k-1]+1;
		
		while(min < max) {
			long mid = min + (max-min)/2;
			
			if(cut(mid) < n) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		
		System.out.println(min-1);
	}
	private static int cut(long mid) {
		// TODO Auto-generated method stub
		int count=0; 
		
		for(int i=0; i<k; i++) {
			count += ransun[i]/mid;
		}
		
		
		return count;
	}

}
