package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2026/02/09
 * @author weiss
 * 문제
 * N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
 * 
 * N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
 * 
 * 수의 위치가 다르면 값이 같아도 다른 수이다.
 * 
 * 입력
 * 첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)
 * 
 * 출력
 * 좋은 수의 개수를 첫 번째 줄에 출력한다.
 * 
 */
public class P1253 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			
			int x = 0;
			int a = 0;
			int b = 0;
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				x = nums[i]; // 비교할 수
				a = 0;
				b = n - 1;
				while(a < b) {
					if(nums[a] + nums[b] == x) {
						if(a == i) {
							a++;
						} if (b == i) {
							b--;
						} else {
							cnt++;
							break;
						}
					} else if(nums[a] + nums[b] < x) {
						a++;
					} else {
						b--;
					}
				}
			}
			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
