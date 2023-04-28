package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24060 {
	
	static int n, k;
	static int afterSort[];
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int beforeSort[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			beforeSort[i] = Integer.parseInt(st.nextToken());
		}
		
		
//		for(int i : beforeSort) {
//			System.out.print(i + " ");
//		}
		
		merge_sort(beforeSort);
//		System.out.println();
//		for(int i : beforeSort) {
//			System.out.print(i + " ");
//		}
		
		if(cnt < k) System.out.println(-1);
	}

	private static void merge_sort(int[] beforeSort) {
		// TODO Auto-generated method stub
		afterSort = new int[beforeSort.length];
		merge(beforeSort, 0, beforeSort.length-1);
		afterSort = null;
	}

	private static void merge(int[] beforeSort, int left, int right) {
		// TODO Auto-generated method stub
		if(left == right) return;
		
		int mid = (left+right)/2;
		
		merge(beforeSort, left, mid);
		merge(beforeSort, mid+1, right);
		
		merge(beforeSort, left, mid, right);
	}

	private static void merge(int[] beforeSort, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int l = left; 
		int r = mid + 1;
		int idx = left;
		
		
		while (l <= mid && r <= right) {
			if(beforeSort[l] <= beforeSort[r]) {
				afterSort[idx] = beforeSort[l];
				idx++;
				l++;
			} else {
				afterSort[idx] = beforeSort[r];
				idx++;
				r++;
			}
		}
		
		if(l > mid) {
			while(r <= right) {
				afterSort[idx] = beforeSort[r];
				idx++;
				r++;
			}
		}else {
			while(l <= mid) {
				afterSort[idx] = beforeSort[l];
				idx++;
				l++;
			}
			
		}
		
		for(int i=left; i<=right; i++) {
			beforeSort[i] = afterSort[i];
			cnt++;
			if(cnt == k)System.out.println(afterSort[i]);
		}
	}
}
