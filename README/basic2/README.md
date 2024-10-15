# 알고리즘 기초 2/2
- [BaekJoon - 알고리즘 기초(2/2)](https://code.plus/course/42)
- [1. 브루트포스(Brute Force)](#1-브루트-포스)
> 브루트포스, N과M, 순열, 재귀, 비트마스크
- [2. 그래프](#2-그래프)
> DFS와 BFS까지, 연결요소
- [3. BFS](#3-bfs)
- [4. Tree](#4-tree)

---------------------------------------------------------------------------------------
## 1. 브루트 포스
------------------------------------------------------------------------------------------
조합 가능한 모든 문자열을 하나씩 대입해보는 방식(전체탐색)
- [일곱 난쟁이](#일곱-난쟁이---2309)
- [N과 M]()
- [순열]()
- [재귀]()
- [비트마스크]()

---------------------------------------------------------------------------------------
### [일곱 난쟁이 - 2309](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/Dwarf_Main_2309.java)
- Brute Force - Basic
- 9명의 난쟁이중 7난쟁이 찾기 7명의 합의 키가 100 인경우
- 입/출력
> - 입력
> > - 9줄의 각 난쟁이들키
> - 출력
> > 7명의 난쟁이 키의 합이 100이 되는 난쟁이 들키
```txt
20
7
23
19
10
15
25
8
13
>
7
8
10
13
19
20
23
```
- 매커니즘
> - DFS
> > 해당 배열을 전체 탐색, 재귀방식 depth == 결과값 return
> > - code cf
> > > 매개변수로 전달시 값 유지
> - 이중 for문
> > 전체 9명의 키를 더한 다음 2명을 제외 했을때 합이 100이 되는 경우
- code - DFS
```java
static int[] fields = new int[9];
static boolean[] visited = new boolean[9];
static boolean resultFlag = false;

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 9; i++) {
        fields[i] = Integer.parseInt(br.readLine());
    }

    dfs(0, 0, 0);

}

public static void dfs(int index, int depth, int sum) {
    if (resultFlag) {
        return;
    }
    if (depth == 7 && sum == 100) {
        resultFlag = true;
        int[] results = new int[7];
        int resultIndex = 0;
        for (int i = 0; i < 9; i++) {
            if (visited[i]) {
                results[resultIndex++] = fields[i];
            }
        }
        Arrays.sort(results);
        for (int i = 0; i < 7; i++) {
            System.out.println(results[i]);
        }
        return;
    }

    for (int i = index; i < 9; i++) {
        if (!visited[i] && depth < 7 && sum < 100) {
            visited[i] = true;
            dfs(index + 1, depth + 1, sum + fields[i]);
            visited[i] = false;
        }
    }
}
```
- code2 - Impl
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr = new int[9];
    int sum = 0;

    for (int i = 0; i < 9; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr[i] = n;
        sum += n;
    }

    Arrays.sort(arr);

    for (int i = 0; i < 9; i++) {
        for (int j = i + 1; j < 9; j++) {
            if(sum - (arr[i] + arr[j]) == 100) {
                for (int z = 0; z < 9; z++) {
                    if(i == z || j == z) continue;
                    System.out.println(arr[z]);
                }
                return;
            }
        }
    }
}
```

------------------------------------------------------------------------------------------
### [사탕게임 - 3085](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/CandyGame_Main_3085_99.java)
- N×N크기에 사탕을 채워 놓는다
- 사탕의 색이 다른 인접한 두 칸을 고른다, 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다
- 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
> 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
- 입/출력
> - 입력
> > - 첫째 줄 크기 N (3 ≤ N ≤ 50)
> > - 다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
> > - 사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.
> - 출력
> > 먹을 수 있는 사탕의 최대 개수
```txt
3
CCP
CCP
PPC
> 3
4
PPPP
CYZY
CCPY
PPCC
> 4
5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
> 4
3
ZCY
ZCP
PYZ
> 2
```
- 매커니즘
> - 인접한(행 혹은 열 다 포함) 사탕끼리 색을 바꿔준다.
> - 가장 긴 수열을 찾아준다.
> - 바꿔준 사탕의 색을 돌려준다.
- code 
```java
public class CandyGame_Main_3085_99 {
    static int max = 1;
    static int N;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        // 행을 기준으로 오른쪽 색과 변경
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j + 1, i, j);
            }
        }
        // 열을 기준으로 아래쪽 색과 변경
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                search();
                swap(i + 1, j, i, j);
            }
        }
        System.out.println(max);
        br.close();
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static void search() {
        // 행에서 긴 수열 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
        // 열에서 긴 수열 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
    }
}
```
------------------------------------------------------------------------------------------
### [날짜계산 - 1476](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/CandyGame_Main_3085_99.java)
- E(지구), S(태양), M(달) 입력  (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
- 해당 수는 년도를 의미, 1년이 지날때마다 +1, 숫자를 넘어가면 1
> 실제 년도 구하기
- 입/출력
> - 입력
> > - E(지구), S(태양), M(달) 입력  (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
> - 출력
> > 실제 년도 구하기
```txt
1 16 16
> 16
1 1 1
> 1
1 2 3
> 5266
```
- 매커니즘
> - 해당 수를 증가시키면서 실제 년도 구하는 로직 전체탐색
- code 
```java
public class DataCal_Main_1476 {
    static int E, S, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        E = S = M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int result = 0;
        int tmpE, tmpS, tmpM;
        tmpE = tmpS = tmpM = 0;

        while (!(tmpE == E && tmpS == S && tmpM == M)) {
            tmpE+=1;
            tmpS+=1;
            tmpM+=1;
            if (tmpE == 16) {
                tmpE = 1;
            }
            if (tmpS == 29) {
                tmpS = 1;
            }
            if (tmpM == 20) {
                tmpM = 1;
            }
            result++;
        }

        System.out.println(result);
    }
}
```
------------------------------------------------------------------------------------------
### [리모컨 - 1107](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/Remote_Main_1107_99.java)
- TV 채널 0~9버튼, +. - 버튼, 현재 채널: 100, 이동하려는 채널: N
- 고장난 버튼 0 ~ 9중 M개
> 이동하기 위한 최소 버튼 개수 구하기
- 입/출력
> - 입력
> > - 첫째 줄 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)
> > - 둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)
> - 출력
> > 이동하기 위한 최소 버튼 개수 구하기
```txt
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
```
- 매커니즘
> - 0 ~ 500,000번 채널 전체 탐색
- code 
```java
public class Remote_Main_1107_99 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int size = sc.nextInt();

        //0-9 까지의 수 중 고장난 채널이 있는지 확인하기 위한 배열
        boolean[] broken = new boolean[10];
        for (int i = 0; i < size; i++) {
            broken[sc.nextInt()] = true;
        }
        //N-100을 RESULT의 초기값으로 주는 이유는 현재 채널이 100부터 시작하기 때문이다.
        int result = Math.abs(N - 100);

        //그냥 0부터 999999까지 전부 확인한다.
        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);

            boolean isBreak = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    //고장난 버튼을 눌러야 하면 멈춘다.
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                //버튼을 누르는 횟수 중 가장 적은 횟수를 result에 담는다.
                int min = Math.abs(N - i) + num.length();
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }

}
```
------------------------------------------------------------------------------------------
### [테트로미노 - 14500](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/Tetromino_Main_14500_99.java)
- 입/출력
> - 입력
> > - 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
> > - 테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.
> - 출력
> > 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력
```txt
5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1
> 19

4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
> 20

4 10
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
> 7
```
- 매커니즘
> - 테트로미노 만들기 & DFS 전체탐색
- code 
```java
public class Tetromino_Main_14500_99 {
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int m;

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전체 탐색 (dfs)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visit[i][j] = true;
                solve(i,j,arr[i][j],1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void solve(int row, int col, int sum, int count) {

        // 테트로미노 완성 시 수들의 합 계산
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        for(int i = 0; i < 4; i++) {
            int curRow = row + dx[i];
            int curCol = col + dy[i];

            // 범위 벗어나면 예외 처리
            if(curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                continue;
            }

            // 아직 방문하지 않은 곳이라면
            if(!visit[curRow][curCol]) {

                // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
                if(count == 2) {
                    visit[curRow][curCol] = true;
                    solve(row, col, sum + arr[curRow][curCol], count + 1);
                    visit[curRow][curCol] = false;
                }

                visit[curRow][curCol] = true;
                solve(curRow, curCol, sum + arr[curRow][curCol], count + 1);
                visit[curRow][curCol] = false;
            }
        }
    }
}
```
------------------------------------------------------------------------------------------
### [카잉달력 - 6064](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/Caring_Main_6064_99.java)
- M과 N보다 작거나 같은 자연수 x, y과 주어질 때 몇번째 해인지 구하기
```
(x <= M) x` = x + 1
(x > M) x` = 1
y도 위와 같음
```
- 매커니즘
> - 규칙성 찾기
> 1. x값은 M값이 더 해질때는 그대로, y만 변함
> > 1:(1,1) 11: (1, 11)
> 2. y값은 N값이 더해 질때는 그대로 x 값만 변함
> > 1:(1,1) 13: (3, 1)
> 3. 최대값은 M과 N의 최소공배수
> 4. n * M 값에서 + (x - y)을 더하고 % N 값이 0인 값 구하기
> > 예시
```txt
M: 10, N: 12 최대해 60
x = 3, y = 9
> x: 3, 13, 23, 33... (x + 10n) 번째해
> y: (x + 10n - y) % N 인것
```

- 입/출력
> - 입/출력
```txt
3
10 12 3 9
10 12 7 2
13 11 5 6
>33 -1 83
```
- code 
```java
public class Caring_Main_6064_99 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M, N, x, y;
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int answer = -1;
            int n = 0;
            int lcm = M * N / gcd(M, N);
            while (n * M < lcm) {
                if ((n * M + x - y) % N == 0) {
                    answer = n * M + x;
                    break;
                }
                n++;
            }
            System.out.println(answer);
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
```
------------------------------------------------------------------------------------------
### [N과 M - 2309](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/NM_Main_15649_99.java)
- Brute Force - N과M
- 정수 N, M / 길이 M / 1 ~ N 까지의 수열 사전순 출력
> - 입력/출력
```
4 2
>
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
```
- 매커니즘
> - DFS
> > 해당 배열을 전체 탐색, 재귀방식 depth == 결과값 return
- code
```java
public class NM_Main_15649_99 {
    static char[] answer;
    static boolean[] c;
    static List<char[]> per = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n=Integer.parseInt(st[0]), m=Integer.parseInt(st[1]);

        answer = new char[2 * m];
        for (int i=1;i<m;i++) answer[2*i-1] = ' ';
        answer[2*m -1] = '\n';
        c = new boolean[n+1];

        permutations(n,m,0);
        System.out.println(sb);
    }

    public static void permutations(int n, int m, int depth) {
        if (m==depth) {sb.append(answer); return;}

        for (int i=1; i<=n; i++) {
            if (!c[i]) {
                c[i] = true;
                answer[2*depth] = (char) (i+'0');
                permutations(n,m,depth+1);
                c[i] = false;
            }
        }
    }
}
```

------------------------------------------------------------------------------------------
### [!다음 순열 - 2309](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/NextPermutation_Main_10972_99_2.java)
- Brute Force - 순열
- 1 ~ N 까지의 순열 입력된 순열 다음 차례 순열
> - 입력/출력
```
4
1 2 3 4
> 1 2 4 3
5
5 4 3 2 1
> -1
7
7 2 3 6 5 4 1
> 7 2 4 1 3 5 6
```
- 매커니즘
> - 1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다.
> - 2. j >= i 이면서 A[j] > A[i-1] 을 만족하는 가장 큰 j를 찾는다.
> - 3. A[i-1]과 A[j] 를 swap 한다.
> - 4. A[i] 부터 순열을 뒤집는다.
> >  - 조합론
- code
```java
public class NextPermutation_Main_10972_99_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if(next_Permutation(a)) {
            for(int val : a) {
                sb.append(val).append(" ");
            }
        }else {
            sb.append("-1");
        }

        System.out.println(sb);
    }

    public static boolean next_Permutation(int a[]) {
        int i = a.length-1;

        //1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다.
        while(i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        //i의 위치가 0이면 내림차순(마지막 순열)
        if(i<=0) return false;

        int j = a.length - 1;

        //2. j >= i 이면서 A[j] > A[i-1] 을 만족하는 가장 큰 j를 찾는다.
        while(a[i-1] >= a[j]) {
            j -= 1;
        }

        //3. A[i-1]과 A[j] 를 swap 한다.
        int temp = a[j];
        a[j] = a[i-1];
        a[i-1] = temp;

        j = a.length-1;


        //4. A[i] 부터 순열을 뒤집는다.
        while(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }

}
```

------------------------------------------------------------------------------------------
### [1, 2, 3 더하기 - 9095](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/OneTwoThreePlus_Main_9095.java)
- Brute Force - 재귀
- dp와 같은 문제
- 매커니즘
- dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

------------------------------------------------------------------------------------------
### [!집합 - 11723](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bruteforce/Set_Main_11723_99.java)
- Brute Force - Bit Mask
- 공집합 S, 연산을 수행하는 프로그램
> - 입력/출력
```
26
add 1
add 2... 생략
```
- [매커니즘 - 비트마스크](https://myeongju00.tistory.com/30)
> - 공집합, 꽉찬집합
> > int A = 0;  
> > A  = (1 << 10) -1; // 9개
> - 원소 추가
> > A |= (A << k)
> - 원소 삭제
> > A &= ~(A << k)
> - 원소 포함여부 확인
> > if((A & (1 << k)) == (1 << k))
> - 원소의 토글
> > A ^= (1 << k);
> - 두집합에 대해 연산하기
> > 
```
A | B    // A와 B의 합집합
A & B    // A와 B의 교집합
A & (~B) // A에서 B를 뺀 차집합
A ^ B    // A와 B중 하나에만 포함된 원소들의 집합
```
- code
```java
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();
  int S = 0;
  int M = Integer.parseInt(br.readLine());
  StringTokenizer st;
  while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      String str = st.nextToken();

      if(str.equals("all")) S = (1 << 21) - 1;
      else if(str.equals("empty")) S = 0;
      else {
          int num = Integer.parseInt(st.nextToken());
          if(str.equals("add"))
              S |= (1 << num);
          else if(str.equals("remove"))
              S &= ~(1 << num);
          else if(str.equals("check"))
              sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
          else if(str.equals("toggle"))
              S ^= (1 << num);
      }
  }
  System.out.println(sb);
}
```

------------------------------------------------------------------------------------------







---------------------------------------------------------------------------------------
## 2. 그래프
- [DFS와 BFS](#dfs와-bfs---1260)
- [연결 요소까지](#연결-요소의-개수---11724)

------------------------------------------------------------------------------------------
### [DFS와 BFS - 1260](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/graph/BfsDFS_Main_1260.java)
- BFS, DFS
- 정점 탐색 및 순서 출력하기
> - 입력: 정점N 간선M 시작정점V
> - 출력: DFS, BFS
```
4 5 1
1 2
1 3
1 4
2 4
3 4
>
1 2 4 3
1 2 3 4
```
- 매커니즘
> - DFS
> - BFS
- code
```java
public class BfsDFS_Main_1260 {
    public static boolean[] visited;
    public static boolean[][] point;
    public static int start;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int pointCnt = sc.nextInt();
        int visitedCnt = sc.nextInt();
        start = sc.nextInt();
        sc.nextLine();

        visited = new boolean[pointCnt+1];
        point = new boolean[pointCnt+1][pointCnt+1];

        for(int i = 0; i<visitedCnt; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine();
            point[s][e] = true;
            point[e][s] = true;
        }
        dfs(start);
        visited = new boolean[pointCnt+1];
        System.out.println();
        bfs(start);

        sc.close();

    }

    public static void bfs(int start){
        LinkedList<Integer> q = new LinkedList<>();
        boolean flag = false;
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int temp = q.pop();
            System.out.print(temp + " ");

            for(int i=1; i<point.length; i++){
                if(point[temp][i] && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");

        for(int i=1; i<point.length; i++){
            if(point[start][i] && !visited[i]){
                dfs(i);
            }
        }
    }
}
```

------------------------------------------------------------------------------------------
### [연결 요소의 개수 - 11724](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/graph/ConnectedNode_Main_11724.java)
- BFS
- 연결된 간선의 수
> - 입력: 정점N 간선M
> - 출력: 간선의 수
```
6 5
1 2
2 5
5 1
3 4
4 6
>
2
```
- 매커니즘
> - BFS
- code
```java
public class ConnectedNode_Main_11724 {
    static int N, M;
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> numSet = new HashSet<>();
        boolean flag = false;
        q.add(s);
        numSet.add(s);

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            List<Integer> nodeList = graph.get(poll);

            for (int i = 0; i < nodeList.size(); i++) {
                Integer node = nodeList.get(i);

                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                    numSet.add(node);
                }
            }
        }
    }
}
```

---------------------------------------------------------------------------------------








---------------------------------------------------------------------------------------
## 3. BFS
- [BFS](#숨바꼭질---1697)

---------------------------------------------------------------------------------------
### [숨바꼭질 - 1697](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/bfs/HideNSeek_Main_1697.java)
- 동생 찾기, 이동 +-1/순간이동 2*X
> - 입력: 현재위치N 동생위치K
> - 출력: 동생찾는 가장빠른 시간
```
5 17
> 4
```
- code
```java
class Count{
    int p;
    int cnt;
    public Count(int p, int cnt) {
        super();
        this.p = p;
        this.cnt = cnt;
    }
}

public class HideNSeek_Main_1697 {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        bfs(k, new Count(n, 0));
    }

    public static void bfs(int k, Count c){
        Queue<Count> q = new LinkedList<Count>();
        q.add(c);
        visited[c.p] = true;

        while(!q.isEmpty()){
            Count tmp = q.poll();
            if(tmp.p == k){
                System.out.println(tmp.cnt);
                break;
            }

            if(tmp.p*2 < visited.length && !visited[tmp.p*2]){
                q.add(new Count(tmp.p*2, tmp.cnt+1));
                visited[tmp.p*2]=true;
            }
            if(tmp.p+1 < visited.length &&!visited[tmp.p+1]){
                q.add(new Count(tmp.p+1, tmp.cnt+1));
                visited[tmp.p+1] = true;
            }
            if(tmp.p-1 >=0 &&!visited[tmp.p-1]){
                q.add(new Count(tmp.p-1, tmp.cnt+1));
                visited[tmp.p-1] = true;
            }
        }
    }

}
```

------------------------------------------------------------------------------------------








---------------------------------------------------------------------------------------
## 4. Tree
- [트리 순회](#트리순회---1991)

---------------------------------------------------------------------------------------
### [트리순회 - 1991](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic2/tree/TreeCircuit_Main_1991_99.java)
- 전위, 중위, 후위, root: 'A'
> - 입력: 노드개수 / 현재 왼쪽자식 오른쪽자식
> - 출력: 전위, 중위, 후위
```
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
>
ABDCEFG
DBAECFG
DBEGFCA
```
- 매커니즘
> - Node(char value, Node left, Node right)
> > insertNode(Node temp, char root, char left, char right): left, right 재귀 방식 찾기
```
 * 트리 순회 - 재귀 방식으로 search
 * 전위 : 루트 > 왼쪽 > 오른쪽
 * 중위 : 왼쪽 > 루트 > 오른쪽
 * 후위 : 왼쪽 > 오른쪽 > 루트

public static void preOrder(Node node) {
	if(node ==null) return;
	System.out.print(node.value);
	preOrder(node.left);
	preOrder(node.right);
}

public static void inOrder(Node node) {
	if(node ==null) return;
	inOrder(node.left);
	System.out.print(node.value);
	inOrder(node.right);
}

public static void postOrder(Node node) {
	if(node ==null) return;
	postOrder(node.left);
	postOrder(node.right);
	System.out.print(node.value);
}
```
- code
```java
public class TreeCircuit_Main_1991_99 {

    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root,left,right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();



    }


    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node temp, char root, char left, char right) {


        if (temp.value == root) {
            temp.left = (left == '.' ? null : new Node(left,null,null));
            temp.right = (right == '.' ? null : new Node(right,null,null));
        }
        else {
            if(temp.left != null) insertNode(temp.left, root, left, right);
            if(temp.right != null) insertNode(temp.right, root, left, right);
        }
    }

    public static void preOrder(Node node) {
        if(node ==null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node ==null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

}
```

------------------------------------------------------------------------------------------