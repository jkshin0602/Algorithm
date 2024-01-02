package _4주차.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {

	//동전을 적절히 사용해서 합을 K로 만들려고한다.
	//필요한 동전 개수의 최솟값을 구하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (K <= 0) {
				break;
			}
			ans += K / A[i];
			K %= A[i];
		}

		System.out.println(ans);
	}
}
