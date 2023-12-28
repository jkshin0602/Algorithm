package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11724 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graphs = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graphs[i] = new ArrayList<>();
		}

		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graphs[x].add(y);
			graphs[y].add(x);
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				ans++;
				dfs(graphs, visited, i);
			}
		}

		System.out.println(ans);
	}

	private static void bfs(ArrayList<Integer>[] graphs, boolean[] visited, int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int p = q.poll();

			for (int x : graphs[p]) {
				if (visited[x]) {
					continue;
				}
				q.add(x);
				visited[x] = true;
			}
		}
	}

	private static void dfs(ArrayList<Integer>[] graphs, boolean[] visited, int current) {
		if (visited[current]) {
			return;
		}
		visited[current] = true;

		for (int x : graphs[current]) {
			if (visited[x]) {
				continue;
			}
			dfs(graphs, visited, x);
		}
	}
}
