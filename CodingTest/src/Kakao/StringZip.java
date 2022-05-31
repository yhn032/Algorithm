package Kakao;

public class StringZip {
	public static void main(String[] args) {
		String s = "abcabcdede";
		
		Solution7 s7 = new Solution7();
		
		int answer = s7.solution7(s);
		
		System.out.println(answer);
	}
}

class Solution7 {
    public int solution7(String s) {
        int answer = 0;
        int min_cnt = s.length();
        String zip="";//������ ���ڿ��� ������ �� ���ڿ�
        String last="";//���� �������� ���� �������� ���ڿ��� ��´�.
        StringBuilder sb = new StringBuilder();
        
        //���ڿ��� �ڸ���. �ڸ��� ������ 1���� �ؼ� ��ü ������ ���� ����. ���̰� 8�� ���ڿ����� �ڸ��� ���̸� 5�� ��� ������ ������ �ݺ��� �� �� ���� ������ �ǹ̰� ����.
        
        for(int i=1; i<=s.length()/2; i++) {
        	
        	int count = 1;//������ ������ �Ǵ� �ڱ� �ڽ��� ī��Ʈ �ϰ� �����Ѵ�.
        	
        	String pattern = s.substring(0, i);//0(����)���� i���� ���ڿ��� �ڸ���.
        	
        	//�ڸ� ���ڿ��� ������ �迭���� Ȯ���ϸ鼭 �ݺ��� Ȯ���Ѵ�.
        	for(int k=i; k<s.length(); k+=i) {
        		if(k+i > s.length()) {
        			last = s.substring(k, s.length());
        			continue;//������ �������̶� �ݺ��� ���ɼ��� ����. �̾���̱⸸ �ϸ��
        		}
        		String temp = s.substring(k, k+i);
        		
				if(pattern.equals(temp)) {
        			count++;
        		}else {//�����ʴٸ�,,,������ �ݺ��� ����.
        			if(count>1) {
        				sb.append(count+pattern);
        			}else {
        				sb.append(pattern);
        			}
        			pattern = temp; //���� ���� ���ڿ��� �ݺ��� ������ �ٲ㼭 �̾ �˻� ����.
        			count = 1;
        		}
        	}//end-for k
        	
        	if(count>1) {
				sb.append(count+pattern);
			}else {
				sb.append(pattern);
			}
        	
        	sb.append(last);
        	last="";
        	zip = sb.toString();
        	sb.setLength(0);
        	//System.out.println(zip);
        	int zip_cnt = zip.length();
        	
        	min_cnt = min_cnt > zip_cnt ? zip_cnt : min_cnt;
        }
        answer = min_cnt;
        return answer;
    }
}
/*
	������ �غ��� 
	���ڿ��� �����ϴµ�, �ݺ��Ǵ� ���ڴ� "�ݺ��Ǵ¼���+�ݺ��Ǵ¹���"�� �������� ������ �����ϴ�. (EX> aaa -> 3a)
	���ڿ��� �ڸ��� ������ 1�� �̻��̴�. 
	�ڸ��� ������ 2�����ʹ� "����"�� �ľ��ϸ� �ȴ�. (EX> abab -> 2ab)
	���ڿ��� �ݵ�� �� ���ڸ����� �����ؾ� �Ѵ�.
	
	�ݺ��Ǵ� ������ ã�Ƴ��� -> ������ �������� �������� ��, ����Ǵ� ������ �ּҸ� ���ض�.
*/
