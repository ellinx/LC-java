package ellinx.solutions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 * 
 * Note: N will be in the range [1, 100]. K will be in the range [1, N]. The
 * length of times will be in the range [1, 6000]. All edges times[i] = (u, v,
 * w) will have 1 <= u, v <= N and 1 <= w <= 100.
 * 
 * @author Ellinx
 *
 */
public class NetworkDelayTime {
	public int networkDelayTime(int[][] times, int N, int K) {
		//store (u,v,w) in map
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i=0;i<times.length;i++) {
    		Map<Integer, Integer> destWeightMap;
    		if (map.containsKey(times[i][0])) {
    			destWeightMap = map.get(times[i][0]);
    		} else {
    			destWeightMap = new HashMap<Integer, Integer>();
    			map.put(times[i][0], destWeightMap);
    		}
    		destWeightMap.put(times[i][1], times[i][2]);
        }
        
        Map<Integer, Integer> distance = new HashMap<>();//store nodes whose final path is know
        distance.put(K, 0);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        	@Override
        	public int compare(int[] a, int[] b) {
        		return a[1]-b[1];
        	}
        });
        
        //process Dijkstra's algorithm
        pq.add(new int[]{K,0});
        while (!pq.isEmpty()) {
        	int[] curShortest = pq.poll();
        	//already processed
        	if (distance.containsKey(curShortest[0]) && distance.get(curShortest[0])<curShortest[1])
        		continue;
        	Map<Integer, Integer> outMap = map.get(curShortest[0]);
        	//no edge to other nodes
            if (outMap==null)
        		continue;
        	for (Map.Entry<Integer, Integer> entry:outMap.entrySet()) {
        		if (!distance.containsKey(entry.getKey()) || distance.get(entry.getKey())>curShortest[1]+entry.getValue()) {
        			distance.put(entry.getKey(), curShortest[1]+entry.getValue());
                    pq.add(new int[]{entry.getKey(),curShortest[1]+entry.getValue()});
        		}
        	}
        }
        
        int res = 0;
        for (int dis:distance.values()) {
        	res = Math.max(res, dis);
        }
        return (distance.size()==N)?res:-1;
    }
	
	//test
	public static void main(String[] args) {
		NetworkDelayTime ndt = new NetworkDelayTime();
		int[][] times = {
				{2,1,1},
				{2,3,1},
				{3,4,1}
		};
		int result = ndt.networkDelayTime(times, 4, 2);
		System.out.println(result);
	}
}
