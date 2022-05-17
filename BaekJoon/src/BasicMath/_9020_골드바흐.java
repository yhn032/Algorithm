package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _9020_������ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		List<pointer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n+1];
			
			//�� �ʱ�ȭ
			for(int i=2; i<=n ;i++) {
				arr[i] = i;
			}
			
			//�Ҽ��� �����
			for(int i=2; i<=Math.sqrt(n); i++) {
				if(arr[i] == 0) continue;
				
				for(int k=i+i; k<arr.length; k+=i) {
					arr[k]=0;
				}
			}
			
			//����Ʈ�� �Ҽ��� �����ϱ� 
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == 0 ) continue;
				list2.add(arr[i]);
			}
			
			//System.out.println(list.size());
			//�� ���ϱ�, �������� �˰��� ���
			int start = 0;
			int end = list2.size()-1;
			while(start <= end) {
				//ó������ �߰��� ���� ���̰� ���� ���� �������� ��Ƽ���̴�.
				if(list2.get(start)+list2.get(end) == n) {
					list1.add(new pointer(list2.get(start), list2.get(end)));
					start++;
				}else if(list2.get(start)+list2.get(end)  < n) {
					start++;
				}else {
					end--;
				}
			}
			
			sb.append(list1.get(list1.size()-1).start + " " + list1.get(list1.size()-1).end).append('\n');
			
			
			list1.clear();
			list2.clear();
		}
		
		
		//����Ʈ�� �ΰ��� ���� �޵��� Ŭ������ �����ϰ�, Ŭ������ ������ ��������. �������� ���ĵ� �����Ƿ� ������ ��°�� �ִ� ���� ����Ѵ�.
		System.out.println(sb);
		
	}

}
class pointer {
	int start;
	int end;
	
	public pointer(int start, int end){
		this.start = start;
		this.end   = end;
	}
}
