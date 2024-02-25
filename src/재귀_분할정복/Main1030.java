package 재귀_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1030 {
	private static int s, N, K, R1, R2, C1, C2;
	private static int[][] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());

		ans = new int[51][51];

		go((int)Math.pow(N, s), 0, 0, false);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= R2 - R1; i++) {
			for (int j = 0; j <= C2 - C1; j++) {
				sb.append(ans[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void go(int size, int y, int x, boolean isBlack) {
		// 범위를 벗어난다면 계산하지 않는다.
		if (y + size <= R1 || y > R2 || x + size <= C1 || x > C2) {
			return;
		}

		if (size == 1) {
			ans[y-R1][x-C1] = isBlack ? 1 : 0;
			return;
		}

		int ns = size / N;

		int blackStart = (N - K) / 2;
		int blackEnd = N - blackStart;

		for (int i = 0; i < N; i++) {
			// 시작 위치가 s 초 기준
			int ny = y + ns * i;
			for (int j = 0; j < N; j++) {
				int nx = x + ns * j;
				boolean isNextBlack =
					isBlack || ((i >= blackStart && i < blackEnd) && (j >= blackStart && j < blackEnd));
				go(ns, ny, nx, isNextBlack);
			}
		}
	}
}
