package _1주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder("<");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		while (!q.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				int x = q.poll();
				q.add(x);
			}
			int c = q.poll();
			sb.append(c).append(", ");
		}


		sb = sb.delete(sb.length() - 2, sb.length()).append(">");
		System.out.println(sb);
	}
}
