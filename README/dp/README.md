# 동적 프로래밍 - dp
## 1로 만들기 (baekjoon.basic1.dp.Main_1149)
- 매커니즘
> 전체 경우를 배열로 둔다음 0~N 까지 경우의 수를 반복  
> 예외 케이스 10은 2로 나누는 것보다 -1뺀후 3으로 나누는 경우가 더 짧다
> > Math.min(dp[n/3], dp[n/2], dp[n-1])
-----------
## rgb 거리 (baekjoon.basic1.dp.Main_1149/Main_17404)
- 매커니즘
> 문제를 보고 점진적으로 조건에 따른 현재 max 값을 dp에 저장하기
> > 17404 문제 경우, 각 결과 반복하여 dp 구하기
> > > 코드를 변경하기보다 문제에서 유추 필요
```java
// R, G, B 반복
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == j) dp[1][j] = arr[1][i];
        else dp[1][j] = 1_000_001;
    }

    for (int j = 2; j <= n; j++) {
        dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
        dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
        dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
    }

    for (int j = 0; j < 3; j++) {
        if(i != j) answer = Math.min(answer, dp[n][j]);
    }
}
```