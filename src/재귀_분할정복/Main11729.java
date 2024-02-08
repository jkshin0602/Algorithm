package 재귀_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11729 {
	private static StringBuilder ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ans = new StringBuilder();

		ans.append((int)Math.pow(2, N) - 1).append('\n');

		hanoi(N, 1, 2, 3);

		System.out.println(ans);
	}

	private static void hanoi(int N, int start, int mid, int to) {
		if (N == 1) {
			ans.append(start).append(' ').append(to).append('\n');
			return;
		}
		// 1. N-1 개를 start 지점에서 mid 지점으로 이동
		hanoi(N - 1, start, to, mid);

		// 2. 1개를 start 지점에서 to 지점으로 이동
		ans.append(start).append(' ').append(to).append('\n');

		// 3. N-1 개를 mid 지점에서 to 지점으로 이동
		hanoi(N - 1, mid, start, to);
	}
}
