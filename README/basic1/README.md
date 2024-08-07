# 알고리즘 기초 1/2
- [BaekJoon - 알고리즘 기초(1/2)](https://code.plus/course/41)
- [1. 자료구조](#1-자료구조)
> 스택, 큐, 덱
- [2. 수학](#2-수학)
> GCD, LCM, 에라토테네스의 체, 팩토리얼, n*n 정사각형 개수, 진법변환
- [3. DP](#3-dp)
> 2친수, 1로 만들기, 합분해 


------------------------------------------------------------------------------------------
## 1. 자료구조
------------------------------------------------------------------------------------------
- [스택](#스택---10828)
- [큐](#큐---10845)
- [덱](#덱데크---10845)

------------------------------------------------------------------------------------------
### [스택 - 10828](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_Main_10828.java)
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
### [큐 - 10845](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Queue_Main_10845.java)
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
### [덱/데크 - 10845](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Deque_Main_10866.java)
```java
ArraysDeque<T> deque = new ArraysDeque<>();
Deque<T> dq = new LinkedList<>();

dq.addFirst(E), addLast(E), E poll~(), E peek~()

```

------------------------------------------------------------------------------------------
### [스택 - 에디터 - 1406](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_uses5_Main_1406.java)
![문제](./../images/matter_editor.png)
> - ListIterator or Stack 이용 
> > - [참고](https://minhamina.tistory.com/18)
```java
    LinkedList<Character> list = new LinkedList<>();
    for (int i = 0; i < initStr.length(); i++) {
        list.add(initStr.charAt(i));
    }

    ListIterator<Character> iter = list.listIterator();
    while (iter.hasNext()) {
        iter.next();
    }

    int idx = list.size();

    int cmdCnt = Integer.parseInt(br.readLine());

    for (int i = 0; i < cmdCnt; i++) {
        String s = br.readLine();
        char c = s.charAt(0);
        if ('P' == c) {
            char t = s.charAt(2);
            iter.add(t);
        } else if ('L' == c) {
            if(iter.hasPrevious()) iter.previous();
        } else if ('D' == c) {
            if(iter.hasNext()) iter.next();
        } else if ('B' == c) {
            if (iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            }
        }
    }
```

------------------------------------------------------------------------------------------
### [스택 - 단어뒤집기 - 9093](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_uses1_Main_9093.java)
입력된 문자열 역순 출력
> !보통 Stack Uses 시간초과...
> > StringTokenizer or Stream + StringBuffer or BufferedWriter 활용

------------------------------------------------------------------------------------------
### [스택 - 괄호 - 9012](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_uses2_Main_9012.java)
올바른 괄호인지
> Stack Uses

------------------------------------------------------------------------------------------
### [큐 - 요세푸스(조세퍼스) 문제 - 1158](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Queue_uses_Main_1158.java)
원에 인원 N명 K번째 사람 추출
> Queue poll/add() 반복

------------------------------------------------------------------------------------------
### [덱 - 덱 - 10866](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Deque_Main_10866.java)
> ArrayDequeue

------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------
## 자료구조 1 (연습)
------------------------------------------------------------------------------------------
### [스택 - 단어뒤집기2 - 17413](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_Prac_Main_17413.java)
단어 뒤집기, 태그(<, >)는 그대로 출력
> StringBuffer, Stack Uses

------------------------------------------------------------------------------------------
### [스택 - 쇠막대기 - 10799](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_Prac_Main_10799.java)
쇠막대기와 레이저 배치를 나타내는 괄호표현이 공백 없이 주어진다 > 잘려진 조각의 총 개수 구하기
> Stack Uses: 괄호 여닫는 것의 개수

------------------------------------------------------------------------------------------
### [스택 - 오큰수 - 17298](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_Prac_Main_17298_99.java)
- 오큰수
> 자신보다 오른쪽에 있는 수 중에 첫번째로 큰 수
> > 일반적인 구현으로는 `시간초과`
> > > Stack을 활용해서 기존 수열 점진적으로 변화
```java
for (int i = 0; i < arrs.length; i++) {
    while (!stack.isEmpty() && arrs[stack.peek()] < arrs[i]) {
        arrs[stack.pop()] = arrs[i];
    }
    stack.push(i);
}

while (!stack.isEmpty()) {
    arrs[stack.pop()] = -1;
}
```
> Stack: index, 기존배열 > 결과값 저장

------------------------------------------------------------------------------------------
### [스택 - 오등큰수 - 17299](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_Prac_Main_17299.java)
- 오등큰수
> 자신보다 오른쪽에 있는 수중에서 빈도수가 첫번째로 큰 수
> > 오큰수와 같은 로직

------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------
## 자료구조 1 (참고)
------------------------------------------------------------------------------------------
### [스택 - 후위 표기식2 - 1935](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_Ref_Main_1935.java)
- 후위표기식 계산하기
> Stack 을 이용해서 연산자 나올대마다 pop()하여 계산하기
> > String.format("%.2f". double)

------------------------------------------------------------------------------------------
### [스택 - 후위 표기식 - 1918](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/Stack_Ref_Main_1918_99.java)
- !후위 표기식 만들기 (답안 확인)
> 연산식 우선순위에 따라서 결과 Push
> > 숫자는 append, 결과는 Stack 에서 풀기
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    
    Stack<Character> stack = new Stack<>();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < exp.length(); i++) {
        char tmp = exp.charAt(i);

        switch (tmp) {
            case '+':
            case '-':
            case '*':
            case '/':
                // 이전 연산자가 우선인 경우, 먼저 stack 에 있는 경우를 먼저 append 후 새로운 연산자를 push
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(tmp)) {
                    sb.append(stack.pop());
                }
                stack.push(tmp);
                break;
            case '(':
                // 괄호의 경우 stack 에 push
                stack.push(tmp);
                break;
            case ')':
                // 괄호가 끝나는 경우 stack 에 있는 경우를 append
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                break;
            default:
                sb.append(tmp);
        }
    }

    while (!stack.isEmpty()) {
        sb.append(stack.pop());
    }
    System.out.println(sb.toString());

}
```
> 알고리즘 구조를 어떻게 진행해야할지 더 고민하기
> > 처음든 생각 괄호 기준으로 만들기 > but 연산자나 우선순위를 생각하여 식을 stack 으로 표현하기


------------------------------------------------------------------------------------------
### [문자열/구현 - 알파벳 개수 - 10808](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/StringNImpl_Ref_Main_10808.java)
- 알파벳 개수
> - 입력: 소문자 문자열
> - 출력: 해당 알파벳 개수 출력
> > 해당 문자열에 해당하는 배열 count++
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputs = br.readLine();
    int[] result = new int[26];
    // a: 97, z: 122

    for (int i = 0; i < inputs.length(); i++) {
        char tmp = inputs.charAt(i);
        int index = tmp - 97;
        result[index] += 1;
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < result.length; i++) {
        if (i == result.length - 1) {
            sb.append(result[i]);
        } else {
            sb.append(result[i]);
            sb.append(" ");
        }
    }
    System.out.println(sb.toString());
}
```
> - 속도 index를 한번에 계산 result[inputs.charAt(i) - 97]


------------------------------------------------------------------------------------------
### [문자열/구현 - 알파벳 찾기 - 10809](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/StringNImpl_Ref_Main_10809_99.java)
- 알파벳 찾기
> - 입력: 소문자 문자열
> - 출력: a~z index, defaultIfEmpty: -1
> > 전체를 -1로 둔 상태에서 입력값 forEach 해당 index 입력(-1일 경우만)
```java
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char arr[] = br.readLine().toCharArray();
    int num[] = new int[26];
    for (int i = 0; i < 26; i++) {
        num[i] = -1;
    }

    for (int i = 0; i < arr.length; i++) {
        int loc = arr[i] - 97;


        if (num[loc] == -1) {
            num[loc] = i;
            //System.out.println(arr[i] + " = "+loc);

        }
    }
    for (int i = 0; i <  26; i++) {
        System.out.print(num[i] + " ");
    }
}
```

------------------------------------------------------------------------------------------
### [문자열/구현 - 문자열 분석 - 10820](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/StringNImpl_Ref_Main_10820.java)
- 문자열 분석
> - 입력: 문자열, 길이( 1<= N <= 100)
> - 출력: 소문자, 대문자, 숫자, 공백 개수 출력
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuffer sb = new StringBuffer();
    while (true) {
        String tmp = br.readLine();
        if (tmp == null || "".equals(tmp)) {
            break;
        }
        int smallLetterCount, capitalLatterCount, numberCount, spaceCount;
        smallLetterCount = capitalLatterCount = numberCount = spaceCount = 0;
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if ('a' <= c && 'z' >= c) {
                smallLetterCount++;
            } else if ('A' <= c && 'Z' >= c) {
                capitalLatterCount++;
            } else if ('0' <= c && '9' >= c) {
                numberCount++;
            } else {
                spaceCount++;
            }
        }
        sb.append(smallLetterCount+ " " + capitalLatterCount + " " + numberCount + " " + spaceCount + "\n");
    }
    System.out.print(sb.toString());
}
```

------------------------------------------------------------------------------------------
### [문자열/구현 - 단어 길이 재기 - 2743](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/StringNImpl_Ref_Main_2743.java)
- 단어 길이 제기
> - 입력: pulljima
> - 출력: 8

------------------------------------------------------------------------------------------
### [문자열/구현 - ROT13 - 11655](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/StringNImpl_Ref_Main_11655.java)
- ROT13
> 암호화, 복호화: 문자열 + 13
> - 입력: Baekjoon Online Judge 
> - 출력: Onrxwbba Bayvar Whqtr
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c >= 'a' && c <= 'z') {
            c = (char) (c + 13);
            if (c > 'z') {
                c = (char)(c - 26);
            }
        } else if (c >= 'A' && c <= 'z') {
            c = (char) (c + 13);
            if (c > 'Z') {
                c = (char)(c - 26);
            }
        }
        sb.append(c);
    }
    System.out.println(sb.toString());
}
```
> organize
> - String.charAt() 보다 toCharArrays해서 향상된 for문이 더빠르다
> - sout(sb)

------------------------------------------------------------------------------------------
### [문자열/구현/수학/사칙연산 - 네 수 - 10824](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/StringNMath_Ref_Main_10824.java)
- 네수
> - 입력: 10 20 30 40
> - 출력: ((str) A + B) + ((str) C + D)

------------------------------------------------------------------------------------------
### [문자열/정렬 - 접미사 배열 - 11656](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructure/StringNMath_Ref_Main_10824.java)
- 접미사 배열
> - 입력: baekjoon
> - 출력: 
```
aekjoon
baekjoon
ekjoon
joon
kjoon
n
on
oon
```
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    List<String> lists = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
        String tmp = input.substring(i, input.length());
        lists.add(tmp);
    }

    lists = lists.stream().sorted().collect(Collectors.toList());

    lists.forEach(System.out::println);
}
```

------------------------------------------------------------------------------------------








------------------------------------------------------------------------------------------
## 2. 수학
------------------------------------------------------------------------------------------
- [GCD, LCM, 유클리드 호제법](#최대공약수gcd-greatest-common-divisor-최소공배수lcm---2609)
- [소수 찾기](#소수-찾기---에라토스테네스의-체---1978)
- [0의 개수](#팩토리얼-0의-개수---1676)
- [진법변환](#2진수-8진수---17087)

------------------------------------------------------------------------------------------
### [나머지 - 10430](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Divide_Main_10430.java)
> - 입력: 첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
> - 출력: 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.

------------------------------------------------------------------------------------------
### [최대공약수(GCD, Greatest Common Divisor), 최소공배수(LCM) - 2609](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/GcdLcd_Main_2609_99.java)
> - 입력: 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다. (24 18)
> - 출력: 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.(6\n 72)
#### 최대공약수 - 유클리트 호제법
두 자연수가 공통으로 갖는 약수들 중에서 가장 큰 값 두 자연수들의 배수들 중에서 공통된 가장 작은수
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
// 최소공배수 : Least Common Mulitple
int lcm(int a, int b) {
	return a * b / gcd(a, b);
}
```
> 최소공배수 = 두 자연수의 곱 / 최대공약수  
a * b / gcd(a, b)

------------------------------------------------------------------------------------------
### [소수 찾기 - 에라토스테네스의 체 - 1978](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Prime_Main_1978.java)
- 소수 개수 구하기
> - 입력: 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
> - 출력: 주어진 수들 중 소수의 개수를 출력한다.
#### 에라토스테네스의 체 활용
- [참고](https://firework-ham.tistory.com/8)
> - 매커니즘
> > 소수가 되는 수의 배수를 지우면 남은 건은 소수만 된다
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
```java
public class Prime_Main_1978 {

    static boolean[] isPrimes = new boolean[1001];
    public static void main(String[] args) throws IOException {
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        isPrime(1000);
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if(!isPrimes[num]) result++;
        }

        System.out.println(result);
    }

    public static void isPrime(int num) {
        isPrimes[0] = true;
        isPrimes[1] = true;

        for (int i = 2; i < isPrimes.length; i++) {
            if (!isPrimes[i]) {
                for (int j = i * i; j < isPrimes.length; j+=i) {
                    isPrimes[j] = true;
                }
            }
        }

    }
}
```

------------------------------------------------------------------------------------------
### [소수 구하기 - 에라토스테네스의 체 - 1929](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Prime_Main_1929.java)
- 숫자 M과 N 사이 소수 구하기
> - 입력: M, N
> - 출력: 숫자 사이의 모든 소수
```java
public static void isPrime() {
    prime[0] = prime[1] = true;
    for (int i = 2; i <= Math.sqrt(prime.length); i++) {
        if (!prime[i]) {
            if (i >= 1001) {
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
```
> 소수 구하는 최대크기를 Math.sqrt 활용하여 for문 반복 줄이기

------------------------------------------------------------------------------------------
### [골드바흐의 추측 - 에라토스테네스의 체 - 6588](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Prime_Goldbach_Main_6588.java)
- 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 
> - 입력:
>> 입력은 하나 또는 그 이상의 테스트 케이스로 이루어져 있다. 테스트 케이스의 개수는 100,000개를 넘지 않는다.  
>> 각 테스트 케이스는 짝수 정수 n 하나로 이루어져 있다. (6 ≤ n ≤ 1000000)  
>> 입력의 마지막 줄에는 0이 하나 주어진다.
```
8
20
42
0
```
> - 출력:
```
8 = 3 + 5
20 = 3 + 17
42 = 5 + 37
```
```java
public class Prime_Goldbach_Main_6588 {

    static boolean[] prime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            StringBuffer sb = new StringBuffer();
            sb.append(num + " = ");
            for (int i = 2; i < prime.length; i++) {
                if (!prime[i] && !prime[num-i]) {
                    sb.append(i + " + " + (num - i));
                    break;
                }
            }
            System.out.println(sb.toString());
        }

    }

    public static void isPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length + 1); i++) {
            for (int j = i * i; j < prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}
```

------------------------------------------------------------------------------------------
### [팩토리얼 - 10872](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Factorial_Main_10872.java)
- 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
> - 입력: 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다. (10)
> - 출력: 0

------------------------------------------------------------------------------------------
### [팩토리얼 0의 개수 - 1676](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Factorial_Main_1676_99.java)
- 끝자리 0 의 개수 구하기
> - 입력: 50
> - 출력: 12
#### 정수론
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
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 50
    int cnt = 0;
    cnt+=N/5; // 10
    cnt+=N/25; // 2
    cnt+=N/125;
    System.out.println(cnt);
}
```

------------------------------------------------------------------------------------------
### [조합 0의 개수 - 2004](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Factorial_Main_2004.java)
- nCm = n!/((n-m)! * m!)
> - 각 승수 구해서 빼기 
> - 승수 구하는 법
> - 입력: 25 12
> - 출력: 2
```java
public class Factorial_Main_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[1]);
        int twoCount = 0;
        int fiveCount = 0;

        twoCount = count(num1, 2) - count(num1 - num2, 2) - count(num2, 2);
        fiveCount = count(num1, 5) - count(num1 - num2, 5) - count(num2, 5);

        System.out.println(Math.min(twoCount, fiveCount));
    }

    public static int count(int tmp, int modNum) {
        int cnt = 0;
        while (tmp >= modNum) {
            cnt += tmp/modNum;
            tmp /= modNum;
        }
        return cnt;
    }
}
```
> 팩토리얼 각 승수는 `tmp/modNum`

------------------------------------------------------------------------------------------
### Ref, n*n 정사각형 개수
- [참고](https://blog.naver.com/neutrinoant/221274874006)
```java
int answer = (n-1)n*n(n+1)/12;
```

------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------
## 수학 1(연습)
------------------------------------------------------------------------------------------
### [GCD합 - 9613](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Gcd_Prac_Main_9613.java)
- 모든 경우의 수 쌍에 대한 GCD 구하기

------------------------------------------------------------------------------------------
### [숨박꼭질6 - 17087](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Euclidean_Prac_Main_17087.java)
- 현재위치 S 동생위치 A[N], S+D/S-D를 해서 모든 동생위치 찾는 최대값 D 구하기
> - In/Out
```
1000000000
> 999999999

3 81
33 105 57
> 24
```
- 유클리드 호제법
> GCD
```java
public class Euclidean_Prac_Main_17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, s;
        int[] line1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = line1[0];
        s = line1[1];

        int[] childs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 1;

        for (int i = 0; i < n; i++) {
            int abs = Math.abs(s - childs[i]);
            if (i == 0) {
                result = abs;
            } else {
                result = gcd(result, abs);
            }
        }

        System.out.println(result);

    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
```

------------------------------------------------------------------------------------------
### [2진수 8진수 - 17087](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Euclidean_Prac_Main_17087.java)
- 2진수 -> 8진수
> - 입력: 11001100
> - 출력: 314
```java
public class Binary2n8_Main_1373 {
    static StringBuilder answer = new StringBuilder(333339);
    static int[] pow = {1, 2, 4};
    static int startI = 0;
    static String inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine();
        String temp; // 답은 string형으로 처리

        int len = inputs.length(), templen;
        if (len % 3 == 1) {
            cal(0, 1);
            startI += 1;
        } else if (len % 3 == 2) {
            cal(0, 2);
            startI += 2;
        }
        for (int i = startI; i < len - 1; i += 3)
            cal(i, 3);
        System.out.println(answer);
    }

    static void cal(int i, int len) {
        int tempsum = 0;
        for (int j = 0; j < len; j++)
            tempsum += (inputs.charAt(i + j) - '0') * pow[len - j - 1];
        answer.append(tempsum);
    }
}
```

#### 진수 변환
- [참고](https://hianna.tistory.com/527)
- 매커니즘
> 10진수를 제외한 나머지 진수는 String으로 받아야 한다. -> int는 전부 10진수로 인식  
2진수, 8진수, 16진수는 아래와 같이 Binary, Octal, Hex함수가 존재한다.  
물론 toString(int n, int radix)로 사용해도 무관하다.
- 진법변환
> - Integer.toString(<num>, <radix>): 10진수 > radix
> - Integer.parseInt(<num>, <radix>): radix > 10진수
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
### [8진수 2진수 - 1212](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Oct2Binary_Prac_Main_1212.java)
- 8진수 > 2진수
> - 입출력
> > 314 > 11001100  
> > 0 > 0

- [NumberFormatException] Long범위 넘을 때 Input Len: 333,334
- [OverFlow] StringBuffer 저장범위 넘을 때(OverFlow)
```java
public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int length = input.length();

    for(int i=0; i<length; i++) {
        int num = Integer.parseInt(String.valueOf(input.charAt(i)));
        switch (num) {
            case 7:
                System.out.print("111");
                break;
            case 6:
                System.out.print("110");
                break;
            case 5:
                System.out.print("101");
                break;
            case 4:
                System.out.print("100");
                break;
            case 3:
                if (i != 0) {
                    System.out.print("011");
                } else {
                    System.out.print("11");
                }
                break;
            case 2:
                if (i != 0) {
                    System.out.print("010");
                } else {
                    System.out.print("10");
                }
                break;
            case 1:
                if (i != 0) {
                    System.out.print("001");
                } else {
                    System.out.print("1");
                }
                break;
            case 0:
                if (i != 0) {
                    System.out.print("000");
                } else {
                    System.out.print("0");
                }
                break;
        }
    }
}
```

------------------------------------------------------------------------------------------
## [!-2진수 - 2089](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/MinusBinary_Prac_Main_2089_99.java)
- 10진수 > -2진수
> - 입출력: -13 > 110111

- 진법변환 변형문제
> N%2 현재 자리수 append, -2 곱해서 나눈 몫에 올림 한수가 다음 자리수 [반복]
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();

    if (input == 0) {
        System.out.println("0");
    } else {
        while (input != 1) {
            sb.append(Math.abs(input % 2));
            input = (int) Math.ceil((double) input / -2);
        }
        sb.append(input);
    }

    System.out.println(sb.reverse());
}
```

------------------------------------------------------------------------------------------
## [골드바흐 파티션 - 17103](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/GoldbachPartition_Prac_Main_17103.java)
- 짝수 N > 두 소수의 합 개수 구하기 
> - 입출력: 
> > 
```
5
6
8
10
12
100

1
1
2
1
6
```
- 에라토스테네스의 체
> Math.sqrt(N의 최대수), !isPrime(n) && !isPrime(n-j)
```java
public class GoldbachPartition_Prac_Main_17103 {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        initPrime();

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int j = 2; j <= num / 2; j++) {
                if (!isPrime[j] && !isPrime[num - j]) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    public static void initPrime() {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }
}
```

------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------
## 수학 1(참고)
------------------------------------------------------------------------------------------
### [진법 변환2 - 11005](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/FormationN_Ref_Main_11005.java)
- 10진수 > N진수
> - In/Out: 60466175 36 > ZZZZZ
```java
 public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int num = inputs[0];
        int radix = inputs[1];

        System.out.println(Integer.toString(num, radix).toUpperCase());

    }
```

------------------------------------------------------------------------------------------
### [진법 변환 - 2745](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/FormationToBaseTen_Ref_Main_2745.java)
- N진수 > 10진수
> - In/Out: ZZZZZ 36 > 60466175
```java
Integer.parseInt(num, radix);
```

------------------------------------------------------------------------------------------
### [Base Converison - 2745](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/BaseConversion_Ref_Main_11576.java)
- A 진수 > B 진수 (각 숫자 0 ~ A미만, but 영문자로 표기 X)
> - In/Out: 
```
17 8
2
2 16
> 6 2
```
```java
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int ARadix = Integer.parseInt(inputs[0]);
    int BRadix = Integer.parseInt(inputs[1]);

    int m = Integer.parseInt(br.readLine());
    int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    int radixPos = 1;
    int tenResult = 0;
    for(int i = nums.length-1; i>=0; i--) {
        tenResult += nums[i] * radixPos;
        radixPos *= ARadix;
    }

    List<Integer> results = new ArrayList<>();

    while (tenResult != 0) {
        results.add(tenResult % BRadix);
        tenResult /= BRadix;
    }

    for(int i = results.size()-1; i >= 0; i--) {
        if (i != 0) {
            System.out.print(results.get(i) + " ");
        } else {
            System.out.println(results.get(i));
        }
    }
}
```

------------------------------------------------------------------------------------------
### [소인수분해 - 2745](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/math/Factorization_Ref_Main_11653.java)
- 소인수분해
> - In/Out: 
```
72
>
2
2
2
3
3
```
```java
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());

    List<Integer> results = new ArrayList<>();
    while (num != 1) {
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                num /= i;
                results.add(i);
                break;
            }
        }
    }

    results.stream()
            .sorted()
            .forEach(System.out::println);
}
```
> 굳이 sorted, 결과 StringBuffer 사용

------------------------------------------------------------------------------------------








------------------------------------------------------------------------------------------
## 3. DP
------------------------------------------------------------------------------------------
- [1, 2, 3 더하기](#1-2-3-더하기---9095)
- [이친수까지](#이친수---2193)
- [합분해까지](#합분해---2225)

------------------------------------------------------------------------------------------
### [1로 만들기 - 1463](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Make1_Main_1463_99.java)
- X/3, X/2, X-1을 해서 최소 경우의 수 찾기
- 입력/출력
> > 2 > 1
> > 10 > 3  
- 매커니즘
> 전체 경우를 배열로 둔다음 0~N 까지 경우의 수를 반복  
> 예외 케이스 10은 2로 나누는 것보다 -1뺀후 3으로 나누는 경우가 더 짧다
> > `Math.min(dp[n/3], dp[n/2], dp[n-1])`
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
### [2N 타일링 - 11726](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/TwoNTiling_Main_11726.java)
- 2*N, `1*2 / 2*1` 오는 경우의수
- 입력/출력
> > 2 > 1  
> > 10 > 3
- 매커니즘
> - 그림을 그려가며 f(n) = f(n-1), f(n-2) 경우의 수 찾기
> - `result[i] = result[i-1] + result[i-2]`
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());

    int[] results = new int[size+1];
    results[0] = 0;
    results[1] = 1;
    results[2] = 2;
    for (int i = 3; i <= size; i++) {
        results[i] = results[i-1]%10007 + results[i-2]%10007;
    }

    System.out.println(results[size]%10007);
}
```

------------------------------------------------------------------------------------------
### [2N 타일링 2 - 11727](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/TwoNTiling2_Main_11727.java)
- 2*N, `1*2 / 2*1 / 2*2` 오는 경우의수
- 입력/출력
> > 2 > 3  
> > 8 > 171  
> > 12 > 2731
- 매커니즘
> - 그림을 그려가며 f(n) = f(n-1), f(n-2) 경우의 수 찾기
> - `dp[i] = (dp[i - 1] + dp[i - 2] * 2)` % 10007;

------------------------------------------------------------------------------------------
### [1, 2, 3 더하기 - 9095](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/OneTwoThreePlus_Main_9095.java)
- 정수 N, 1, 2, 3 더해서 만드는 경우의 수
- 입력/출력
```
// testCase, N
3
4 
7
10
>
7
44
274
```
- 매커니즘
> - 점화식 추론
> > dp[4] = 1+dp[3], 2+dp[2], 3+dp[1]
> - `dp[i] = dp[i-1] + dp[i-2] + dp[i-3]`

------------------------------------------------------------------------------------------
### [카드 구매하기 - 11052](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Card_Main_11052.java)
- 카드 팩중 N 개의 카드 가장 비싸게 구매하는 경우값 구하기
> > i번째 카드는 i개수 카드와 입력비용
- 입력/출력
```
// N, i개 i비용 ~
4
1 5 6 7 > 10
```
- 매커니즘
> - 점화식 추론
> > `dp[i] = dp[i-j] + dp[j]`
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String[] packs = br.readLine().split(" ");
    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
        int max = Integer.parseInt(packs[i-1]);
        for (int j = 1; j < i; j++) {
            max = Math.max(max, dp[i - j] + dp[j]);
        }
        dp[i] = max;
    }
    System.out.println(dp[n]);

}
```

------------------------------------------------------------------------------------------
### [카드 구매하기 2 - 16194](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Card_Main_16194.java)
- 카드 팩중 N 개의 카드 가장 싸게 구매하는 경우값 구하기
> > i번째 카드는 i개수 카드와 입력비용
- 입력/출력
```
// N, i개 i비용 ~
4
1 5 6 7 > 4
```
- 매커니즘
> - 점화식 추론
> > `dp[i] = dp[i-j] + dp[j]`

------------------------------------------------------------------------------------------
### [!1, 2, 3 더하기 5 - 15990](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/OneTowThreePlusFive_Main_15990_99.java)
- 정수 N 을 1,2,3 조합의 개수 단, 조합의 연속 숫자가 있으면 안됨
- 입력/출력
```
// testCase, N
3
4
7
10
>
3
9
27
```
- 매커니즘
> - 점화식 추론: `2차원 배열`
> > `dp[i][1] = dp[i-1][2] + dp[i-1][3]`  
> > `dp[i][2] = dp[i-1][1] + dp[i-1][3]`  
> > `dp[i][3] = dp[i-1][1] + dp[i-1][2]`
> > > N은 N-1의 2,3 로 끝나는 경우  
> > > N-2의 1,3로 끝나는 경우  
> > > N-3의 1,2로 끝나는 경우
```java
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = stoi(br.readLine());
    long[][] dp = new long[100_001][4];
    dp[1][1] = 1; // 1
    dp[2][2] = 1; // 2
    dp[3][1] = 1; // 2+1
    dp[3][2] = 1; // 1+2
    dp[3][3] = 1; // 3
    for(int i = 4; i <= 100_000; i++) {
        dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
        dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
        dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
    }

    for(int i = 0; i < n; i++) {
        int t = stoi(br.readLine());
        sb.append((dp[t][1] + dp[t][2] + dp[t][3]) % 1_000_000_009 + "\n");
    }

    System.out.println(sb);
}
public static int stoi(String str) {return Integer.parseInt(str);}
```

------------------------------------------------------------------------------------------
### [쉬운 계단 수 - 10844](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Stairs_Main_10844.java)
- 길이 N, 인접 숫자 차이가 1인수, 0으로 시작 X
- 입력/출력
```
1 > 9 // 1,2,3,4,5,6,7,8,9
2 > 17
```
- 매커니즘 - 점화식 추론
> `dp[n][i] = dp[n-1][i-1] + dp[n-1][i+1]`
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int N = Integer.parseInt(br.readLine());
    final int MAX = 100;
    //                 2_147_483_647
    final int DIVIDE = 1_000_000_000;
    long[][] dp = new long[MAX + 1][10];
    dp[1] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    for (int i = 2; i <= MAX; i++) {
        for (int j = 0; j <= 9; j++) {
            long preNum = 0;
            long nextNum = 0;
            if(j - 1 >= 0) preNum = dp[i - 1][j - 1];
            if(j + 1 <= 9) nextNum = dp[i -1][j + 1];
            dp[i][j] = (preNum + nextNum) % DIVIDE;
        }
    }

    long result = 0;
    for (int i = 0; i <= 9; i++) {
        result = (result + dp[N][i]) % DIVIDE;
    }
    System.out.println(result);

}
```

------------------------------------------------------------------------------------------
### [이친수 - 2193](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/BinaryNumber_Main_2193.java)
- 이친수
> - 1과 0으로 만 이루어진수
> - 0으로 시작하지 않는다,
> - 1이 두번 나오지 안흔ㄴ다
- 입력/출력
```
// 길이 N(1 <= N <= 90)
3 > 2
```
- 매커니즘
```text
dp[n] = dp[n-1] + dp[n-2]

dp[4] = 10XX
dp[3] = 100, 101 > 00, 01(뒤의 두자리)
> 0으로 시작하는 수
dp[2] = 10 > 10 
> 1으로 시작하는 수
```
> `dp[n] = dp[n-1] + dp[n-2]`
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
### [가장 긴 증가하는 부분수열 - 110503](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/SequenceInc_Main_11053.java)
- 주어진 수열중에서 가장 긴 증가하는 수열 찾기
- 입력/출력
```
// 길이 N, 수열
6
10 20 10 30 20 50
> 4 // 10 20 30 50

[반례]
8
1 8 9 9 9 2 3 4
> 4 // 1 2 3 4
```
- 매커니즘
> `dp[n] = n > j, MAX[dp[n-1 ~ 1]] + 1`
```java
public class SequenceInc_Main_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] dp = new int[N];
        int MAX = Integer.MIN_VALUE;

        dp[0] = 0;
        for (int i = 0; i < sequences.length; i++) {
            int tmpMax = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (sequences[j] < sequences[i]) {
                    tmpMax = Math.max(tmpMax, dp[j] + 1);
                }
            }
            dp[i] = tmpMax;
            MAX = Math.max(dp[i], MAX);
        }

        System.out.println(MAX);
    }

}
```

------------------------------------------------------------------------------------------
### [가장 긴 증가하는 부분수열4 - 14002](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/SequenceInc4_Main_11053.java)
- 주어진 수열중에서 가장 긴 증가하는 수열 찾기
- 입력/출력
```
// 길이 N, 수열
6
10 20 10 30 20 50
> 
4
10 20 30 50

[반례]
8
1 8 9 9 9 2 3 4
> 
4
1 2 3 4
```
- 매커니즘
```text
int[] dp = new int[N];
List[] list = new List[N];

dp[n] = n > j, MAX[dp[n-1 ~ 1]] + 1
list[n] = n > j, list[i].addAll(list[j]).add(nums[n])
```
> 풀이1
> - `각 dp[i]의 MAX를 구하고 해당 list를 배열에 저장, MAX일 경우 ret`
> 풀이2
> - 각 길이 MAX를 정하고 각 order_dp에 count를 저장, 새로운 값일 경우 해당 다음 값에 answer를 저장, 결과는 i>=n--; MAX = count-- 값을 출력
```java
public class SequenceInc_Main_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums;
        int[] dp = new int[N];
        List[] list = new List[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            int idx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (len < dp[j] + 1) {
                        len = dp[j] + 1;
                        idx = j;
                    }
                }
            }
            dp[i] = len;
            if(idx != i)    list[i].addAll(list[idx]);
            list[i].add(nums[i]);
            if (len > max) {
                max = len;
                result = list[i];
            }
        }
        System.out.println(max);
        result.stream()
                .sorted()
                .forEach(i -> System.out.print(i + " "));
    }

}
```
```java
public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[n];
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];

        int[] order = new int[n];

        int max = 0;
        for(int i=0; i<n; i++) {
            int next = num[i];
            if(answer[max]<next) {
                answer[++max] = next;
                order[i] = max;
            }
            else if(answer[max]==next) {
                order[i] = max;
                continue;
            }
            else {
                // 다음 값이 현재값이 최대 값보다 작은 경우, 현재 값보다 작은 다음 idx에 저장
                int l = 1;
                int r = max;
                while(l<r) {
                    int mid = (l+r)/2;
                    if(next<=answer[mid]) r=mid;
                    else l=mid+1;
                }
                order[i] = l;
                answer[l] = next;
            }
        }
        Stack<Integer> s = new Stack<Integer>();
        int count = max;

        for(int i=n-1; i>=0; i--)
            if(order[i]==count) {
                s.push(num[i]);
                count--;
            }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append(System.lineSeparator());
        while(!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.print(sb);
    }
```

------------------------------------------------------------------------------------------
### [연속합 - 1912](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/ContinuousSum_Main_1912.java)
- 연속된 배열 중 가장 큰 수
- 입력/출력
```
// 길이 N, 배열
10
10 -4 3 1 5 6 -35 12 21 -1
> 33 // 12 + 21

10
2 1 -4 3 4 -4 6 5 -5 1
> 14 // 3 4 -4 6 5

5
-1 -2 -3 -4 -5
> -1
```
- 매커니즘
> `dp[n] = Math.max(dp[n-1] + nums[i], nums[i])`
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    int[] dp = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < nums.length; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
    }

    int MAX = nums[0];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int tmp = Math.max(dp[i-1] + nums[i], nums[i]);
        dp[i] = tmp;
        MAX = Math.max(MAX, tmp);
    }
    System.out.println(MAX);
}
```

------------------------------------------------------------------------------------------
### [제곱수의 합 - 1699](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/SquareNum_Main_1699.java)
- N 보다 작은 제곱수의 합 최소 경우의 수, 1 <= N <= 100_000
- 입력/출력
```
// 길이 N, 배열
입/출력
7 > 4
1 > 1
4 > 1
11 > 3
13 > 2

반례
753
# Output
4
# Answer
3 (625 + 64 + 64 = 753)
```
- 매커니즘
> `dp[i] = dp[i - j * j] + 1`
```java
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
        dp[i] = i;
        for (int j = 1; j * j <= i; j++) {
            if (dp[i] > dp[i - j * j] + 1) {
                dp[i] = dp[i - j * j] + 1;
            }
        }
    }
    System.out.println(dp[N]);

}
```

------------------------------------------------------------------------------------------
### [합분해 - 2225](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/SumUp_Main_2225.java)
- 0 ~ N 까지의 정수 K개를 더해서 합이 N이 되는 경우의 수
- 입/출력
> - 정수 1 <= N <= 200, 1 <= K <= 200
```
20 2 > 21
6 4 > 84
```

- 매커니즘
```text
덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
> 점화식 K-1개 수를 합해 만든 값 + 0 ~ N 까지의 정수를 더한다면 K-1개의 수로 만든 합에 1개의 정수를 더한 것이므로  
> K개의 수를 사용해 만든 어떤합이 될것이다.
```
> - `dp[a][b] / dp[k][n]: K개의 수를 합해 N을 만드는 경우의 수`
> > ![dp[a][b]](./images/dp_sumUp.png)
- [참고](https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-2225-%EC%9E%90%EB%B0%94-%ED%95%A9%EB%B6%84%ED%95%B4-BOJ-2225-JAVA)
- 입/출력
```
// N, K
20 2 
> 21
6 4
> 84
```
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");

    int N = Integer.parseInt(inputs[0]);
    int K = Integer.parseInt(inputs[1]);
    int[][] dp = new int[N + 1][K + 1];
    int mod = 1000000000;

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

    System.out.println(dp[N][K]);
}
```

------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------
## DP1(연습)
------------------------------------------------------------------------------------------
### [1, 2, 3 더하기 3 - 15988](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Plus123_Main_15988.java)
- 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수
- 입/출력
> - 첫째 줄: 테스크 케이스 T, 정수 N(양수, N <= 1_000_000)

- 매커니즘
> - 정수를 1,2,3 합으로 나타내기
> > 1, 2, 3 일때 경우의 수 dp[i-3] + dp[i-2] + dp[i-1] 
> > > 표 그려보기
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
### [rgb 거리 - 1149](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/RGB_Main_1149_99.java)
- RGB거리에는 집이 N개, 1번집 ~ N 번집
> - 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다, 각 칠하는 비용
> - 1번집은 2번 집의 색과 같지 않아야 한다.
> - N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
> - i (2 <= i <= N-1)번 집의 색은  i-1, i+1번 집의 색과 같지 않아야 한다
> - 2 <= N <= 1_000, 비용 <= 1_000
> > 비용의 최소값
- 입/출력
```text
// test case, rgb 비용
3
26 40 83
49 60 57
13 89 99
> 96

3
1 100 100
100 1 100
100 100 1
> 3

3
1 100 100
100 100 100
1 100 100
> 102

6
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91
> 209
```

- 매커니즘
> - 문제를 보고 점진적으로 조건에 따른 현재 max 값을 dp에 저장하기
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
### [동물원 - 1309](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Zoo_Prac_Main_1309.java)
- 가로 두칸, 세로 N칸에 사자 배치 경우의 수
> - 가로, 세로로 붙어 있게 배치 X
> - 사자를 배치 안하는 경우: 1
> - N(1 <= N <= 100_000)
- 입/출력
> 4 > 41 (길이 N)

- 매커니즘
> 점화식
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+1];
    dp[0] = 1;
    dp[1] = 3;

    for (int i = 2; i <= N; i++) {
        dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9_901;
    }
    System.out.println(dp[N]);
}
```

------------------------------------------------------------------------------------------
### [오르막 수 - 11057](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/AscentCase_Prac_11057_99.java)
- 수의 자리가 오름차순, 인접한 수가 같아도 오름차순
> - 가로, 세로로 붙어 있게 배치 X
> - 수의 길이 N (1 <= N <= 1_000), 오르막 수의 개수, 0으로 시작가능
- 입/출력
```text
1 > 10 (길이 N)
2 > 55
3 > 220
```

- 매커니즘
> - 이중배열 각 경우의 수 dp
> > ![오르막수 규칙](./images/ascent_case.png)
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n+1][10];

    for (int i = 0; i < 10; i++) {
        dp[0][i] = 1;
    }

    for (int i = 1; i < n+1; i++) {
        for (int j = 0; j < 10; j++) {
            for (int k = j; k < 10; k++) {
                dp[i][j] += dp[i-1][k];
                dp[i][j] %= 10_007;
            }
        }
    }
    System.out.println(dp[n][0] % 10_007);
}
```

------------------------------------------------------------------------------------------
### [스티커 - 11057](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Sticker_Prac_Main_9465.java)
- 2*N의 스티커
> - 선택 스티커 기준 위, 아래, 왼쪽, 오른쪽 찢어짐
> - 스티커별 점수
> - N (1 <= N <= 100_000)
> - 점수 (0 <= 점수 <= 100)
> > 선택할 수 있는 최대 점수의 스티커
- 입/출력
```text
// 테스크 케이스 T
// [N
// 점수1 ...
// 점수2 ...
2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80
> 
260
290
```

- 매커니즘
> - 첫 번째 행부터 ~ N행까지 합 dp 
```java
static int[][] fieldArr;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseNum = Integer.parseInt(br.readLine());
    for (int i = 0; i < caseNum; i++) {
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][n+1];
        fieldArr = new int[2][n+1];

        for (int j = 0; j < 2; j++) {
            int[] numArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            fieldArr[j] = numArr;
        }

        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = fieldArr[0][0];
        dp[1][1] = fieldArr[1][0];

        for (int j = 2; j <= n; j++) {
            dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + fieldArr[0][j-1];
            dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + fieldArr[1][j-1];
        }

        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }
}
```

------------------------------------------------------------------------------------------
### [!포도주 시식 - 2156](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/Wine_Prac_Main_2156_99.java)
- 될 수 있는 대로 많은 양의 포도주 맛보기
> - 첫째 줄에 포도주 잔의 개수 n이 주어진다. (1 ≤ n ≤ 10,000)
> - 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다.
> - 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
> - 연속으로 놓여있는 세잔을 마실 수 없다 
> > 먹은 포도주의 양
- 입/출력
```text
// N
// i 번째 포도주 양
6
6
10
13
9
8
1
> 33

반례
6
100
100
0
0
100
100
> 400
```

- 매커니즘
> - [참고](https://st-lab.tistory.com/135)
> - Bottom-Up, Top-Down
> - `dp[i] = Math.max(dp[i-1], Math.max((dp[i-2] + field[i]), (dp[i-3] + field[i-1] + field[i])));`
> > `현재 dp[i] 값은 이전 dp[i-1], dp[i-2] + 현재_field, dp[i-3] + 이전_field + 현재_field`
> > > 현재 선택된 값이 최대 값이 아닐 수도 있음으로(연속 세잔 제한때문)
```java
static int N;
static int[] field;
static int[] dp;
public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    field = new int[N+1];
    dp = new int[N+1];

    for (int i = 1; i <= N; i++) {
        field[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = field[1];

    if(N > 1) dp[2] = field[1] + field[2];

    for (int i = 3; i <= N; i++) {
        dp[i] = Math.max(dp[i-1], Math.max((dp[i-2] + field[i]), (dp[i-3] + field[i-1] + field[i])));
    }
    System.out.println(dp[N]);
}
```

------------------------------------------------------------------------------------------
### [정수 삼각형 - 1932](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/EssenceTriangle_Prac_Main_1932.java)
- 맨 위에서 아래까지 내려올때 최대 수의 합, 현재 값에서 윗 라인에 대각선 좌우 이동가능
- 삼각형 크기 1 <= N <= 500
- 0 <= 정수 <= 9999
- 입/출력
> - 입력
> > - 첫째 줄: 삼각형 크기(N)
> > - 둘째 줄 ~ N+1번째 줄 정수 삼각형
> - 출력
> > 경로에 있는 수의 합
```text
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
> 30
```

- 매커니즘
> - Bottom-Up, Top-down
```java
for(int i = 0; i < N - 1; i++) {
    for (int j = 0; j <= i; j++) {
        dp[i + 1][j] = Math.max(dp[i + 1][j], (dp[i][j] + fields[i + 1][j]));
        if (j + 1 < N) {
            dp[i + 1][j + 1] = dp[i][j] + fields[i + 1][j + 1];
        }
    }
}
```
```java
public class EssenceTriangle_Prac_Main_1932 {
    static int N;
    static int[][] fields;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fields = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            fields[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dp[0][0] = fields[0][0];
        for(int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], (dp[i][j] + fields[i + 1][j]));
                if (j + 1 < N) {
                    dp[i + 1][j + 1] = dp[i][j] + fields[i + 1][j + 1];
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if(dp[N-1][i] > result)
                result = dp[N - 1][i];
        }
        System.out.println(result);

    }
}
```

------------------------------------------------------------------------------------------
### [가장 긴 증가하는 수열 - 11055](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/SequenceInc_Prac_Main_11055.java)
- 그 수열의 증가하는 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램
- 입/출력
> - 입력
> > - 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
> > - 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
> - 출력
> > 첫째 줄에 수열 A의 합이 가장 큰 증가하는 부분 수열의 합을 출력한다.
```text
10
1 100 2 50 60 3 5 6 7 8
> 113
```

- 매커니즘
> - Bottom-Up
```java
for (int i = 0; i < n; i++) {
    dp[i] = numArr[i];
    int tmpResult = 0;
    boolean flag = false;
    for (int j = i-1; j >= 0; j--) {
        if (numArr[i] > numArr[j]) {
//                    dp[i] += dp[j];
            tmpResult = Math.max(tmpResult, dp[i] + dp[j]);
            flag = true;
        }
    }
    if (flag) {
        dp[i] = tmpResult;
    }
}
```
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int sum = 0;
    int[] numArr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
        dp[i] = numArr[i];
        int tmpResult = 0;
        boolean flag = false;
        for (int j = i-1; j >= 0; j--) {
            if (numArr[i] > numArr[j]) {
//                    dp[i] += dp[j];
                tmpResult = Math.max(tmpResult, dp[i] + dp[j]);
                flag = true;
            }
        }
        if (flag) {
            dp[i] = tmpResult;
        }
    }

    int maxResult = 0;
    for (int i = 0; i < n; i++) {
        maxResult = Math.max(maxResult, dp[i]);
    }
    System.out.println(maxResult);

}
```

------------------------------------------------------------------------------------------
### [가장 긴 감소하는 수열 - 11722](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/SequenceDec_Prac_Main_11722.java)
- 가장 긴 감소하는 부분 수열을 구하시오
- 입/출력
> - 입력
> > - 첫째 줄 수열 A의 크기 N ( 1 <= N <= 1_000)
> > - 둘째 줄 수열 Ai
> - 출력
> > 수열 A의 가장 긴 감소하는 부분 수열의 길이
```text
6
10 30 10 20 20 10
> 3
```

- 매커니즘
> - Bottom-Up
```java
for (int i = 0; i < fields.length; i++) {
    int fieldNum = fields[i];
    dp[i] = 1;
    for(int j = i - 1; j >= 0; j--) {
        if(fieldNum < fields[j]) {
            dp[i] = Math.max(dp[j]+1, dp[i]);
        }
    }
}
```
> - 현재 값에서 이전 값과 비교해서 dp배열을 구성한다
> - dp배열을 구성시 이전에 구성된 dp배열을 이용해서 길이를 구한다
```java
public class SequenceDec_Prac_Main_11722 {
    static int N;
    static int[] fields, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        fields = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        for (int i = 0; i < fields.length; i++) {
            int fieldNum = fields[i];
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(fieldNum < fields[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
```

------------------------------------------------------------------------------------------
### [가장 긴 바이토닉 부분 수열 - 11054](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/BitonicInc_Prac_Main_11054.java)
- 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열
- 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성
- 입/출력
> - 입력
> > - 첫째 줄 수열 A의 크기 N (1 <= N <= 1_000)
> > - 둘째 줄 수열 Ai
> - 출력
> > 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이
```text
10
1 5 2 1 4 3 4 5 2 1
> 7
```

- 매커니즘
> - Bottom-Up
```java
// 증가
for(int i = 0; i < fields.length; i++) {
    dpInc[i] = 1;
    int field = fields[i];
    for(int j = i - 1; j >= 0; j--) {
        if(field > fields[j] && dpInc[i] < dpInc[j] + 1){
            dpInc[i] = dpInc[j] + 1;
        }
    }
}
// 감소
for(int i = fields.length -1; i >= 0; i--) {
    dpDec[i] = 1;
    int field = fields[i];
    for (int j = i + 1; j < fields.length; j++) {
        if (field > fields[j] && dpDec[i] < dpDec[j] + 1) {
            dpDec[i] = dpDec[j] + 1;
        }
    }
}

// 결과 출력
int result = 0;
for (int i = 0; i < N; i++) {
    result = Math.max(result, dpInc[i] + dpDec[i] -1);
}
```
> - 현재 값에서 증가, 감소하는 두 dp배열을 구해서 합한다
> - dp배열은 현재 값까지의 길이
```java
public class BitonicInc_Prac_Main_11054 {
    static int N;
    static int[] fields, dpInc, dpDec;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dpInc = new int[N];
        dpDec = new int[N];
        fields = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i = 0; i < fields.length; i++) {
            dpInc[i] = 1;
            int field = fields[i];
            for(int j = i - 1; j >= 0; j--) {
                if(field > fields[j] && dpInc[i] < dpInc[j] + 1){
                    dpInc[i] = dpInc[j] + 1;
                }
            }
        }

        for(int i = fields.length -1; i >= 0; i--) {
            dpDec[i] = 1;
            int field = fields[i];
            for (int j = i + 1; j < fields.length; j++) {
                if (field > fields[j] && dpDec[i] < dpDec[j] + 1) {
                    dpDec[i] = dpDec[j] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dpInc[i] + dpDec[i] -1);
        }
        System.out.println(result);
    }
}
```

------------------------------------------------------------------------------------------
### [!연속합2 - 13398](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/ContinuousSum_Prac_13398_99.java)
- n개의 정수로 이루어진 임의의 수열이 주어진다.
- 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
- 단, 수는 한 개 이상 선택해야 한다.
- 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)
- 입/출력
> - 입력
> > - 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고
> > - 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
> > - 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다
> - 출력
> > 첫째 줄에 답을 출력한다.
```text
10
10 -4 3 1 5 6 -35 12 21 -1
> 54

// 반례
6
1 2 -4 2 -5 6
> 8 // -5 제거
3
99 -100 -100
> 99
3
-100 -100 99
> 99
```

- 매커니즘
> - [참고](https://steady-coding.tistory.com/181)
> 1. 왼쪽합 dp1, 오른쪽합 dp2
> > - ans = 한개 선택시
> > - ans = dp1[i-1] + dp2[i+1]
> 2. Bottom-Up
> > - 2차원 배열
> > - dp[i][j] : i는 특정 수, j는 수를 제거한 적이 있는지 여부
> > - j = 0 
> > > dp[i][0] = max(dp[i - 1][0] + arr[i], arr[i]) 
> > - j = 1
> > > - 특정수 제거하는 경우: dp[i][1] = dp[i - 1][0] 
> > > - 이전에 특정수 제거한 경우: dp[i][1] = dp[i - 1][1] + arr[i] 
> > > > dp[i][1] = max(dp[i - 1][0], dp[i - 1][1] + arr[i]) 
- Case1
```java
for (int i = 1; i < N; i++) {
    dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);

    ans = Math.max(ans, dp1[i]);
}

int[] dp2 = new int[N];
dp2[N - 1] = arr[N - 1];

// 왼쪽 방향으로 최대 연속 합을 각각 저장함.
for (int i = N - 2; i >= 0; i--) {
    dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
}

// 특정 값을 지웠다고 가정하고, 그 값의 오른쪽 방향과 왼쪽 방향의 최대 연속 합을 더함.
// 윗줄에서 구한 값과 ans를 비교하여 더 큰 값으로 갱신.
for (int i = 1; i < N - 1; i++) {
    int temp = dp1[i - 1] + dp2[i + 1];

    ans = Math.max(ans, temp);
}
```
- Case2
```java
int[][] dp = new int[N][2]; // j = 0: 수를 제거 하지 않음, j = 1: 특정 수를 제거 함.
    dp[0][0] = dp[0][1] = arr[0];

    int ans = arr[0];
    for (int i = 1; i < N; i++) {
        // 특정 수를 제거하지 않을 경우에는 원래 방식대로 최대 연속 합을 구함.
        dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);

        // 특정 수를 제거할 경우에는 2가지 케이스를 고려해야 한다.
        // (1) i번째 수가 처음 제거되는 경우
        // -> 단순히 이전 최대 연속 합을 할당하면 됨.
        // (2) i번째 수 전에 지워진 수가 있는 경우
        // -> 현재 수는 지울 수 없으므로 이전 최대 연속 합에다가 arr[i]를 더함.
        dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

        ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
    }
```
- Code
```java
public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp1 = new int[N];
		dp1[0] = arr[0];

		int ans = dp1[0];

		// 오른쪽 방향으로 최대 연속 합을 각각 저장함.
		for (int i = 1; i < N; i++) {
			dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);

			ans = Math.max(ans, dp1[i]);
		}

		int[] dp2 = new int[N];
		dp2[N - 1] = arr[N - 1];

		// 왼쪽 방향으로 최대 연속 합을 각각 저장함.
		for (int i = N - 2; i >= 0; i--) {
			dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
		}

		// 특정 값을 지웠다고 가정하고, 그 값의 오른쪽 방향과 왼쪽 방향의 최대 연속 합을 더함.
		// 윗줄에서 구한 값과 ans를 비교하여 더 큰 값으로 갱신.
		for (int i = 1; i < N - 1; i++) {
			int temp = dp1[i - 1] + dp2[i + 1];

			ans = Math.max(ans, temp);
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
```

------------------------------------------------------------------------------------------
### [!타일 채우기 - 2133](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/ThreeNTile_Prac_Main_2133_99.java)
- 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
- 입/출력
> - 입력
> > - 첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.
> - 출력
> > 첫째 줄에 경우의 수를 출력한다.
```text
2
> 3
3
> 0
4
> 11
5
> 0
6
> 41
```

- 매커니즘
> - [참고](https://hello-backend.tistory.com/156)
> - 3x1의 경우 => 0개
> - 3x2의 경우 => 3개
> - 3x3의 경우 => 0개
> - 3x4의 경우, 3x2의 경우 * 3(3x1) + 특별 케이스 2개 => 11
> - 3x5의 경우 => 0개 
> - 3x6의 경우 3x4의 경우, * 3 + 그 전전의 전체 타일 개수 X 이전타일의 특별한 타일 개수 + 특별케이스 2개
> > 11 * 3 + (3 * 2) + 2 => 41
> - 3x8의 경우, 41 * 3 + (11 * 2 + 3 * 2) + 2
```java
for (int i = 4; i <= N; i++) {
    dp[i] = dp[i - 2] * 3;
    for (int j = 4; j <= i; j += 2) {
        dp[i] += dp[i - j] * 2;
    }
}
```
> - 현재 값에서 증가, 감소하는 두 dp배열을 구해서 합한다
> - dp배열은 현재 값까지의 길이
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[32];
    dp[0] = 1;
    dp[2] = 3;

    for (int i = 4; i <= N; i++) {
        dp[i] = dp[i - 2] * 3;
        for (int j = 4; j <= i; j += 2) {
            dp[i] += dp[i - j] * 2;
        }
    }

    System.out.println(dp[N]);

}
```

------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------
## DP1(도전)
------------------------------------------------------------------------------------------
### [!RGB거리 2 - 2133](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/dp/RGB2_Chal_Main_17404_99.java)
- RGB 색칠할 수 있는 N개집
- 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
- N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
- i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.
- 입/출력
> - 입력
> > - 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다.
> > - 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
> - 출력
> > 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
```text
2
> 3
3
> 0
4
> 11
5
> 0
6
> 41
```

- 매커니즘
> - 기본 RGB거리 계산하는 dp
> - `단, 첫번째를 선택을 고정하여 dp`
```java
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
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[32];
    dp[0] = 1;
    dp[2] = 3;

    for (int i = 4; i <= N; i++) {
        dp[i] = dp[i - 2] * 3;
        for (int j = 4; j <= i; j += 2) {
            dp[i] += dp[i - j] * 2;
        }
    }

    System.out.println(dp[N]);

}
```

------------------------------------------------------------------------------------------