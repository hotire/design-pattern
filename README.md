# Design Pattern (디자인 패턴)

## Singleton pattern (싱글톤 패턴)
어플리케이션에서 어떠한 클래스에 하나의 객체만 메모리 할당하여 사용하는 디자인 패턴

1. Eager 방식
2. Lazy 방식 
- thread safe (synchronized)
- DCL
3. Holder 방식

## Proxy pattern (프록시 패턴)
'대리인' 이라는 의미로 프록시가 대리하여 업무를 처리하고 그 안에서 보조업무 처리를 하는 것이다.( + 데코레이터) </br>
Spring AOP를 구현하는 방식이다. </br>


## Facade pattern (퍼사드 패턴)

서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공한다.

복잡한 서브시스템의 인터페이스를 단순화한다.

## Adapter pattern (어답터 패턴)

한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환한다.

## Decorator pattern (데코레이터 패턴)

## Bridge pattern (브릿지 패턴)

Abstraction과 Implementor을 분리하는 것이 목적이다.
 
추상이라는 것은 멤버로 Implementor의 인터페이스를 가지고 있고 해당 인터페이스를 통해 호출한다.
 
구현체가 바뀌어도 Abstraction에 영향을 주지 않는다.
 
Abstraction 코드가 바뀌어도 Implementor에 영향을 주지 않는다.

## Composite pattern (컴포지트 패턴)

## Visitor pattern (방문자 패턴)








hotire blog : https://blog.naver.com/gngh0101
