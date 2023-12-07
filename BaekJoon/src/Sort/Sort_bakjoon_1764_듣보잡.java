package Sort;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Sort_bakjoon_1764_듣보잡 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        //듣잡
        int n = Integer.parseInt(st.nextToken());
        //보잡
        int m = Integer.parseInt(st.nextToken());

        Set<String> ns = new HashSet<String>();

        Set<String> ms = new HashSet<String>();

        //집합 초기화
        for(int i=0; i<n;i++) {
            ns.add(br.readLine());
        }

        for(int i=0; i<m;i++) {
            ms.add(br.readLine());
        }

        //교집합 구하기
        Set<String> inter = new HashSet<String>(ns); //ns와 같은 컬렉션을 복사
        inter.retainAll(ms); //retainAll을 사용하면 s2와 겹치는 내용만 남기고, 삭제한다.


        List<String> list = new ArrayList<String>(inter);

        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o1.compareTo(o2);
            }

        });

        System.out.println(list.size());
        for(String s : list) {
            System.out.println(s);
        }

    }

}

