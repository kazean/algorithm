# 스택
## 자료구조 1
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
### [스택 - 에디터 - 1406](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses5_Main_1406.java)
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
### [스택 - 단어뒤집기 - 9093](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses1_Main_9093.java)
### [스택 - 괄호 - 9012](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses2_Main_9012.java)

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
## 자료구조 1 (연습)
### [스택 - 단어뒤집기2 - 17413](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses3_Main_17413.java)
### [스택 - 쇠막대기 - 10799](https://github.com/kazean/algorithm/blob/main/src/main/java/baekjoon/basic1/datastructor/Stack_uses4_Main_10799.java)
## 자료구조 1 (참고)



