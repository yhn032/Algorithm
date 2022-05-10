package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2309_난쟁이 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//나중에 값을 삭제할때 동적으로 메모리 최적화를 위해서 리스트 사용
		List<Integer> small_height = new ArrayList<>(9);
		int sum_height=0;
		
		//난쟁이 키 초기화 및 키의 합 초기화
		for(int i=0; i<9; i++) {
			small_height.add(Integer.parseInt(br.readLine()));
			sum_height += small_height.get(i);
		}
		
		//미리 오름차순 정렬하기 
		Collections.sort(small_height);
		
		
		//모니터링
		/*
		 * for(int i : small_height) { System.out.println(i); }
		 * System.out.println(sum_height);
		 */
		
		
		//리스트에서 삭제할 2개의 수
		Integer num1 = 0;
		Integer num2 = 0;
		OUT:
		for(int i =0; i < 9; i++) {
			for(int j=i+1; j<9;j++) {
				if(sum_height-small_height.get(i)-small_height.get(j) == 100) {
					num1 = small_height.get(i);
					num2 = small_height.get(j);
					break OUT;//찾으면 바로 탈출
				}
			}//end-for-j
		}//end-for-i
		
		//인덱스로 참조해서 삭제하지 말고 값을 바로 삭제
		small_height.remove(num1);
		small_height.remove(num2);
		
		//int로 선언한 경우
		//small_height.remove(new Integer(num1));
		//small_height.remove(new Integer(num2));
		//sum_height =  sum_height - num1 - num2;
		for(int i : small_height) {
			System.out.println(i);
		}
		//System.out.println(sum_height);
	}

}
