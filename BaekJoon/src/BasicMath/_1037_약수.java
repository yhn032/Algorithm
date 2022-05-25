package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1037_擒熱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int  n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		int dap = 0;
		if(n%2==0) {//礎熱 檣 唳辦
			dap = arr[0] * arr[n-1];
		}else {//�汝鶺� 唳辦
			int mid = n/2;
			dap = (int)Math.pow(arr[mid], 2);
		}
		
		System.out.println(dap);
	}

}

