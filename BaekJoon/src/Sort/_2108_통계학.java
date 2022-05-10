package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _2108_����� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		
		//1. ������
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		double avg = (sum*1.0)/N;
		System.out.println((int)Math.round(avg));
		
		//2. �߾Ӱ�
		System.out.println(arr[N/2]);
		
		//3. �ֺ�
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {//�⺻������ 1�� �ְ� ���ĺ��ʹ� +1�� �ؼ� ����Ѵ�.
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		List<Integer> list = new ArrayList<Integer>();
		
		int num = 0;
		//���⿡���� �󵵼��� "�ִ�"�� ���Ѵ�. 
		//value�����δ� Ű�� ���� �� ����.
		for(int v : map.values()) { //v�� ���� ������ �󵵼��̴�. �󵵼��� �ִ밪�� ���Ѵ�.
			num = num > v ? num : v; 
		}
		
		//�󵵼��� �ִ��� key�� ã�´�.
		for(int key : map.keySet()) {
			if(map.get(key) == num) {
				list.add(key);
			}
		}
		
		//�����ϱ� 
		Collections.sort(list);
		if(list.size()>=2) {//���� ���� �� �ֺ��� ��������� 2��°�� ���,1���ϰ��� ù ��° �� ���
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}
		
		
		//4. ����
		int range = arr[N-1] - arr[0];
		System.out.println(range);
	}

}
