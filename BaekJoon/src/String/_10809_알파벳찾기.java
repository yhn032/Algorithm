package String;

import java.util.Arrays;
import java.util.Scanner;

public class _10809_���ĺ�ã�� {
	public static void main(String[] args) {
		//a~z = 26
		//97~122
		int arr[] =new int[26];
		Arrays.fill(arr, -1);
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for(int i=0; i<str.length() ;i++) {
			int ch = str.charAt(i)-97; //a=0, b= 1....z=25
			
			if(arr[ch] == -1) {//ó�� �߰��ߴٸ� ���� �ε��������� ����
				arr[ch] = i;
			}
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		sc.close();
	}
}
