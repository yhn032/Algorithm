package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _9020_골드바흐 {

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
			
			//값 초기화
			for(int i=2; i<=n ;i++) {
				arr[i] = i;
			}
			
			//소수만 남기기
			for(int i=2; i<=Math.sqrt(n); i++) {
				if(arr[i] == 0) continue;
				
				for(int k=i+i; k<arr.length; k+=i) {
					arr[k]=0;
				}
			}
			
			//리스트에 소수만 저장하기 
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == 0 ) continue;
				list2.add(arr[i]);
			}
			
			//System.out.println(list.size());
			//합 구하기, 투포인터 알고리즘 사용
			int start = 0;
			int end = list2.size()-1;
			while(start <= end) {
				//처음으로 발견한 값이 차이가 가장 작은 골드바흐의 파티션이다.
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
		
		
		//리스트를 두개의 값을 받도록 클래스를 정의하고, 클래스의 변수를 저장하자. 오름차순 정렬되 있으므로 사이즈 번째에 있는 것을 출력한다.
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
