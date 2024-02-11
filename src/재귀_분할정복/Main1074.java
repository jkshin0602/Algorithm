package 재귀_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {

	private static int[] dy = {0, 0, 1, 1};
	private static int[] dx = {0, 1, 0, 1};
	private static int orders, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		orders = -1;

		go(N, 0, 0);
		System.out.println(orders);
	}

	private static void go(int N, int startY, int startX) {
		if (N == 1) {
			count(startY, startX);
			return;
		}

		int len = (int)Math.pow(2, N);

		int half = len / 2;
		if (startY <= r && r < startY + half && startX <= c && c < startX + half) { // 1사분면
			go(N - 1, startY, startX);
		} else if (startY <= r && r < startY + half && startX + half <= c && c < startX + len) { // 2사분면
			go(N - 1, startY, startX + half);
			orders += (half * half);
		} else if (half + startY <= r && r < startY + len && startX <= c && c < startX + half) { // 3사분면
			go(N - 1, startY + half, startX);
			orders += (half * half) * 2;
		} else if (half + startY <= r && r < startY + len && startX + half <= c && c < startX + len) { //4사분면
			go(N - 1, startY + half, startX + half);
			orders += (half * half) * 3;
		}
	}

	private static void count(int startY, int startX) {
		for (int i = 0; i < 4; i++) {
			orders++;
			int ny = startY + dy[i];
			int nx = startX + dx[i];

			if (ny == r && nx == c) {
				break;
			}
		}
	}
}
