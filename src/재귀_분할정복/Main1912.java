package 재귀_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		int[] D = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			D[i] = A[i] = Integer.parseInt(st.nextToken());
		}

		int ans = D[0];

		for (int i = 1; i < N; i++) {
			D[i] = Math.max(D[i], D[i - 1] + A[i]);
			ans = Math.max(ans, D[i]);

		}

		System.out.println(ans);
	}
}
