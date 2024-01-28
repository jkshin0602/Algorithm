package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {

	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 수열의 개수는 양수여야 함, S가 0 이면 공집합 제거
		ans = S == 0 ? -1 : 0;

		go(A, S, 0, 0);

		System.out.println(ans);
	}

	private static void go(int[] A, int S, int current, int sum) {
		if (current == A.length) {
			if (sum == S) {
				ans++;
			}
		} else {
			go(A, S, current + 1, sum + A[current]);
			go(A, S, current + 1, sum);
		}
	}
}
