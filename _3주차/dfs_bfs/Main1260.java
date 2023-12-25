package _3주차.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x].add(y);
			graph[y].add(x);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		dfs(graph, V, new boolean[N + 1]);
		System.out.println();
		bfs(graph, V, new boolean[N + 1]);
	}

	private static void dfs(ArrayList<Integer>[] graph, int current, boolean[] visited) {
		if (visited[current]) {
			return;
		}

		visited[current] = true;
		System.out.print(current + " ");

		for (int x : graph[current]) {
			dfs(graph, x, visited);
		}
	}

	private static void bfs(ArrayList<Integer>[] graph, int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int p = q.poll();
			System.out.print(p + " ");

			for (int x : graph[p]) {
				if (visited[x]) {
					continue;
				}

				q.add(x);
				visited[x] = true;
			}
		}
	}
}
