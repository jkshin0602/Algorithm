package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16936 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] A = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(A);

		long[] ans = new long[N];
		boolean[] isVisited = new boolean[N];

		for (int i = 0; i < N; i++) {
			go(i, 0, isVisited, ans, A, N);
		}

		for (long l : ans) {
			System.out.print(l + " ");
		}
	}

	private static boolean flag = false;

	private static void go(int current, int depth, boolean[] visited, long[] currentList, long[] A, int N) {
		if (flag) {
			return;
		}

		if (!visited[current]) {
			visited[current] = true;
			currentList[depth] = A[current];

			if (depth == N - 1) {
				flag = true;
				return;
			}

			if (currentList[depth] % 3 == 0) {
				for (int i = current - 1; i >= 0; i--) { //정렬을 한 상태이므로, 앞에 있는 값을 찾아야 한다.
					if (A[i] == currentList[depth] / 3) {
						go(i, depth + 1, visited, currentList, A, N);
						break;
					}
				}
			}

			for (int i = current + 1; i < N; i++) {
				if (A[i] == currentList[depth] * 2) { // 정렬을 한 상태이므로, 뒤에 있는 값을 찾아야 한다.
					go(i, depth + 1, visited, currentList, A, N);
					break;
				}
			}

			visited[current] = false;
		}
	}
}
