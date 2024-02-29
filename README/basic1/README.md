# 알고리즘 기초 1/2
- [BaekJoon - 알고리즘 기초(1/2)](https://code.plus/course/41)
- [1. 자료구조](#-1-자료구조)
- [2. 수학](#-2-수학)
- [3. DP](#)

------------------------------------------------------------------------------------------
## 1. 자료구조
------------------------------------------------------------------------------------------
### [스택 - 10828](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_Main_10828.java)
```java
Stack<Integer> stack = new Stack<>();
```
- class
```java
public
class Stack<E> extends Vector<E> {
    public E push(E item){}
    public synchronized E pop(){}
    public synchronized E peek(){}
    public boolean empty(){}
    public synchronized int search(Object o){}
}
```
------------------------------------------------------------------------------------------
### [큐 - 10845](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Queue_Main_10845.java)
```java
LinkedList<Integer> q = new LinkedList<>();
```
- class
```java
public interface Queue<E> extends Collection<E> {
    boolean add(E e);
    boolean offer(E e);
    E remove();
    E poll();
    E peek();
}

public class LinkedList<E>
        extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable {
    
}
```
> LinkedList 로 구현
------------------------------------------------------------------------------------------
### [덱/데크 - 10845](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Deque_Main_10866.java)
```java
ArraysDeque<T> deque = new ArraysDeque<>();
Deque<T> dq = new LinkedList<>();
```
------------------------------------------------------------------------------------------
### [스택 - 에디터 - 1406](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses5_Main_1406.java)
- 시간초과
> ListIterator
```java
public interface ListIterator<E> extends Iterator<E> {
    boolean hasNext();
    E next();
    boolean hasPrevious();
    E previous();
    int nextIndex();
    int previousIndex();
    void remove();
    void set(E e);
    void add(E e);
}
```
### [스택 - 단어뒤집기 - 9093](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses1_Main_9093.java)
### [스택 - 괄호 - 9012](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses2_Main_9012.java)
### [큐 - 요세푸스 문제 - 1158](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Queue_uses_Main_1158.java)
------------------------------------------------------------------------------------------
## 자료구조 1 (연습)
### [스택 - 단어뒤집기2 - 17413](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses3_Main_17413.java)
### [스택 - 쇠막대기 - 10799](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses4_Main_10799.java)
------------------------------------------------------------------------------------------
## 자료구조 1 (참고)




------------------------------------------------------------------------------------------
## 2. 수학
------------------------------------------------------------------------------------------
## [나머지](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Divide_Main_10430.java)
------------------------------------------------------------------------------------------
### [최대공약수(GCD, Greatest Common Divisor), 최소공배수(LCM) - 2609](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/GcdLcd_Main_2609_99.java)
#### 최대공약수 - 유클리트 호제법
두 자연수가 공통으로 갖는 약수들 중에서 가증 큰 값 두 자연수들의 배수들 중에서 공통된 가장 작은수
- [참고](https://st-lab.tistory.com/154)
- 매커니즘
> 두 수 a, b 이고 r = a mod b  
이때 r은(0 <= r <= b)이고 a >= b이다.
> > 이때 a 와 b의 최대공약수를 (a, b)라고 할때 (a, b)의 최대 공약수는 (b, r)의 최대공약수 와 같다
> > 즉 GCD(a, b) = GCD(b, r) -> `재귀 반복` r = 0 일때까지
```java
// 반복문 방식
int gcd(int a, int b) {
	
	while(b != 0) {
		int r = a % b;
		a = b;
		b = r;
	}
	return a;
}
 
// 재귀 방식
int gcd(int a, int b) {
	if(b == 0) return a;
	return gcd(b, a % b);
}
```
#### 최소 공약수
두 자연수들의 배수들 중에서 공통된 가장 작은 수를 말한다.
```java
// 최소공배수 : Least Common mulitple
int lcm(int a, int b) {
	return a * b / gcd(a, b);
}
```
> 최소공배수 = 두 자연수의 곱 / 최대공약수  
a * b / gcd(a, b)
------------------------------------------------------------------------------------------
### [소수 - 에라토스테네스의 체 - 1929](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Prime_Main_1929.java)
- [참고](https://firework-ham.tistory.com/8)
- 매커니즘
> 소수가 되는 수의 배수를 지우면 남은 건은 소수만 된다
```java
public static void prime() {
    prime[0] = prime[1] = true;

    for (int i = 0; i <= Math.sqrt(10001); i++) {
        if (!prime[i]) {
            for (int j = i * i; j <= 10000; j += i) {
                prime[j] = true;
            }
        }
    }
}
```
------------------------------------------------------------------------------------------
### [골드바흐의 추측 - 에라토스테네스의 체 - 6588](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Prime_Goldbach_Main_6588.java)
------------------------------------------------------------------------------------------
### [팩토리얼 - 10872](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Factorial_Main_10872.java)
------------------------------------------------------------------------------------------
### [조합 0의 개수 - 팩토리얼 끝 자리 0의 수 - 2004](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/ZeroCount_Main_2004.java)
- [참고](https://st-lab.tistory.com/165)
- 매커니즘
> 끝자리 0은 2, 5가 곱해져있을때다, 팩토리얼을 보면 5의 배수마다 5의 제곱의 지수 값이 1개씩 증가, 25는 카운트가 2개 증가
> > 즉 기본적으로 5의 개수에 따라 값이 변화한다고 보면 된다. 단순히 5로 나누면서 누적합
```java
public static int power5(int num) {
    int count = 0;
    while (num >= 5) {
        count += num / 5;
        num /= 5;
    }
    return count;
}

public static int power2(int num) {
    int count = 0;
    while (num >= 2) {
        count += num / 2;
        num /= 2;
    }
    return count;
}
```
> Math.min(power2(), power5())
------------------------------------------------------------------------------------------
### n*n 정사각형 개수
- [참고](https://blog.naver.com/neutrinoant/221274874006)
```java
int answer = (n-1)n*n(n+1)/12;
```


------------------------------------------------------------------------------------------
## 수학 1(연습)
------------------------------------------------------------------------------------------
### 진수 변환
- [참고](https://hianna.tistory.com/527)
- 매커니즘
> 10진수를 제외한 나머지 진수는 String으로 받아야 한다. -> int는 전부 10진수로 인식  
2진수, 8진수, 16진수는 아래와 같이 Binary, Octal, Hex함수가 존재한다.  
물론 toString(int n, int radix)로 사용해도 무관하다.
```java
public class Solution {
    public static void main(String[] args) {
        // 테스트를 위한 10진수 값 = 25
        int a = 25;

        System.out.println("10진수 -> 2진수");
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toString(a,2));
        
        System.out.println("10진수 -> 3진수");
        System.out.println(Integer.toString(a,3));

        System.out.println("10진수 -> 8진수");
        System.out.println(Integer.toOctalString(a));
        System.out.println(Integer.toString(a,8));

        System.out.println("10진수 -> 16진수");
        System.out.println(Integer.toString(a,16));
        System.out.println(Integer.toHexString(a));
    }
}

public class Solution {
    public static void main(String[] args) {
        // 테스트를 위한 n진수 값 = 25
        String a = "110011";

        System.out.println("2진수 -> 10진수");
        System.out.println(Integer.parseInt(a,2));

        System.out.println("3진수 -> 10진수");
        System.out.println(Integer.parseInt(a,3));

        System.out.println("8진수 -> 10진수");
        System.out.println(Integer.parseInt(a,8));

        System.out.println("16진수 -> 10진수");;
        System.out.println(Integer.parseInt(a,16));
    }
}
```
> Integer.toString(int num, int radix) num(10) > radix
> Integer.parseInt(int num, int radix) radix > num(10)
------------------------------------------------------------------------------------------
## [2진수 8진수 = 1373](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Binary2n8_Main_1373.java)
- [참고](https://hianna.tistory.com/527)




---------------------------------------------------------------------------------------
## [3. dp](https://github.com/kazean/algorithm/tree/main/README/dp)
------------------------------------------------------------------------------------------
### [1로 만들기](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Make1_Main_1463_99.java)
```java
/*
문제        
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다
> 최소의 경우의수
*/ 
int[] dp = new int[size+1];

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
 
```
------------------------------------------------------------------------------------------
### [이친수](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/BinaryNumber_Main_2193.java)
```java
/*
문제        
0과 1로만 이루어진 수를 이진수라 한다.
이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.

이친수는 0으로 시작하지 않는다.
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.

N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
 */

dp = new long[N + 1];
dp[0] = 0;
dp[1] = 1;

for (int i = 2; i <= N; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
}
```
> dp[i] = dp[i - 1] + dp[i - 2];
------------------------------------------------------------------------------------------
### 합분해
```java
/*
문제        
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
 */


```
> dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
------------------------------------------------------------------------------------------
### RGB 거리
> max[i+1][0] = Math.min(max[i][1], max[i][2]) + r;  
> max[i+1][1] = Math.min(max[i][0], max[i][2]) + g;  
> max[i+1][2] = Math.min(max[i][0], max[i][1]) + b;