# 동적 프로래밍 - dp
------------------------------------------------------------------------------------------
## [1로 만들기](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Make1_Main_1463_99.java)
- 매커니즘
> 전체 경우를 배열로 둔다음 0~N 까지 경우의 수를 반복  
> 예외 케이스 10은 2로 나누는 것보다 -1뺀후 3으로 나누는 경우가 더 짧다
> > Math.min(dp[n/3], dp[n/2], dp[n-1])
```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] dp = new int[size+1];
    dp[0] = 1000001;
    dp[1] = 0;
    for(int i=2; i<=size; i++){
        int min = dp[0];
        if(i%3 == 0)
            min = Math.min(dp[i/3], min);
        if(i%2==0)
            min = Math.min(dp[i/2], min);
        if(i-1 !=0)
            min = Math.min(min, dp[i-1]);
        dp[i] = min+1;
    }
    System.out.println(dp[size]);
}
```


------------------------------------------------------------------------------------------
## [2친수](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/BinaryNumber_Main_2193.java)
- 매커니즘 
> 점화식
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    dp = new long[N + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= N; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    System.out.println(dp[N]);
    br.close();
}
```


------------------------------------------------------------------------------------------
## [합분해](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/SumUp_Main_2225.java)
- 매커니즘
> 점화식 K-1개 수를 합해 만든 값 + 0 ~ N 까지의 정수를 더한다면 K-1개의 수로 만든 합에 1개의 정수를 더한 것이므로  
> K개의 수를 사용해 만든 어떤합이 될것이다.
- [참고](https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-2225-%EC%9E%90%EB%B0%94-%ED%95%A9%EB%B6%84%ED%95%B4-BOJ-2225-JAVA)
```java
for (int i = 1; i < N + 1; i++) {
    dp[i][1] = 1;
}
for (int i = 1; i < K + 1; i++) {
    dp[1][i] = 1;
}

for (int i = 1; i <= N; i++) {
    for (int j = 2; j <= K; j++) {
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
    }
}
```


------------------------------------------------------------------------------------------
# DP1(연습)


------------------------------------------------------------------------------------------
## [1, 2, 3 더햐기 3](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Plus123_Main_15988.java)
- 매커니즘
> 1, 2, 3 일때 경우의 수 dp[i-3] + dp[i-2] + dp[i-1]
```java
public class Plus123_Main_15988 {
    static long[] dp = new long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp();

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }

    public static void dp() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-3] + dp[i-2]+ dp[i-1])  % 1000000009;
        }
    }
}
```


------------------------------------------------------------------------------------------
## [rgb 거리](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/RGB_Main_1149_99.java)
- 매커니즘
> 문제를 보고 점진적으로 조건에 따른 현재 max 값을 dp에 저장하기
> > 17404 문제 경우, 각 결과 반복하여 dp 구하기
> > > 코드를 변경하기보다 문제에서 유추 필요
```java
// R, G, B 반복
public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] max = new int[n+1][3];
    max[0][0] = max[0][1] = max[0][2] = 0;
    int r, g, b;
    
    for(int i=0; i<n; i++){
        String tmpLine = br.readLine();
        String[] tmpArrLine = tmpLine.split(" ");
        r = Integer.parseInt(tmpArrLine[0]);
        g = Integer.parseInt(tmpArrLine[1]);
        b = Integer.parseInt(tmpArrLine[2]);
        max[i+1][0] = Math.min(max[i][1], max[i][2]) + r;
        max[i+1][1] = Math.min(max[i][0], max[i][2]) + g;
        max[i+1][2] = Math.min(max[i][0], max[i][1]) + b;
    }
    
    System.out.println(Math.min(Math.min(max[n][0], max[n][1]), max[n][2]));
}
```


------------------------------------------------------------------------------------------
# DP1(도전)


------------------------------------------------------------------------------------------
## [rgb 거리2](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/RGB_Main_1149_99.java)
```java
public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new int[n + 1][3];
    dp = new int[n + 1][3];

    // 입력 값 저장
    for(int i = 1 ; i <= n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < 3; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    // k = 0 -> RED, 1 -> GREEN, 2 -> BLUE로 첫 집을 칠하는 경우이다.
    for(int k = 0; k < 3; k++) {
        //RED, GREEN, BLUE로 칠하는 경우 각 색을 제외한 나머지는 INF로 초기화 해준다.
        for(int i = 0 ; i < 3; i++) {
            if(i == k) dp[1][i] = arr[1][i];
            else dp[1][i] = INF;
        }

        // 열의 값인 0 -> RED, 1 -> GREEN, 2 -> BLUE로 칠했을 때의 최소값을 의미한다.
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }

        // 정답인 최솟값을 구하는 부분
        for(int i = 0 ; i < 3; i++)
            if(i != k) answer = Math.min(answer, dp[n][i]);
    }


    bw.write(answer + "\n");

    bw.close();
    br.close();
}
```