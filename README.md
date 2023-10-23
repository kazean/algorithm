# 알고리즘 기초 1/2
---------------------------------------------------------------------------------------
## [자료구조](https://github.com/kazean/algorithm/tree/main/README/data_structure)
- 스택
```java
Stack<E> s = new Stack<>();
```
- 큐
```java
LinkedList<E> q = new LinkedList<>();
Queue<E> q = new LinkedList<>();
```
- 덱
```java
ArraysDeque<T> deque = new ArraysDeque<>();
Deque<T> dq = new LinkedList<>();
```


---------------------------------------------------------------------------------------
## [수학](https://github.com/kazean/algorithm/tree/main/README/math)
- GCD LCD
### GCD
```java
// # 반복문 방식
int gcd(int a, int b) {
	
	while(b != 0) {
		int r = a % b;
		a = b;
		b = r;
	}
	return a;
}
 
// # 재귀 방식
int gcd(int a, int b) {
	if(b == 0) return a;
	return gcd(b, a % b);
}
```
### LCD
```java
// 최소공배수 : Least Common mulitple
int lcm(int a, int b) {
	return a * b / gcd(a, b);
}
```
- 소수 - 에라토스테네스의 체
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
- 0의 개수(팩토리얼)
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
- n*n 정사각형 개수
```java
int answer = (n-1)n*n(n+1)/12;
```
- 진수 변환
```java
// 10진수를 제외한 진수는 parameter로 String
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
```


---------------------------------------------------------------------------------------
## [dp](https://github.com/kazean/algorithm/tree/main/README/dp)
- 1로 만들기
> Math.min(dp[n/3], dp[n/2], dp[n-1])
- 이친수
> dp[i] = dp[i - 1] + dp[i - 2];
- 합분해
> dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
- RGB 거리
> max[i+1][0] = Math.min(max[i][1], max[i][2]) + r;  
> max[i+1][1] = Math.min(max[i][0], max[i][2]) + g;  
> max[i+1][2] = Math.min(max[i][0], max[i][1]) + b;


---------------------------------------------------------------------------------------
## [브루트 포스 brute force](https://github.com/kazean/algorithm/tree/main/README/brute_force)
