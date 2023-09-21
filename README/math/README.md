# 수학
## 소수 - 에라토스테네스의 체
- [참고](https://firework-ham.tistory.com/8)
- 매커니즘
> 소수가 되는 수의 배수를 지우면 남은 건은 소수만 된다
```java
public static void prime() {
    prime[0] = prime[1] = true;

    for (int i = 0; i <= 10000; i++) {
        if (!prime[i]) {
            for (int j = i * i; j <= 10000; j += i) {
                prime[j] = true;
            }
        }
    }
}
```

---------------
## 최대공약수(GCD, Greatest Common Divisor), 최소공배수(LCM) - baekjoon.basic1.math.Main_2609_99
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
