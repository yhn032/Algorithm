package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1463_����1�θ���� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int x = Integer.parseInt(br.readLine());
		
		//arr[i]�� i�� 1�� ����µ� �ʿ��� �ּ� ���� Ƚ���� ������ �迭
		int arr[] = new int[x+1];
		
		arr[1]=0; //1�� 1�� ����µ� ������ ���ʿ�.
		
		//��ȭ���� ����� bottomup
		for(int i=2 ; i<=x;i++) {
			arr[i] = arr[i-1] + 1;
			if(i % 2 ==0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
			if(i % 3 ==0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
		}
		System.out.println(arr[x]);
	}

}

