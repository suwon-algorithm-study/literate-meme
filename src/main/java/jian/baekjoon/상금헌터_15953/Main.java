package jian.baekjoon.상금헌터_15953;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	/* 제1회 코드 페스티벌 정보 */
	int[] rank1Info  = new int[]{1, 2, 3, 4, 5, 6};
	int[] prize1Info = new int[]{500, 300, 200, 50, 30, 10};

	/* 제2회 코드 페스티벌 정보 */
	int[] rank2Info  = new int[]{1, 2, 4, 8, 16};
	int[] prize2Info = new int[]{512, 256, 128, 64, 32};

	public static void main(String[] args) throws IOException {
		Main solution = new Main();
		solution.solve();
	}

	public void solve() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 등수 가정을 돌릴 횟수
			int t = Integer.parseInt(st.nextToken());

			for (int i = 0; i < t; i++) {
				st = new StringTokenizer(br.readLine());

				int rank1 = Integer.valueOf(st.nextToken());
				int rank2 = Integer.valueOf(st.nextToken());

				int result = calc(rank1, rank1Info, prize1Info)
						+ calc(rank2, rank2Info, prize2Info);

				bw.append(result + System.lineSeparator()); // '/r/n'과 같은 역할
			}

			bw.flush();

			bw.close();
			br.close();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int calc(int p, int[] rankInfo, int[] prizeInfo) {
		// 총 상금
		int totPrize  = 0;
		// 상금을 받을 수 있는 인원
		int totPerson = Arrays.stream(rankInfo).sum();

		if (p > 0 && p <= totPerson) {
			int count = 0;

			for (int i = 0; i < rankInfo.length; i++) {
				count += rankInfo[i];

				if (p <= count) {
					totPrize += prizeInfo[i];

					return totPrize * 10000;
				}
			}
		}
		return totPrize * 10000;
	}
}
