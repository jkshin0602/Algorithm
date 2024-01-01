package _3주차.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2667 {

	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] maps = new int[N][N];
		int[][] visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				maps[i][j] = input.charAt(j) - '0';
				visited[i][j] = -1;
			}
		}

		int cnt = 0;

		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (maps[i][j] == 1 && visited[i][j] == -1) {
					int result = bfs(maps, visited, cnt++, new Pair(i, j));
					ans.add(result);
				}
			}
		}

		Collections.sort(ans);

		System.out.println(cnt);
		for (int x : ans) {
			System.out.println(x);
		}
	}

	private static int bfs(int[][] maps, int[][] visited, int cnt, Pair start) {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = cnt;

		int house = 1;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if (isNotMap(ny, nx, maps, visited)) {
					continue;
				}
				q.add(new Pair(ny, nx));
				visited[ny][nx] = visited[p.y][p.x];
				house++;
			}
		}

		return house;
	}

	private static boolean isNotMap(int ny, int nx, int[][] maps, int[][] visited) {
		return isNotMapRange(ny, nx, maps) // 맵의 범위가 아니거나
			|| maps[ny][nx] == 0  //집이 아니거나
			|| visited[ny][nx] != -1; // 이미 방문한 집이거나
	}

	private static boolean isNotMapRange(int ny, int nx, int[][] maps) {
		return ny < 0 || nx < 0 || ny >= maps.length || nx >= maps.length;
	}

	private static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
