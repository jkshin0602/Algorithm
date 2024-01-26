package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int height = 256;
		int possible = Integer.MAX_VALUE;
		for (int i = 256; i >= 0; i--) {
			int result = go(i, map, B);
			if (possible > result) { //result 값이 MAX_VALUE 라면 불가한 작업, 아니라면 가능한 높이 갱신
				possible = result;
				height = i;
			}
		}

		int time = go(height, map, B);

		System.out.println(time + " " + height);
	}

	private static int go(int height, int[][] map, int B) {
		int time = 0;
		int inventory = B;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				int diff = map[i][j] - height;
				// 차이가 양수라면 블록을 제거해야 한다.
				if (diff > 0) {
					time += diff * 2;
				} else { // 차이가 음수라면 블록을 쌓아야 한다
					time += -diff; //음수 이므로 -1을 곱해줌
				}
				inventory += diff;
			}
		}

		// 현재 인벤토리의 블록이 0보다 적으면 불가한 작업
		return inventory < 0 ? Integer.MAX_VALUE : time;
	}
}

//1. 좌표(i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다 -> 2초
//2. 인벤토리에서 블록 하나를 꺼내어 좌표(i,j)의 가장 위에 있는 블록 위에 놓는다. -> 1초

// 땅을 고르는 비용이 가장 적은 높이는 무엇인가? == 땅을 높이 d로 고를 때 필요한 비용은 얼마인가?
// map[i][j] 가 D보다 높은 경우와 나눠서 처리
