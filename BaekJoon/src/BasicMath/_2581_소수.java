package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _2581_¼Ò¼ö {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = Integer.parseInt(br.readLine());
		int end   = Integer.parseInt(br.readLine());
		
		
		int arr[] = new int[end+1];
		for(int i=1; i<=end; i++) {
			arr[i] = i;
		}
		
		
		for(int i=2; i<Math.sqrt(arr.length); i++) {
			if(arr[i]==0) continue;
			
			for(int k=i+i; k < arr.length; k+=i) {
				arr[k]=0;
			}
		}
		
		
		List<Integer> list = new ArrayList<>(arr.length);
		
		int sum=0;
		for(int i : arr) {
			if(i==0 || i == 1) continue;
			
			if(i>=start && i<=end) {
				sum += i;
				list.add(i);
			}
		}
		
		
		if(list.size() == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(list.get(0));
		}
		
	}

}
