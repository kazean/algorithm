package baekjoon.basic2.bruteforce;
/**
 *
 */
/*
5457
3
6 7 8
> 6
5 4 5 5 + +


// 현재 예외
80000
2
8 9
> 2228
500000
8
0 2 3 4 6 7 8 9
> 11117
 */

import java.io.*;
import java.util.*;

public class Remote_Main_1107 {
    static int N;
    static int[] destChannel;
    static HashSet<Integer> fails = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();
        N = Integer.parseInt(strN);
        destChannel = Arrays.stream(strN.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int M = Integer.parseInt(br.readLine());
        int curChannel = 100;
        int resultCnt = Integer.MAX_VALUE;
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                fails.add(Integer.valueOf(st.nextToken()));
            }
        }
        // 그냥 +, - 버튼 눌러서 찾는 경우
        int tmpCnt = 0;
        tmpCnt += searchPlusMinus(curChannel);
        resultCnt = Math.min(resultCnt, tmpCnt);

        // 목표하는 채널의 버튼을 최대값으로 누른다 (+) 경우
        tmpCnt = 0;
        curChannel = 0;
        boolean nextNumFlag = true;
        for(int i = 0; i < destChannel.length; i++) {
            tmpCnt++;
            int tmp = destChannel[i];
            // 이전 값이 목표 채널보다 다르다면 tmp 값을 9부터 탐색
            if(!nextNumFlag) tmp = 9;

            tmp = findNum(tmp, -1);
            // 만들 수 없는 조합인 경우
            if (tmp == -1) {
                tmpCnt = Integer.MAX_VALUE;
                curChannel = Integer.MAX_VALUE;
                break;
            }

            // 다음 값이 목표값보다 크면 현재 값을 줄인다.
            if (i + 1 < destChannel.length) {
                int nextNum = destChannel[i+1];
                nextNum = findNum(nextNum, -1);
                int curTmpNum = tmp * 10 + nextNum;
                int destTmpNum = destChannel[i] * 10 + destChannel[i + 1];
                if (destTmpNum != 0 && curTmpNum > destTmpNum) {
                    tmp = destChannel[i] - 1;
                    tmp = findNum(tmp, -1);
                }
            }
            if (tmp != destChannel[i]) {
                nextNumFlag = false;
            }
            int plusNum = tmp * ((int) Math.pow(10, destChannel.length - (i + 1)));
            curChannel += plusNum;

        }
        if (curChannel <= N) {
            tmpCnt += searchPlusMinus(curChannel);
            resultCnt = Math.min(resultCnt, tmpCnt);
        }

        // 목표하는 채널의 버튼을 최대값으로 누른다 (-) 경우
        tmpCnt = 0;
        curChannel = 0;
        nextNumFlag = true;
        for(int i = 0; i < destChannel.length; i++) {
            tmpCnt++;
            int tmp = destChannel[i];
            // 이전 값이 목표 채널보다 다르다면 tmp 값을 9부터 탐색
            if(!nextNumFlag) tmp = 0;

            tmp = findNum(tmp, 1);
            // 만들 수 없는 조합인 경우
            if (tmp == 10) {
                tmpCnt = Integer.MAX_VALUE;
                curChannel = Integer.MIN_VALUE;
                break;
            }

            // 다음 값이 목표값보다 크면 현재 값을 줄인다.
            if (i + 1 < destChannel.length) {
                int nextNum = destChannel[i+1];
                nextNum = findNum(nextNum, 1);
                int curTmpNum = tmp * 10 + nextNum;
                int destTmpNum = destChannel[i] * 10 + destChannel[i + 1];
                if (destTmpNum != 0  && curTmpNum < destTmpNum) {
                    tmp = destChannel[i] + 1;
                    tmp = findNum(tmp, 1);
                }
            }
            if (tmp != destChannel[i]) {
                nextNumFlag = false;
            }
            int plusNum = tmp * ((int) Math.pow(10, destChannel.length - (i + 1)));
            curChannel += plusNum;

        }
        if (curChannel >= N) {
            tmpCnt += searchPlusMinus(curChannel);
            resultCnt = Math.min(resultCnt, tmpCnt);
        }

        System.out.println(resultCnt);
    }

    public static int findNum(int num, int plus) {
        while (fails.contains(num)) {
            num += plus;
            if (num == -1) {
                return -1;
            } else if (num == 10) {
                return 10;
            }
        }
        return num;
    }

    public static int searchPlusMinus(int curChannel) {
        int tmp = 0;
        if (N >= curChannel) {
            while (!(N == curChannel)) {
                curChannel++;
                tmp++;
            }
        } else {
            while (!(N == curChannel)) {
                curChannel--;
                tmp++;
            }
        }
        return tmp;
    }
}
