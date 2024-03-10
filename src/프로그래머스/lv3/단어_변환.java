package 프로그래머스.lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {
	public static int solution(String begin, String target, String[] words) {
		// target이 words 내부에 포함돼있지 않다면 0 반환
		if (Arrays.stream(words).noneMatch(it -> it.equals(target))) {
			return 0;
		}

		return bfs(
			begin,
			target,
			words,
			new int[words.length]
		);
	}

	private static int bfs(
		String begin,
		String target,
		String[] words,
		int[] visited
	) {
		Queue<String> q = new LinkedList<>();
		q.add(begin);

		while (!q.isEmpty()) {
			String p = q.poll();

			int count = 0;
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals(p)) {
					count = visited[i];
					break;
				}
			}

			if (p.equals(target)) {
				break;
			}

			for (int i = 0; i < words.length; i++) {
				if (visited[i] > 0) {
					continue;
				}

				if (isChange(p, words[i])) {
					visited[i] = count + 1;
					q.add(words[i]);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				ans = visited[i];
			}
		}

		return ans;
	}

	private static boolean isChange(
		String begin,
		String word
	) {
		int count = 0;

		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != word.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(
			solution(
				"hit",
				"cog",
				new String[] {"hot", "dot", "dog", "lot", "log", "cog"}
			)
		);
		System.out.println(
			solution(
				"hit",
				"cog",
				new String[] {"hot", "dot", "dog", "lot", "log"}
			)
		);

	}
}
