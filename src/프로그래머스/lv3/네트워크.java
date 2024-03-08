package 프로그래머스.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

	public static int solution(int n, int[][] computers) {
		int answer = 0;

		boolean[] isVisit = new boolean[n];

		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[0].length; j++) {
				if (computers[i][j] == 1 && !isVisit[i]) {
					answer++;
					bfs(isVisit, computers, i);
				}
			}
		}

		return answer;
	}

	private static void bfs(
		boolean[] isVisit,
		int[][] computers,
		int start
	) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		isVisit[start] = true;

		while (!q.isEmpty()) {
			int p = q.poll();

			for (int i = 0; i < computers.length; i++) {
				if (isVisit[i]) {
					continue;
				}
				if (computers[p][i] == 1) {
					q.add(i);
					isVisit[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}
}
