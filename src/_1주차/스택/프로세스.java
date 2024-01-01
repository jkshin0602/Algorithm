package _1주차.스택;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {

	// 1. 실행 대기 큐 에서 대기 중인 프로세스를 하나 꺼낸다.
	// 2. 큐에 대기 중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣는다.
	// 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행한다.
	// 		3-1. 한 번 실행한 프로세스는 다 시큐에 넣지 않고 그대로 종료된다.

	//백준 프린터 문제랑 같은 문제

	public int solution(int[] priorities, int location) {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			q.add(i);
		}

		int order = 1;

		label:
		while (!q.isEmpty()) {
			int p = q.poll();
			for (int x : q) {
				if (priorities[x] > priorities[p]) {
					q.add(p);
					continue label;
				}
			}

			//여기까지 왔다면 우선순위가 가장 높은 것
			if (p == location) {
				break;
			}
			order++;
		}

		return order;
	}

	public static void main(String[] args) {
		var 프로세스 = new 프로세스();
		System.out.println(프로세스.solution(new int[]{2,1,3,2}, 2) == 1);
		System.out.println(프로세스.solution(new int[]{1,1,9,1,1,1}, 0) == 5);
	}
}
