package _3주차.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] maps = new int[N][M];
		int[][] visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				maps[i][j] = input.charAt(j) - '0';
				visited[i][j] = -1;
			}
		}

		bfs(maps, visited, new Pair(0, 0));

		System.out.println(visited[N - 1][M - 1]);
	}

	private static void bfs(int[][] maps, int[][] visited, Pair start) {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = 1;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if (isNotMap(ny, nx, maps) || maps[ny][nx] != 1 || visited[ny][nx] != -1) {
					continue;
				}
				q.add(new Pair(ny, nx));
				visited[ny][nx] = visited[p.y][p.x] + 1;
			}
		}
	}

	private static boolean isNotMap(int y, int x, int[][] maps) {
		return y < 0 || x < 0 || y >= maps.length || x >= maps[0].length;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
