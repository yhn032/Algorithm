package Sort;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1377_bubble {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//버블정렬을 하다가 swap이 일어나지 않은 round(i)구하기
		//버블 정렬은 최선의 경우가 일어날 수 있도록 구현해야 하며 
		//직접 모든 경우의 수를 탐색하기 위해 버블 정렬를 구현하면 
		// N의 최대값이 500,000이므로 최악의 경우 시간 초과 발생
		// 다른 알고리즘을 생각해 봐야 한다. 
		/*
			기본적으로 버블 정렬은 왼쪽(i)에서 오른쪽(n-1)으로 이동하면서 
			인접한 두 개의 요소를 비교한다. 
			이 때 만약에 swap이 발생하면, 큰 값은 오른쪽으로, 작은 값은 왼쪽으로 이동한다.(오름차순 기준)
			만약에 큰 값은 계속해서 배열의 끝으로 이동할 것이기 때문에 고려해줄 필요없고,
			스왑되었을 때, 작은 값은 왼쪽으로 최대 1만큼의 idx이동이 벌어진다.(내림차순인 경우는 반대)
			따라서, 작은 값이 왼쪽으로 1만큼 이동했다는 것은 해당 라운드에서 swap이 적어도 한 번은 일어났다는 의미이다. 
			기존 idx - 정렬 후 idx =>의 최댓값인 라운드에서 정렬이 완료되어 swap이 발생하지 않았다. 
			
			[정리]
			swap이 발생하면 최대값(가장 오른쪽으로 감)이 아닌 작은 값은 왼쪽으로 최대 1만큼 이동한다. 
			이 작은 값이 더 이상 이동하지 않을 때는 이미 정렬이 완료된 상태이다. 
			기존 인덱스 - 정렬후 인덱스 의 최댓값을 구한다.
			
			
			
			idx  0  1  2  3  4
			arr  10 1  5  2  3
			
	round 1 arr  1  5  2  3  10
	
	기존	idx  1  3  4  2   0
	정렬 	idx	 0  1  2  3   4
	round 2 arr  1  2  3  5  10	-> 정렬이 완료된 상태
	
	
	idx값의 차의 최대값 -> 1  2  2  1   
	
	
	round 3 arr  1  2  3  5  10 -> 3round에서 swap이 발생하지 않았다. 
	
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		bubble[] arr = new bubble[N];
		
		for(int i=0; i<N;i++) {
			arr[i] = new bubble(Integer.parseInt(br.readLine()), i);
			//System.out.println(arr[i]);
		}
		
		Arrays.sort(arr);
		
		/*
		 * for(int i=0; i<arr.length; i++) { System.out.print(arr[i].data + " "); }
		 */
		
		//기존 idx와 정렬 후 idx를 비교하자.
		int max = 0; 
		for(int i=0; i<N; i++) {
			//         기존        정렬후
			if(max < arr[i].index - i) {
				max  = arr[i].index - i;
			}
		}
		
		//위의 예시를 보면 round2에서 정렬이 끝났지만 swap발생합니다. 
		//round3에서는 정렬이 되어 있으므로 swap발생 x
		//우리가 찾는 값은 swap이발생하지 않는 round이므로 max + 1해야합니다
		System.out.println(max+1);
		
	}

}
class bubble implements Comparable<bubble>{
	int index;
	int data;
	
	public bubble() {
		
	}
	
	public bubble(int data, int index) {
		this.data = data;
		this.index = index;
	}

	@Override
	public int compareTo(bubble o) {
		// TODO Auto-generated method stub
		
		return this.data - o.data;
	}

	// 오름차순 정렬 - > 0, 음수 일때는 교환 x  | 양수일때는 교환
	
}

