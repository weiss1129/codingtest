package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 2026/02/09
 * @author weiss
 * 문제
 * N개의 수 A1, A2, ..., AN과 L이 주어진다.
 * 
 * Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
 * 
 * 입력
 * 첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
 * 
 * 둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)
 * 
 * 출력
 * 첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
 * 
 */
public class P11003 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			// n과 m
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken()); // 숫자의 수
			int m = Integer.parseInt(st.nextToken()); // 슬라이드 크기
			
			st = new StringTokenizer(bf.readLine());
			Deque<MyNode> deque = new ArrayDeque<MyNode>();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				while(!deque.isEmpty() && deque.getLast().value > num) {
					deque.removeLast();
				}
				deque.addLast(new MyNode(i, num));
				
				while(deque.getFirst().index < i - m) {
					deque.removeFirst();
				}
				sb.append(deque.getFirst().value).append(" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static class MyNode {
		public int index;
		public int value;
		MyNode(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}

