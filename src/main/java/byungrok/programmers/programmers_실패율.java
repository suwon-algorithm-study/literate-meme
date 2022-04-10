package byungrok.programmers;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class programmers_실패율 {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(solution(N, stages));
	}
	public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        int[] cleared = new int[N+2];
        for(int n : stages) {
        	cleared[n]++;
        }
        
        answer = new int[N];
        int remain = stages.length;
        List<double[]> list = new ArrayList<double[]>();
        for(int i=1; i<=N; i++) {
        	int realIdx = i-1;
        	if(remain == 0) list.add(new double[] {0, i});
        	else list.add(new double[] {(double)cleared[i]/remain, i});
        	remain -= cleared[i];
        }
        
        list.sort(new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]>o2[1] ? 1 : -1;
				}
				return o2[0]>o1[0] ? 1 : -1;
			}
		});
        
        int idx= 0;
        for(double[] item : list) answer[idx++]=(int) item[1];
        
        return answer;
    }
}

