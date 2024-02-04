package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17484 {

	private static int ans;
	private static final int[] DY = {-1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			go(map, 1, i, -1, map[0][i]);
		}

		System.out.println(ans);
	}

	private static void go(int[][] map, int depth, int y, int beforeDirect, int sum) {
		if (map.length == depth) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = 0; i < 3; i++) {
			int ny = y + DY[i];

			if (ny < 0 || ny >= map[0].length) {
				continue;
			}

			if (beforeDirect != i) {
				go(map, depth + 1, ny, i, sum + map[depth][ny]);
			}
		}
	}
}
