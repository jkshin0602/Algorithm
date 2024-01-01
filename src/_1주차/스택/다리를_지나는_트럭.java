package _1주차.스택;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

	//트럭 여러 대가 일차선 다리를 정해진 순으로 건너야 한다.
	//모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지?
	//다리에는 트럭이 최대 bridge_length 대 올라 갈 수 있다.
	//weight 이하까지 무게 지탱 가능
	//다리에 완전히 오르지 않았다면 트럭의 무게는 무시

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> q = new LinkedList<>();

		int currentWeight = 0;
		int answer = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			while (true) {
				//1. 다리에 트럭이 없는 경우
				if (q.isEmpty()) {
					q.add(truck_weights[i]); //트럭 한대 올리기
					answer++; // 트럭이 다리 올라가는 시간 추가
					currentWeight += truck_weights[i];
					break;
				}
				//2. 다리의 길이가 꽉찬 경우
				else if (q.size() == bridge_length) {
					currentWeight -= q.poll();
					continue;
				}
				//3. 다리의 길이만큼 차지 않은 경우
				//3-1. 트럭이 더 올라갈 수 있는 경우
				if (weight >= currentWeight + truck_weights[i]) {
					q.add(truck_weights[i]);
					answer++;
					currentWeight += truck_weights[i];
					break;
				}
				//3-2. 트럭이 못 올라가는 경우
				q.add(0);
				answer++; //다리에 트럭이 못 올라 가는 경우 트럭을 이동 시킴 (시간 추가)
			}
		}
		return answer + bridge_length;
	}

	public static void main(String[] args) {
		다리를_지나는_트럭 s = new 다리를_지나는_트럭();

		System.out.println(8 == s.solution(2, 10, new int[] {7, 4, 5, 6}));
		System.out.println(101 == s.solution(100, 100, new int[] {10}));
		System.out.println(110 == s.solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
	}
}
