package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
dia, iron, stone
피로도 다   철   돌
다곡  1   1   1
철곡  5   1   1
돌곡  25  5   1
> 곡갱이 5광물
> 광물은 순서대로 캘 수 있음
>> 곡갱이 다소모하거나, 광물 다캘시 종료
picks	minerals	result
{1, 3, 2}	{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}	12
{0, 1, 1}	{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}	50
 */
public class Solution172927 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int pickTotalCnt = Arrays.stream(picks).sum();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node tmp = new Node(0, new int[3]);

        if (minerals.length > pickTotalCnt * 5) {
            minerals = Arrays.stream(minerals).limit(pickTotalCnt*5).toArray(String[]::new);
        }

        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];
            if ("diamond".equals(mineral)) {
                tmp.cost += 25;
                tmp.picks[0] += 1;
                tmp.picks[1] += 5;
                tmp.picks[2] += 25;
            } else if ("iron".equals(mineral)) {
                tmp.cost += 5;
                tmp.picks[0] += 1;
                tmp.picks[1] += 1;
                tmp.picks[2] += 5;
            } else {
                tmp.cost += 1;
                tmp.picks[0] += 1;
                tmp.picks[1] += 1;
                tmp.picks[2] += 1;
            }
            if ((i + 1) % 5 == 0 || i == minerals.length-1) {
                pq.add(tmp);
                tmp = new Node(0, new int[3]);
            }
        }


        int diamondPick = picks[0];
        int ironPick = picks[1];
        int stonePick = picks[2];

        while (!pq.isEmpty()) {
            if (pickTotalCnt == 0) {
                break;
            }
            Node n = pq.poll();

            if (diamondPick != 0) {
                pickTotalCnt--;
                diamondPick--;
                answer += n.picks[0];
                continue;
            }
            if (ironPick != 0) {
                pickTotalCnt--;
                ironPick--;
                answer += n.picks[1];
                continue;
            }
            if (stonePick != 0) {
                pickTotalCnt--;
                stonePick--;
                answer += n.picks[2];
                continue;
            }
        }

        return answer;
    }

    static class Node implements Comparable<Node>{
        int cost;
        int[] picks;

        public Node(int cost, int[] picks) {
            this.cost = cost;
            this.picks = picks;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.cost, this.cost);
        }
    }


}
