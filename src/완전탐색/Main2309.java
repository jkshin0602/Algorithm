package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309 {

	private static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[9];

		for (int i = 0; i < 9; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(A);

		find(0, new boolean[9], 0, A);
	}

	private static void find(int current, boolean[] visited, int sum, int[] A) {
		if (flag) {
			return;
		}

		if (current == 7) {
			if (sum == 100) {
				flag = true;
				for (int i = 0; i < 9; i++) {
					if (visited[i]) {
						System.out.println(A[i]);
					}
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			find(current + 1, visited, sum + A[i], A);
			visited[i] = false;
		}
	}
}
