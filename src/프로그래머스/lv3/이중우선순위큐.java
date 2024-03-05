package 프로그래머스.lv3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);

		for (String operation : operations) {
			exec(operation, maxQueue, minQueue);
		}

		if (maxQueue.isEmpty() || minQueue.isEmpty()) {
			return new int[] {0, 0};
		}

		return new int[] {maxQueue.peek(), minQueue.peek()};
	}

	private static void exec(String operation, PriorityQueue<Integer> maxQueue, PriorityQueue<Integer> minQueue) {
		if (operation.equals("D -1")) { // 최솟값 삭제
			if (maxQueue.isEmpty() || minQueue.isEmpty()) {
				return;
			}
			int minValue = minQueue.poll();
			maxQueue.remove(minValue);
		} else if (operation.equals("D 1")) { // 최대값 삭제
			if (maxQueue.isEmpty() || minQueue.isEmpty()) {
				return;
			}
			int maxValue = maxQueue.poll();
			minQueue.remove(maxValue);
		} else {
			int num = Integer.parseInt(operation.split(" ")[1]);
			maxQueue.add(num);
			minQueue.add(num);
		}

	}

	public static void main(String[] args) {
		System.out.println(
			Arrays.toString(solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))
		);
		System.out.println(
			Arrays.toString(
				solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))
		);
	}
}
