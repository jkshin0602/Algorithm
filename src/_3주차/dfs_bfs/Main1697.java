package _3주차.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//위치가 X일 때 걷는다면 ?
//1초후에 X-1 or X + 1 로 이동
//순간이동을 한다면?
//1초 후에 2 * X 위치로 이동
public class Main1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] maps = new int[100_002];
		Arrays.fill(maps, -1);
		int result = bfs(N, K, maps);

		System.out.println(result);
	}

	private static int bfs(int start, int target, int[] map) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		map[start] = 0; //visit

		while (!q.isEmpty()) {
			int p = q.poll();

			if (isMap(p - 1)) { // map의 범위이면서
				if (map[p - 1] == -1) { //미방문 이라면
					map[p - 1] = map[p] + 1;
					q.add(p - 1);
				}else { // 방문 상태라면
					if (map[p - 1] > map[p] + 1) { //새로운 방법이 기존 방문 횟수보다 적다면
						map[p-1] = map[p] + 1; //방문 횟수 갱신
						q.add(p - 1);
					}
				}
			}

			if (isMap(p + 1)) { //map의 범위 이면서
				if (map[p + 1] == -1) { //미방문 이라면
					map[p + 1] = map[p] + 1;
					q.add(p + 1);
				} else { //방문 상태라면
					if (map[p + 1] > map[p] + 1) { //새로운 방법이 기존 방문횟수 보다 적다면?
						map[p + 1] = map[p] + 1; //방문 횟수 갱신
						q.add(p + 1);
					}
				}
			}

			if (isMap(p * 2)){ //map의 범위 이면서
				if (map[p * 2] == -1) { //미방문이라면?
					map[p * 2] = map[p] + 1;
					q.add(p * 2);
				}else {
					if (map[p * 2] > map[p] + 1) { //새로운 방법이 기존 방문횟수 보다 적다면?
						map[p * 2] = map[p] + 1; //방문 횟수 갱신
						q.add(p * 2);
					}
				}
			}
		}

		return map[target];
	}

	private static boolean isMap(int nx) {
		return 0 <= nx && nx <= 100_001;
	}
}
