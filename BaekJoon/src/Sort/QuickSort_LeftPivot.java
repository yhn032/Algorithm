package Sort;

public class QuickSort_LeftPivot {
	
	/*
		QuiclSort
		하나의 리스트를 피벗을 기준으로 두 개의 부분 리스트로 나누어 하나는 피벗보다 작은 값들의 부분 리스트, 
		다른 하나는 피벗보다 큰 값들의 부분 리스트로 정렬한 다음, 각 부분 리스트에 대해 다시 위 처럼 피봇을 사용하여 
		재귀적으로 수행하여 정렬하는 방법이다. 
		ㄴ> 기본적으로 '분할정복' 알고리즘을 기반으로 정렬되는 방식이다. 
		다만, 병합 정렬과 다른 점은 병합 정렬의 경우 하나의 리스트를 """절반"""으로 나누어 분할 정복을 하고, 퀵 정렬의 경우 피봇값에 따라서
		피벗보다 작은 값을 갖는 부분 리스트와 피봇보다 큰 값을 갖는 부분리스트의 크기가 다를 수 있기 때문에 하나의 리스트에 대해서 
		"""비균등하게 나뉜다"""는 점이 있다.
		
		보통 병합 정렬과 퀵 정렬은 많이 비교된다. 다만 일반적으로 병합 정렬보다 퀵정렬이 빠르다.
		
		비교   정렬 : 데이터를 "비교"하면서 찾는다.
	 	제자리 정렬 : 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로 하지 않는다.(swap하는 과정에서 사용하는 임시변수는 충분히 무시할 만큼 작다.)
	 	불안정 정렬 : 하나의 피봇을 두고 두 개의 부분리스트를 만들 때 서로 떨어진 원소끼리 교환이 일어나기 때문에 불완전 정렬이다.
		 
		 
		 
		 
		
		정렬방법 
		1. 피봇을 하나 선택한다. 
		2. 피봇을 기준으로 양쪽에서 피봇보다 큰값, 혹은 작은 값을 찾는다. 현재 리스트의 양 끝에서 시작하여 왼쪽에서부터는 피봇보다 큰 값을 찾고, 오른쪽에서부터는 피봇보다 작은 값을 찾는다. 
		3. 양방향에서 찾은 두 원소를 교환한다. 그래야만 피봇보다 작은 값은 왼쪽에, 큰 값은 오른쪽에 배치하면서 오름차순을 구성할 수 있다. -> 내림차순은 반대로 한다. 
		4. 왼쪽에서 탐색하는 위치와 오른쪽에서 탐색하는 위치가 엇갈리지 않을때까지 2번으로 돌아가 위의 과정을 반복한다. 
		5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가 해당 부분리스트의 길이가 1이 아닐때까지 1번의 과정을 반복한다.(=분할)
		6. 인접한 부분리스트끼리 합친다.(=정복)
		
		
		피벗의 선택 방법 
		1. 현재 부분리스트의 가장 왼쪽 원소
		2. 현재 부분 리스트의 중간 원소
		3. 현재 부분 리스트의 마지막 원소
		
		파티셔닝 -> 피벗을 하나 설정하고 피봇보다 작은 값들을 왼쪽에, 큰 값들은 오른쪽에 치중하도록 하는 것
		이렇게 파티셔닝을 했다면 파티셔닝을 통해 배치 된 피벗의 위치를 기준으로 좌우 부분리스트로 나누어 각각의 리스트에 대해 재귀호출을 해주면 됩니다.
		
	*/
	
	
	//1. 왼쪽 피벗 선택방식
	
	public static void l_pivot_sort(int []a) {
		l_pivot_sort(a, 0, a.length-1);
	}
	
	
	
	/*
		@param a		정렬할 배열
		@param lo		현재 부분배열의 왼쪽
		@param hi		현재 부분배열의 오른쪽	
	*/
	private static void l_pivot_sort(int[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		
		
		/* 
			lo(가장 왼쪽 인덱스)가 hi(가장 오른쪽 인덱스)보다 크거나 같다면(엇갈린 기점.) 정렬할 원소가 1개 이하이므로 정렬하지 않고 리턴한다. 
		*/
		
		if(lo >= hi) {
			return;
		}
		
		int pivot = partition(a, lo, hi);
		l_pivot_sort(a, lo, pivot-1);
		l_pivot_sort(a, pivot+1, hi);
	}


	
	
	
	/*
	 	@param a 		정렬할 배열
	 	@param left 	현재 배열의 가장 왼쪽부분
	 	@param right 	현재 배열의 가장 왼쪽부분
	 	@return 		최종적으로 위치한 피봇의 위치(lo)를 반환합니다.
	*/
	private static int partition(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		
		int lo = left;
		int hi = right;
		int pivot = a[left]; //부분리스트의 가장 왼쪽 요소를 피봇으로 설정합니다.
		
		//lo가 hi보다 작을 때까지만 반복합니다. 그 외의 경우는 인덱스가 엇갈렸기 때문입니다. 
		while(lo < hi) {
			
			/*
				hi가 lo보다 크면서, a[hi]가 pivot보다 작거나 같은 원소를 찾을 때까지 hi를 감소시킵니다. 
				피봇보다 작은 값을 찾아서 스왑을 해야지만 피봇의 왼쪽에 작은 값을 위치시킬 수 있다.
			*/
			while(a[hi] > pivot && lo < hi) {
				hi--;
			}
			
			
			/*
				hi가 lo보다 크면서, a[lo]가 pivot보다 큰 원소를 찾을 때까지 lo를 증가시킵니다. 
				피봇보다 큰 값을 찾아서 스왑을 해야지만 피봇의 오른쪽에 큰 값을 위치시킬 수 있다.
			 */
			while(a[lo] <= pivot && lo < hi) {
				lo++;
			}
			
			//교환될 두 요소를 찾았으면 두 요소를 바꾼다. 
			swap(a, lo, hi);
		}//end-while
		
		//마지막으로 맨 처음 pivot으로 설정했던 위치 a[left]의 원소와 lo가 가리키는 원소를 바꾸어서 
		//pivot을 가운데에 위치시킨다.
		swap(a, left, lo);
		
		//두 요소가 교환되었다면 피봇이었던 요소는 lo에 위치하므로 lo를 반환한다.
		return lo;
	}



	private static void swap(int[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		int temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}
	
	
	public static void main(String[] args) {
		int []arr = {1, 5, 3, 8, 9, 2, 4, 7, 5};
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		l_pivot_sort(arr);
		
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}

