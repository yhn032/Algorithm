package DivideAndConquor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11401 {
    final static long P = 1000000007;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // ���� N!
        long numer = factorial(N);
        // �и� (K! * (N-K)!) mod p
        long denom = factorial(K) * factorial(N - K) % P;
        // N! * �и��� ����((K! * (N-K)!)
        System.out.println(numer * pow(denom, P - 2) % P);
    }


    // ���丮�� �Լ�
    public static long factorial(long N) {
        long fac = 1L;

        while(N > 1) {
            fac = (fac * N) % P;
            N--;
        }
        return fac;
    }
    /*
     * ���� ���ϴ� �Լ�
     * base : ��,   expo = ���� (exponent)
     * �ŵ� ������ ���� ���� ������� Ǭ��.
     */
    public static long pow(long base, long expo) {
        // ������ 1�� ��� base^1 �̹Ƿ� base % P�� ����
        if(expo == 1) {
            return base % P;
        }

        // ������ ���ݿ� �ش��ϴ� base^(expo / 2) �� ���Ѵ�.
        long temp = pow(base, expo / 2);

        /*
         * ���� ������ Ȧ �� ���ٸ�
         * base^(expo / 2) * base^(expo / 2) * base �̹Ƿ�
         * base�� �� �� �� �����־�� �Ѵ�.
         *
         * ex) A^9 = A^4 * A^4 * A
         */
        if(expo % 2 == 1) {
            return (temp * temp % P) * base % P;
        }
        return temp * temp % P;

    }
}
