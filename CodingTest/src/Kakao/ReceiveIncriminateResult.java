package Kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
	�� ������ �� ���� 1�� �Ű���
	��, �����ι��� ���ؼ� �Ű�Ƚ���� 1�� count. �� ����� Ư���ι��� ������ �Ű��ص� count���� ����
	�Ű��� ����� �̿������� �Ǹ� �� ����� �Ű��� ������� ���� ������ �ϴµ� �� Ƚ���� ����϶�.(return, id_list�� ��� �������)
*/


class Solution3 {
    public int[] solution(String[] id_list, String[] report, int k) {
    	//�Ű� ���� 
    	int[] answer = new int[id_list.length];
    	
    	//�������� �Ű���� Ƚ���� ����
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	//�������� �Ű��� ������ ����
    	HashMap<String, HashSet<String>> map2 = new HashMap<String, HashSet<String>>();
    	
    	for(int i=0; i<id_list.length;i++) {
    		String name = id_list[i];//�ǽŰ����� �̸�
    		map.put(name, i); //�Ű��ڿ� ���ؼ� �ε������� �Բ� ����
    		map2.put(name, new HashSet<>());
    	}
    	
    	for(int i=0; i<report.length;i++) {
    		String result[] = report[i].split(" ");
    		//�Ű��� ����� ID
    		String a = result[0];
    		//�Ű���� ����� ID
    		String b = result[1];
    		//�Ű���� ����� id�� ���ε� value�����ٰ� �Ű��� ����� id�� �߰��Ѵ�. ��, HashSet�� Ư���� �ߺ��� �Ұ����ϴ�. -> �� ����� ������ �Ű��ص� 1 count
    		map2.get(b).add(a);
    		
    	}
    	//map2�� ��ȯ
    	for(int i=0; i<id_list.length;i++) {
    		//id_list[i]�� �Ű��� ������� ����Ǿ� ����
    		HashSet<String> send = map2.get(id_list[i]);
    		if(send.size() >= k) { //�̿� ��������̶��
    			
    			//�Ʊ� ���� ������ �ε����� id_list�� ����� id�� ���� ������ �����뺸 Ƚ�� ����
    			//������ ���� send���� �ִ� ����ڿ��� ������ ������ Ƚ���� +1
    			for(String name : send) {
    				answer[map.get(name)]++;
    				//System.out.print(answer[i]);
    			}
    		}
    	}
        return answer;
    }
}
public class ReceiveIncriminateResult {
	public static void main(String[] args) {
		
		int k = 2;
		
		String id_list[] = {"muzi", "frodo", "apeach", "neo"};
		String report[]  = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		Solution3 s3 = new Solution3();
		int[] result = s3.solution(id_list, report, k);

		for(int n : result) {
			System.out.print(n + " ");
		}
			
		//map.put(name, map.getOrDefault(name, 0)+1); //�⺻������ �Ű� ���� ����� 1���� ���� -> �ٵ� �̷� ��쿡�� �����ι��� �Ű��ص� ī��Ʈ�� �ǹǷ� ����
		
		/*
			1. String, integer ������ map���� ��ü ������ ���� ������ �ε��� ���� ����  -> ���߿� �迭�� ���� ���� Ƚ���� �����ϱ� ���� �ε��� ��ġ�� �������ִ� ��
			2. String, HashSet<> ������ map���� ��ü ������ ���� ������ �Ű��� ����� ����. set�� ����� ������ �ѻ���� ������ ���� ����� �ݺ������� �Ű�������, �Ű�Ƚ���� ī��Ʈ ���� �ʱ� �����̴�. 
			3. �Ű���� ����� ���ö����� �迭�� �ε����� ����� �����Ͽ� ���� 1�� ������Ų��. 
			4. ���� >= k�� ����� �Ű��� ������Ը� ���� ���� 
		*/
	}
}
