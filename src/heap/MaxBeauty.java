package heap;

import java.util.Arrays;
import java.util.Comparator;

public class MaxBeauty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] items = {{193,732},{781,962},{864,954},{749,627},{136,746},{478,548},{640,908},{210,799},{567,715},{914,388},{487,853},{533,554},{247,919},{958,150},{193,523},{176,656},{395,469},{763,821},{542,946},{701,676}};
		int[] queries = {885,1445,1580,1309,205,1788,1214,1404,572,1170,989,265,153,151,1479,1180,875,276,1584};
		System.out.print(Arrays.toString(solve(items,queries)));
		
	}

	public static int[] solve(int[][] items, int queries[]) {
		Arrays.sort(items, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] < o2[0])
					return -1;
				else if (o1[0] == o2[0])
					return o1[1] >= o2[1] ? 1 : -1;
				else if (o1[0] > o2[0])
					return 1;
				return 0;
			}
		});
		for(int[] item:items) {
			System.out.print(Arrays.toString(item));
		}
		int ans[] = new int[queries.length];
		int c = 0;
		for (int query : queries) {
			ans[c] = search(items, query);
			c++;
		}
		return ans;
	}

	public static int search(int[][] items, int k) {
		int start = 0;
		int end = items.length - 1;
		int res = 0;
		while (start <= end) {
			int mid = start + ((end - start) / 2);

			if (items[mid][0] <= k) {
				res = Math.max(res,items[mid][1]);
				start = mid + 1;
			} else if (items[mid][0] > k) {
				end = mid - 1;
			}
		}
		return res;
	}

}
