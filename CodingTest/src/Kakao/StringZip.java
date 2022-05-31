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
        String zip="";//압축한 문자열을 저장할 빈 문자열
        String last="";//가장 마지막에 남아 떨어지는 문자열을 담는다.
        StringBuilder sb = new StringBuilder();
        
        //문자열을 자르자. 자르는 기준은 1부터 해서 전체 길이의 절반 까지. 길이가 8인 문자열에서 자르는 길이를 5로 잡는 패턴은 어차피 반복이 될 수 없기 때문에 의미가 없다.
        
        for(int i=1; i<=s.length()/2; i++) {
        	
        	int count = 1;//패턴의 시작이 되는 자기 자신은 카운트 하고 시작한다.
        	
        	String pattern = s.substring(0, i);//0(시작)부터 i개의 문자열을 자른다.
        	
        	//자른 문자열을 나머지 배열에서 확인하면서 반복을 확인한다.
        	for(int k=i; k<s.length(); k+=i) {
        		if(k+i > s.length()) {
        			last = s.substring(k, s.length());
        			continue;//어차피 마지막이라서 반복의 가능성도 없음. 이어붙이기만 하면됨
        		}
        		String temp = s.substring(k, k+i);
        		
				if(pattern.equals(temp)) {
        			count++;
        		}else {//같지않다면,,,패턴의 반복이 끊김.
        			if(count>1) {
        				sb.append(count+pattern);
        			}else {
        				sb.append(pattern);
        			}
        			pattern = temp; //같지 않은 문자열로 반복의 패턴을 바꿔서 이어서 검사 수행.
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
	생각을 해보자 
	문자열을 압축하는데, 반복되는 문자는 "반복되는숫자+반복되는문자"의 형식으로 압축이 가능하다. (EX> aaa -> 3a)
	문자열을 자르는 기준은 1개 이상이다. 
	자르는 기준이 2개부터는 "패턴"을 파악하면 된다. (EX> abab -> 2ab)
	문자열은 반드시 맨 앞자리부터 시작해야 한다.
	
	반복되는 패턴을 찾아내고 -> 패턴을 기준으로 압축했을 때, 압축되는 길이의 최소를 구해라.
*/
