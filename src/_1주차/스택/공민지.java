package _1주차.스택;

import java.util.ArrayList;

public class 공민지 {

	public static void main(String[] args) {
		ArrayList<Node>[] graph = new ArrayList[6];
		for (ArrayList<Node> nodes : graph) {
			nodes = new ArrayList<>();
		}

		//
		graph[1].add(new Node(1, 2));
	}
}

class Node {
	int nodeNum;
	int weight;

	public Node(int nodeNum, int weight) {
		this.nodeNum = nodeNum;
		this.weight = weight;
	}
}