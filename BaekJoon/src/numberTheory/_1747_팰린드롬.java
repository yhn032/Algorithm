package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1747_�Ӹ���� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1~1000000���̿� �����ϴ� �Ҽ��� ���� ������ 
		//�������͸� ����� �Ҽ��� �Ӹ���� ���� �ִ��� Ȯ������ 
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[10000001]; //N�� �ִ� 100000�� ��쿡 �������� �Ӹ���� 10000001
		for(int i=2; i<arr.length;i++) {
			arr[i] = i;
		}
		
		for(int i=2; i<Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) continue;
			for(int k=i+i;k<arr.length; k+=i) {
				arr[k] = 0;
			}
			
		}
		
		int k = N;
		while(true) {//���� ���� �߰��ϴ� �縰����� �ּ��̴�.
			if(arr[k] != 0) {//�Ҽ����,,,
				int result = arr[k];
				
				if(ispalindrom(result)) {
					System.out.println(result);
					break;
				}
			}
			k++;
		}
	}

	private static boolean ispalindrom(int result) {
		// TODO Auto-generated method stub
		char temp[] = String.valueOf(result).toCharArray();
		int start = 0; 
		int end = temp.length-1;
		
		while(start < end) {
			if(temp[start] != temp[end]) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}

}
