package Sort;



public class InsertionSort {

	
	/*
	 	InsertionSort[삽입정렬]
	 	현재 비교하고자 하는 target과 그 이전의 원소들과 비교하며 자리를 swqp하는 정렬 법
	 	비교   정렬 : 데이터를 "비교"하면서 찾는다.
	 	제자리 정렬 : 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로 하지 않는다.(swap하는 과정에서 사용하는 임시변수는 충분히 무시할 만큼 작다.)
	 	안정   정렬 : 앞에서부터 차례대로 비교한다.
	 	
	 	앞에서부터 해당 원소가 위치할 곳을 탐색하고 해당 위치에 삽입하는 것이다. 
	 	오름차순 정렬이라고 가정
	 	1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다. (첫 번째 타겟은 두 번째 원소부터 시작한다.)
	 	2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환한다. 
	 	3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다. 
	 	4. 첫번째 원소(idx 0)는 타겟이 되어도 비교할 원소가 없기 때문에 
	 	타겟이 될 필요가 없기 때문에, 두 번째 원소부터 즉, target은 배열의 인덱스가 1인 것부터 시작한다.
	 	
	 	
	 	[장점]
	 	추가적인 메모리 소비가 작다. 
	 	거의 정렬된 경우 매우 효율적이다. 즉, 최선의 경우 O(N)의 시간 복잡도를 갖는다. 
	 	안정정렬이 가능하다. 
	 	
	 	[단점]
	 	역순에 가까울 수록 매우 비효율적이다. 즉, 최악의 경우 O(N^2)의 시간 복잡도를 갖는다. 
	 	데이터의 상태에 따라서 성능 편차가 매우 크다.
	 */
	
	public static void insertion_sort(int [] a) {
		insertion_sort(a, a.length);
	}
	
	private static void insertion_sort(int[] a, int size) {
		for(int i=1; i<size; i++) {
			int target = a[i]; //타겟의 넘버 , //타겟의 인덱스는 1부터 시작. 타겟 인덱스 = round 횟수
			
			//타겟 바로 이전 원소의 시작 index
			int first_previous_target = i - 1;
			
			//타겟이 이전 원소보다 크기 전까지 반복, 타겟 넘버보다 이전 원소가 더 크다면, 스왑해준다.
			while(first_previous_target >= 0 && target < a[first_previous_target]) {
				
				//타겟 원소보다 이전 원소가 크다면 이전원소를 타겟원소의 위치로 이동시킨다.
				//타겟 원소의 넘버는 임시변수 target에 있기 때문에 덮어쓰기는 걱정 노노
				a[first_previous_target+1] = a[first_previous_target];
				first_previous_target--;
				
			}
			
			
			//위의 반복문을 탈출하면 타겟 원소 이전의 값이 타겟 보다는 작다는 의미로 
			//타겟 원소는 first_previous_target번째 원소 뒤에 와야 한다.
			
			//타겟 원소보다 이전의 원소들이 모두 작고, 정렬이 되어 있다면 위의  반복문을 바로 탈출하고, 
			//first_previous_target+1 원래의 위치에 target이 위치한다. 
			
			//타겟 원소보다 이전의 원소들이 모두 크다면, 이전의 원소들이 +1로 오른쪽으로 한 칸씩 이동하다가 
			//반복의 마지막 명령인 first_previous_target--를 수행하면 first_previous_target값이 -1이 되므로 
			//target은 그 값에 +1을 한 0번지에 위치한다. 
			
			
			//즉, 위의 반복문을 탈출하는 경우는 앞의 원소가 타겟보다 작다는 의미이므로 더이상의 정렬을 수행하는것이 무의미 하다는 뜻이다. 
			//그러므로 타겟은 first_previous_target번째 원소 뒤에 위치한다.
			
			a[first_previous_target+1] = target;
			
			
		}
	}
}

