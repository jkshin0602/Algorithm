package 프로그래머스.lv3;

import java.util.PriorityQueue;

public class 단속카메라 {
	public static int solution(int[][] routes) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.end == o2.end) {
				return o1.start - o2.start;
			}
			return o1.end - o2.end;
		});

		for (int i = 0; i < routes.length; i++) {
			int start = routes[i][0];
			int end = routes[i][1];

			pq.add(new Pair(start, end));
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			ans++;

			// 차량의 진입점 <= 현재 뽑은 차량의 나간 지점
			// 기존 뽑은 차량의 위치의 단속 카메라로 커버 가능
			// 커버 가능한 곳 까지 제거
			while (!pq.isEmpty() && pq.peek().start <= p.end) {
				pq.poll();
			}
		}

		return ans;
	}

	private static class Pair {
		int start, end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		System.out.println(
			solution(new int[][] {
				{-20, -15},
				{-14, -5},
				{-18, -13},
				{-5, -3}
			})
		);
		System.out.println(
			solution(new int[][] {
				{-20, -15},
				{-14, 2},
				{3, 4},
				{5, 6}
			})
		);
		System.out.println(
			solution(new int[][] {
					{-100, 100},
					{50, 170},
					{150, 200},
					{-50, -10},
					{10, 20},
					{30, 40}
				}
			)
		);

	}
}

// 고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라 설치
// 고속도로를 이동하는 차량의 경로 routes 가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야하는지?

// 1 <= 차량의 대수 <= 10,000
// routes 에는 차량의 이동 경로 포함
// routes[i][0] 에는 i 번째 차량이 고속도로에 진입한 지점, routes[i][1] 에는 i 번째 차량이 고속도로에 나간 지점
// 차량의 진입/진출 지점에 카메라가 설치되어 있어도, 카메라를 만난 것으로 간주
// 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하
