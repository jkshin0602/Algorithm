package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main7573 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Fish> fish = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			fish.add(new Fish(y, x));
		}
		List<Net> nets = createNets(I);

		int ans = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int result = go(fish, nets, i, j);
				ans = Math.max(ans, result);
			}
		}

		System.out.println(ans);
	}

	// 물고기 2개를 선택해, 해당 물고기를 범위로 사용
	private static int go(List<Fish> fish, List<Net> nets, int fish1, int fish2) {
		int y = fish.get(fish1).y;
		int x = fish.get(fish2).x;

		int maxResult = 0;
		for (Net net : nets) {
			int result = 0;
			for (int i = 0; i < fish.size(); i++) {
				Fish f = fish.get(i);

				if (x <= f.x && f.x <= x + net.length && y <= f.y && f.y <= y + net.width) {
					result++;
				}
			}
			maxResult = Math.max(result, maxResult);
		}

		return maxResult;
	}

	// 1. 그물의 길이가 I 일 때 만들 수 있는 그물의 종류 만들기
	// I는 짝수, (I/2) == (그물의 길이 x + y)
	private static List<Net> createNets(int I) {
		List<Net> nets = new ArrayList<>();

		int target = I / 2;

		for (int i = 1; i < target; i++) {
			nets.add(new Net(i, target - i));
		}

		return nets;
	}

	private static class Net {
		int width, length;

		public Net(int width, int length) {
			this.width = width;
			this.length = length;
		}
	}

	private static class Fish {
		int y, x;

		public Fish(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
