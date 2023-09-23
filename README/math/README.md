# 수학
## 소수 - 에라토스테네스의 체 - (baekjoon.basic1.math.Main_1929)
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

---------------
## 최대공약수(GCD, Greatest Common Divisor), 최소공배수(LCM) (baekjoon.basic1.math.Main_2609_99)
### 최대공약수 - 유클리트 호제법
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
### 최소 공약수  
두 자연수들의 배수들 중에서 공통된 가장 작은 수를 말한다.
```java
// 최소공배수 : Least Common mulitple
int lcm(int a, int b) {
	return a * b / gcd(a, b);
}
```
> 최소공배수 = 두 자연수의 곱 / 최대공약수  
a * b / gcd(a, b)
---------------


## n*n 정사각형 개수
- [참고](https://blog.naver.com/neutrinoant/221274874006)
```java
int answer = (n-1)n*n(n+1)/12;
```
---------------

## 팩토리얼 끝 자리 0의 수 ((baekjoon.basic1.math.Main_2004))
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

## 진수 변환
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
        System.out.println(Integer.parseInt(a,3));

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