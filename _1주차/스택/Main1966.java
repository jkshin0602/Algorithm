package _1주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1966 {

	/*
	 * 프린터 조건
	 * 1. 현재 Queue의 가장 앞에 있는 문서의 '중요도'를 확인한다.
	 * 2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고, Queue의 가장 뒤에 재배치 한다. 그렇지 않으면 바로 인쇄를 한다.
	 * */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] priority;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 몇 번 째로 인쇄되었는지 궁금한 문서가 프린터 Queue 에서 몇 번째로 놓여 있는지

			st = new StringTokenizer(br.readLine());
			priority = new int[N]; // 중요도가 같은 문서는 여러 개 있을 수도 있다.

			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				priority[i] = Integer.parseInt(st.nextToken());
				q.add(i);
			}

			int order = 1;
			label:
			while (!q.isEmpty()) {
				int p = q.poll();
				for (int x : q) {
					if (priority[p] < priority[x]) {
						q.add(p);
						continue label;
					}
				}

				//여기까지 오면 tmp는 큐에서 우선 순위가 가장 높은 것
				if (p == M) {
					System.out.println(order);
					break;
				}
				order++;
			}
		}
	}
}
