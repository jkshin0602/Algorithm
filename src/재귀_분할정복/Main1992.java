package 재귀_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {

	private static StringBuilder ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ans = new StringBuilder();

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		go(N, map, 0, 0);

		System.out.println(ans);
	}

	private static void go(int size, int[][] map, int startY, int startX) {
		if (isAllSame(size, map, startY, startX, map[startY][startX])) {
			ans.append(map[startY][startX]);
			return;
		}

		ans.append("(");
		go(size / 2, map, startY, startX); // 1사분면
		go(size / 2, map, startY, startX + size / 2); // 2사분면
		go(size / 2, map, startY + size / 2, startX); // 3사분면
		go(size / 2, map, startY + size / 2, startX + size / 2); // 4사분면
		ans.append(")");
	}

	private static boolean isAllSame(int size, int[][] map, int startY, int startX, int x) {
		for (int i = startY; i < startY + size; i++) {
			for (int j = startX; j < startX + size; j++) {
				if (map[i][j] != x) {
					return false;
				}
			}
		}

		return true;
	}
}
