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

public class Sort_bakjoon_1764_�躸�� {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        //����
        int n = Integer.parseInt(st.nextToken());
        //����
        int m = Integer.parseInt(st.nextToken());

        Set<String> ns = new HashSet<String>();

        Set<String> ms = new HashSet<String>();

        //���� �ʱ�ȭ
        for(int i=0; i<n;i++) {
            ns.add(br.readLine());
        }

        for(int i=0; i<m;i++) {
            ms.add(br.readLine());
        }

        //������ ���ϱ�
        Set<String> inter = new HashSet<String>(ns); //ns�� ���� �÷����� ����
        inter.retainAll(ms); //retainAll�� ����ϸ� s2�� ��ġ�� ���븸 �����, �����Ѵ�.


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

