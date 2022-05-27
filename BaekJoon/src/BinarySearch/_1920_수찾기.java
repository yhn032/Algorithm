package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920_��ã�� {
	static int [] narr;
	static int [] marr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//Ž�� ����
		int n = Integer.parseInt(br.readLine());
		narr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			narr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(narr);
		
		//Ž�� ���
		int m = Integer.parseInt(br.readLine());
		marr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			marr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<m; i++) {
			int start = 0;
			int end   = n-1;
			int target = marr[i];
			int res = binarySearch(target, start, end);
			if(res != -1) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
			
			
		}
		
		System.out.println(sb);
	}

	private static int binarySearch(int target, int start, int end) {
		// TODO Auto-generated method stub
		
		while(start <= end) {
			int mid = (start+end)/2;
			if(narr[mid] == target) {
				return mid;
			}else if(narr[mid] > target) {
				end = mid - 1;
			}else {
				start = mid+1;
			}
		}
		return -1;
	}

}

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// �迭�� �ݵ�� ���ĵǾ��־���Ѵ�.
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			
			// ã���� �ϴ� ���� ���� ��� 1, ���� ��� 0�� ����ؾ��Ѵ�.
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	

	public static int binarySearch(int key) {
 
		int lo = 0;					// Ž�� ������ ���� �� �ε���
		int hi = arr.length - 1;	// Ž�� ������ ������ �� �ε���
 
		// lo�� hi���� Ŀ���� ������ �ݺ��Ѵ�.
		while(lo <= hi) {
 
			int mid = (lo + hi) / 2;	// �߰���ġ�� ���Ѵ�.
 
			// key���� �߰� ��ġ�� ������ ���� ���
			if(key < arr[mid]) {
				hi = mid - 1;
			}
			// key���� �߰� ��ġ�� ������ Ŭ ���
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			// key���� �߰� ��ġ�� ���� ���� ���
			else {
				return mid;
			}
		}
 
		// ã���� �ϴ� ���� �������� ���� ���
		return -1;
 
	}
}
*/
