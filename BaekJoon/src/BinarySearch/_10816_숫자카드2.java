package BinarySearch;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

�������
�Ʊ� Ǯ���� �̺�Ž�� ������ ���������, ���� ���ڰ� ���´ٸ� ���� ��ġ�� append�ؾ��Ѵ�.
+) ���� ����Ž���� �ߺ��������� ������ ������ �����Ѵ�.

1. �ߺ������� count�ؾ��ϴϱ� target�� ��ġ�ϴ��� ��� Ž���ϴ� ���� ã��
2. �ð��ʰ�

*/

public class _10816_����ī��2 {

	
	//���� Ž��
	public static int leftBound(int target) {
		
		int start = 0;
		int end   = n;
		
		while(start<end) {
			
			int mid = (start+end)/2;
			
			if(arr[mid]>=target) {
				end = mid;
			}else {
				start = mid+1;
			}
		}//while end
	
		return start;
	}
	
	//������ �̺� Ž��
	public static int rightBound(int target) {
		
		int start = 0;
		int end   = n;
		
		while(start<end) {
			
			int mid = (start+end)/2;
			
			if(arr[mid] > target) {
				end = mid;
			}else if(arr[mid]<=target) {
				start = mid+1;
			}
			
		}//while end
		return end;
	}
	//	0	1 2 3 4 5 6  7  8  9
	//-10 -10 2 3 3 6 7 10 10 10
	
	public static int count(int target) {
	
		int start = leftBound(target);
		int end   = rightBound(target);
		
		return end-start;
	}
	
	
	//static ���� ���� -> Ŭ���� �� ��𼭵� ���� ���� �ٷ� ��� ���� -> 1ȸ�� ����
	static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder   sb = new StringBuilder();
	static int n;
	static int t;
	static int [] arr;
	
	public static void main(String[] args) throws IOException{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		
		t  = Integer.parseInt(st.nextToken());
		
		
		//-------------[�����Է¿Ϸ�]--------------
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<t; i++) { //for�� �ȿ��� binary�޼ҵ� ȣ���ؾ� target�� t��ŭ ����
			int target = Integer.parseInt(st.nextToken());
			sb.append(count(target)).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		br.close();
		out.close();
	}
}