package _3주차.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] graphs = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graphs[i] = new ArrayList<>();
		}

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graphs[x].add(y);
			graphs[y].add(x);
		}

		int result = bfs(graphs, visited, 1);
		System.out.println(result);
	}

	private static int bfs(ArrayList<Integer>[] graphs, boolean[] visited, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		int count = 0;

		while (!q.isEmpty()) {
			int p = q.poll();

			for (int x : graphs[p]) {
				if (visited[x]) {
					continue;
				}

				q.add(x);
				visited[x] = true;
				count++;
			}
		}

		return count;
	}
}
