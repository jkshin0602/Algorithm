package 프로그래머스.lv3;

import java.util.PriorityQueue;

public class 야근_지수 {
	// 야근 피로도 =
	// 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값
	// N 시간 동안 야근 피로도를 최소화

	// 1시간 동안 작업 량 1만큼 처리 가능
	// 퇴근 까지 남은 N 시간과 각 일에 대한 작업량에 대해 야근 피로도를 최소화한 값

	// [남은 일의 작업량을 제곱하여 더한 값]
	// 남은 일 먼저 줄이면 제곱하는 값이 작아지므로, 더한 값도 작아진다 -> 피로도 감소

	public static long solution(int n, int[] works) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for (int work : works) {
			pq.add(work);
		}

		while (!pq.isEmpty() && n > 0) {
			int p = pq.poll() - 1;
			n--;

			if (p == 0) {
				continue;
			}
			pq.add(p);
		}

		return pq.stream().mapToLong(it -> (long)it * it).sum();
	}

	public static void main(String[] args) {
		System.out.println(
			solution(
				4,
				new int[] {4, 3, 3}
			)
		);
		System.out.println(
			solution(
				1,
				new int[] {2, 1, 2}
			)
		);
		System.out.println(
			solution(
				3,
				new int[] {1, 1}
			)
		);

	}
}
