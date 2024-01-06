package _4주차.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 끝나는 시간으로 순으로 정렬, 끝나는 시간이 빨라야 회의를 많이 할 수 있다.
		PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.end == o2.end) {
				return o1.start - o2.start;
			}
			return o1.end - o2.end;
		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			Meeting meet = new Meeting(start, end);
			pq.add(meet);
		}

		// 마지막 회의 시간을 기록
		int lastEnd = 0;
		int ans = 0;

		while (!pq.isEmpty()) {
			Meeting meet = pq.poll();

			if (meet.start >= lastEnd) {
				lastEnd = meet.end;
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static class Meeting {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
