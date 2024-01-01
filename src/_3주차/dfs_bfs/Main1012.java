package _3주차.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] maps = new int[N][M];
			boolean[][] visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				maps[Y][X] = 1;
			}

			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (maps[i][j] == 1 && !visited[i][j] ) {
						bfs(maps, visited, new Pair(i, j));
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static void bfs(int[][] maps, boolean[][] visited, Pair start) {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if (isNotMap(ny, nx, maps) || maps[ny][nx] == 0 || visited[ny][nx]) {
					continue;
				}

				q.add(new Pair(ny, nx));
				visited[ny][nx] = true;
			}
		}
	}

	private static boolean isNotMap(int ny, int nx, int[][] maps) {
		return ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length;
	}

	private static class Pair{
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
