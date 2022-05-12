package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1157_단어공부 {
	public static void main(String[] args) {
		//a~z = 26
		//97~122
		//A~Z = 26
		//65~90
		int arr[] =new int[26];
		//Arrays.fill(arr, -1);
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toLowerCase();
		
		for(int i=0; i<str.length() ;i++) {
			int ch = str.charAt(i)-97; //a=0, b= 1....z=25
			arr[ch]++;
		}
		
		int max =0; 
		for(int i=0; i<arr.length;i++) {
			max = max > arr[i] ? max : arr[i];
		}
		
		
		List<Integer> list = new ArrayList<Integer>();
		//최댓값의 인덱스 저장하기
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i] == max) {
				list.add(i);
			}
		}
		
		if(list.size()>=2) {
			System.out.println("?");
		}else {
			int ch = list.get(0)+65;
			System.out.println((char)ch);
		}
		sc.close();
	}
}
