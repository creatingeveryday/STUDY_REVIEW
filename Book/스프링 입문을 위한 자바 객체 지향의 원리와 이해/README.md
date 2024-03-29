
# 스프링 입문을 위한 자바 객체 지향의 원리와 이해

프로젝트를 진행하면서 배운 내용을 책을 통해 정리하는 기회가 될 것 천천히 읽고 정리할 예정

객체 지향에 대한 이해는 스프링 프레임워크를 이해하기 위한 필수 조건이다.

1.  사람을 사랑한 기술 : 인간을 위한 발전 과정

-   기계어 : 기계가 이해하는 언어로, 비인간적인 언어
-   어셈블리어 : 기계어를 벗어나 인간의 언어를 모방해 프로그램을 작성하는 것이 가능해짐
-   C언어 : 강력한 이식성을 가진 언어로 (one source multi object use anywhere) 하나의 소스 파일을 각 기계에 맞는 컴파일러로 컴파일하면 기계어 목적파일이 만들어짐.
-   C++ : 객체지향 개념 도입
-   자바, C# : VM (가상머신) 도입, 단하나의 JVM 용 기계어 생성
-   객체 지향의 4대 특성을 누군가에 설명할 수 있는가?

2.  자바와 절차적/구조적 프로그래밍의 유산

-   프로그램이 메모리를 사용하는 방식
    -   코드 실행영역 + 데이터 저장 영역(스태틱 + 스택 + 힙)
    -   T 메모리 구조
    -   goto 를 이용한 이동은 프로그램을 논리적으로 잘 구성하면 모두 피할 수 있는 것들이라 자바에서는 원칙적으로 사용을 금지하였다.
    -   함수 사용 권장: 중복 코드 제거 및 논리 분할
    -   순서
    -   1.  JRE 가 main 메서드 있는지 확인 후 JRE는 프로그램 실행을 위한 사전 준비 과정 실행하기 위해 JVM 전원을 넣어 부팅시킨다. JVM 은 과정 수행.
            -   java.lang 패키지를 스태틱 영역에 올린다.
            -   개발자가 작성한 모든 클래스와 임포트 패키지도 스태틱 영역에 올린다.
        2.  main 메서드가 실행될 스택 프레임을 스택 영역에 할당한다. 메서드의 파라미터를 저장할 변수 공간을 스택 프레임의 맨 밑에 확보한다. (여는 중괄호로 스택 프레임이 만들어지고 닫는 중괄호로 스택프레임이 소멸된다.)
        3.  main 메서드가 끝나면 JRE는 JVM을 종료하고 JRE 자체도 운영체제상의 메모리에서 사라진다.
-   블록 스택 프레임
-   변수는 3개의 메모리 영역 어디에 저장되는가? 3군데 모두 저장되며 각각의 변수는 다른 목적을 가진다.
    -   지역변수 : 스택 영역안에만 사용할 수 있으며 스택 프레임이 사라지면 같이 사라진다.
    -   클래스 멤버 변수: 스태틱 영역에서만 존재하며, 스태틱 영역에 한번 자리를 잡으면 JVM이 종료될 때까지 고정된 상태로 존재한다.
    -   객체 멤버 변수 : 힙 영역에서 객체와 함께 존재하며 가비지 컬렉터에 의해 정리 소멸된다.
-   메서드 스택 프레임에서 다른 메서드 스택 프레임의 내부 지역 변수는 접근이 불가능하다.
-   멀티 쓰레드 / 멀티 프로세스
    -   멀티 쓰레드는 스택 영역을 스레드 개수만큼 분할 해서 사용하는 구조.
    -   멀티 프로세스는 다수의 T메모리 데이터 저장영역을 가지는 구조라고 할 수 있다.
    -   서블릿은 요청당 스레드를 생성하며 요청당 프로세스를 생성하는 것보다 효율적이다.

3.  자바와 객체지향

-   객체 지향은 인간적이고 직관적이다.
-   객체지향의 4대 특성
    -   캡슐화 : 정보 은닉
	    - 접근 제어자
	    - 상속을 받지 않았다면 객체 멤버는 객체를 생성한 후 객체 참조 변수를 이용해 접근해야한다.
	    - 정적 멤버는 클래스명으로 접근하는 것이 권장된다.
        
    -   상속 : 재사용과 확장, 세분화, 상위 클래스 - 하위 클래스, 슈퍼클래스 - 서브클래스 (extends)
        
        -   상속한다는 것이 상위 클래스의 특성을 상속한다는 의미이지 부모 - 자식 관계로 생각하면 안된다.
        -   is a 관계 => is kind of 관계 : 하위 클래스 is a 상위 클래스관계인데 객체와 클래스의 관계로 오해될 소지가 많다. 보다 명확한 표현은 하위 클래스 is a kind of 상위클래스(펭귄 is a kind of 조류)이다.
        -   다중상속을 지원하지 않고 인터페이스를 도입 : 구현 클래스 is able to 인터페이스 관계로 구현 클래스는 인터페이스할 수 있다. (Serializable 직렬화 할 수 있는, Cloneable 복제할 수 있는, Comparable 비교할 수 있는, Runnable 실행할 수 있는), 이렇게 도입된 인터페이스는 또 다른 장점이 있는데 인터페이스는 구현 클래스가 구현해야하는 기능을 강제할 수 있다.
        -   상위클래스가 물려줄 특성이 풍부할수록 좋고, 인터페이스가 구현을 강제할 메서드가 적을수록 좋다.(LSP, ISP)
    -   다형성 : 사용 편의성
        
    -   추상화 : 모델링
        
-   객체 생성시 힙 영역에 초기화 되어 생성된다. 객체에 대한 주소 값을 참조변수에 할당한다.
-   하위 클래스의 인스턴스가 생성될 때 상위 클래스의 인스턴스도 함께 생성된다. 최상위 클래스인 Object 클래스의 인스턴스도 함께 생성된다.
-   암묵적 형변환, 명시적 형변환
-   상위 클래스 타입의 객체 참조 변수를 사용하더라도 하위 클래스에서 오버라이딩한 메서드가 호출된다.
-   클래스 이름은 분류하는 단어를 사용해 작명해야하고 , 객체 참조 변수명은 유일무이한 사물인 객체처럼 작명해야한다.
- 참조 변수의 복사 Call By Reference : 저장하고 있는 값을 주소로 해석. 
- Call By Value : 저장하고 있는 값을 그 값 자체로 해석 

4. 자바가 확장한 객체지향
	- abstract : 추상메서드와 추상 클래스
		- 몸체가 없이 선언만 있는 메서드가 필요한 이유는? 
		- 추상 클래스는 인스턴스를 만들 수 없다.
		- 추상 메서드를 사용함으로써 하위 클래스에게 메서드의 구현을 강제할 수 있다.
		- 추상 메서드를 포함하는 클래스는 추상 클래스다. 
	- 생성자: 객체 생성자 메서드
		- 개발자가 아무런 생성자도 만들지 않으면 자바는 인자가 없는 기본 생성자를 자동으로 만들어준다.
		- 인자가 있는 생성자를 하나라도 만든다면 자바는 기본 생성자를 자동으로 만들어주지 않는다.
	- static 블록 
		- 클래스가 static 영역에 배치될 때 실행되는 코드 블럭.
		- static { }
		- 모든 패키지와 클래스가 static 영역에 처음부터 로딩되지는 않는다.
		- 해당 패키지 또는 클래스가 처음으로 사용될 때 static 영역에 로딩되며 static 블럭이 실행된다.  
		- 메모리는 최대한 늦게 사용을 시작하고 최대한 빨리 반환하는게 좋기 때문이다.
	- final 
		- final 클래스 : 상속 불가
		- final 변수 : 상수
		- final 메서드 : 오버라이딩 금지
	- instanceof 연산자
		- 만들어진 객체가 특정 클래스의 인스턴스인지 물어보는 연산자
		- instanceof 연산자가 코드에 보인다면 리팩터링의 대상이 아닌지 점검해볼 것. LSP 원칙 위반 확인
	- package 
	- interface, implements
		- 추상 메서드와 정적 상수만 가질 수 있다. 
		- public, static, final, abstract 키워드를 사용하여 명확하게 표시하는게 좋다.(자동으로 붙여주지만)
		- 자바 8에서 도입된 람다는 인터페이스를 기초로 하고 있다. 디폴트 메서드와 정적 추상 메서드 추가로 지원.  
	- this 
	- super

5. 객체 지향 설계 5 원칙 : SOLID 
	- 객체 지향 언어를 이용해 객체 지향 프로그램을 올바르게 설계해나가는 원칙
	- SOLID 원칙은 속성, 메서드, 클래스, 객체, 패키지, 모듈, 라이브러리, 프레임워크, 아키텍처 등 다양한 곳에 다양하게 적용될 수 있는 개념이다. 
	- 응집도를 높이고 결합도를 낮추는 것이 목표이다.
		- 결합도는 모듈 간의 상호 의존 정도로서 결합도가 낮으면 모듈 간의 상호 의존성이 줄어들어 객체의 재사용이나 수정 유지보수가 용이해진다.
		- 응집도는 하나의 모듈 내부에 존재하는 구성 요소들의 기능적 관련성으로, 응집도가 높은 모듈은 하나의 책임에 집중하고 독립성이 높아져 재사용이나 기능의 수정, 유지보수가 용이하다. 
	- SRP(Single Responsibility Principle) : 단일 책임 원칙
		- 어떤 클래스를 변경해야 하는 이유는 오직 하나 뿐이어야 한다. 
		- 역할과 책임에 따라 분리하여 하나의 역할과 책임만 갖게 한다.
		- 추상화
		- 애플리케이션의 경계를 정하고 추상화를 통해 클래스들을 선별하고 속성과 메서드를 설계할때 단일책임 원칙을 고려하라. 
		- 단일 책임 원칙을 적용해 리팩터링 수행할 것. 
	- OCP(Open Closed Principle) : 개방 폐쇄 원칙
		- 소프트웨어 엔티티는 확장에 대해서는 열려있어야 하지만 변경에 대해서는 닫혀 있어야 한다.
		- 자신의 확장에는 열려있고 주변의 변화에는 닫혀있어야 한다.
		- JDBC를 사용하는 클라이언트는 사용하는 데이터베이스가 바뀌더라도 connection 설정하는 부분외에 따로 수정할게 없다. 개방 폐쇄 원칙이 잘 지켜지고 있다. 
		- 유연성, 재사용성, 유지보수성 확보
	- LSP(Liskov Substitution Principle) : 리스코프 치환 원칙
		- 서브 타입은 언제나 자신의 기반 타입으로 교체할 수 있어야한다.
		- 하위 클래스의 인스턴스는 상위형 객체 참조 변수에  대입해 상위 클래스의 인스턴스 역할을 하는데 문제가 없어야 한다. 
		- 계층도/ 조직도 에서 리스코프 치환 원칙 위배를 확인할 수 있다. 
		- 분류도에서는 리스코프 치환 원칙이 잘 적용되고 있음을 확인할 수 있다.
	- ISP(Interface Segregation Principle) : 인터페이스 분리 원칙
		- 클라이언트는 자신이 사용하지 않는 메서드에 의존 관계를 맺으면 안된다.
		- 인터페이스 최소 주의 : 인터페이스는 역할에 충실한 최소한의 기능만 공개하라.
	- DIP(Dependency Inversion Principle) : 의존 역전 원칙
		- 추상화된 것은 구체적인 것에 의존하면 안된다. 구체적인 것이 추상화된 것에 의존해야한다.
		- 자신보다 변하기 쉬운 것에 의존하지 마라. 
		- 구체적인 클래스는 추상적인 인터페이스에 의존하는 의존 방향 역전이 일어나게 구현.
	- 관심사의 분리
		- 관심이 같은 것끼리는 하나의 객체 안으로 또는 친한 객체로 모으고, 관심이 다른 것은 가능한 따로 떨어져 서로 영향을 주지 않도록 분리하자. 
	- SOLID 원칙을 적용하면 소스파일의 개수는 많아지지만 논리를 더욱 잘 분할해서 잘표현하기에 이해하기 쉬워지고 개발하기 쉬워지고 유지보수하기 쉬워진다. 
	
6. 스프링이 사랑한 디자인 패턴 : 표준 설계 패턴
	- 디자인 패턴이란? 
		- 어떠한 방식으로 로직을 구성해야하는가?
		- 프로그램을 설계할 때 발생했던 문제들을 객체간의 상호 관계등을 이용하여 해결 
	- Adapter : 어댑터 패턴
		- 서로 다른 두 인터페이스 사이에 통신이 가능하게 하는 변환기 역할
		- 개방 폐쇄 원칙을 활용한 설계 패턴 
		- JDBC, JRE
		- 객체를 속성으로 만들어서 참조하는 디자인 패턴
		- 호출당하는 쪽의 메서드를 호출하는 쪽의 코드에 대응하도록 중간에 변환기를 통해 호출하는 패턴
	- Proxy : 프록시 패턴
		- 대리자, 대변인...제어 흐름을 조정하기 위한 목적으로 중간에 대리자를 두는 패턴
		- 대리자는 실제 서비스와 같은 이름의 메서드를 인터페이스를 사용해서 구현한다.
		- 대리자는 실제 서비스에 대한 참조변수를 갖는다.
		- 대리자는 실제 서비스의 같은 이름을 가진 메서드를 호출하고 그 값을 클라이언트에게 돌려준다.
		- 대리자는 실제 서비스의 메서드 호출 전후에 별도의 로직을 수행할 수 있다. 
		- 제어의 흐름을 변경하거나 다른 로직을 수행하기 위해 사용한다.
	- Decorator : 데코레이터 패턴
		- 장식자
		- 프록시 패턴과 유사하나 클라이언트가 받는 반환값을 조작한다.
		- 장식자는 실제 서비스와 같은 이름의 메서드를 인터페이스를 이용해서 구현한다. 
		- 장식자는 실제 서비스에 대한 참조 변수를 갖는다. 
		- 장식자는 실제 서비스의 같은 이름을 가진 메서드를 호출하고, 그 반환 값에 장식을 더해 클라이언트에게 돌려준다. 
		- 장식자는 실제 서비스의 메서드 호출 전후에 별도의 로직을 수행할 수도 있다. 
		- OCP, DIP
	- Singleton : 싱글턴 패턴
		- 인스턴스를 하나만 만들어서 재사용.
		- 커넥션 풀, 쓰레드 풀, 디바이스 설정 객체 등에서 사용
		- 적용 요소
			-  new 를 실행할 수 없도록 생성자에 private 접근 제어자를 지정
			- 유일한 단일 객체를 반환할 수 있는 정적 메서드
			- 유일한 단일 객체를 참조할 정적 참조 변수
		- 단일 공유 객체인 싱글턴 객체는 공유 객체로 사용되기 때문에 속성을 갖지 않게 하는 것이 정석이다. 
		- 단일 객체가 다른 단일 객체에 대한 참조를 속성으로 가진 것은 문제가 되지 않는다.
		- 단점 
			- 독립적인 개별적인 인스턴스를 만들지 못하면 단위 테스트가 어렵다.
			- 모듈간의 결합을 강하게 만들 수 있기 때문에 DI(의존성 주입)을 통해 모듈간의 결합도를 낮춰야한다. 
	- template Method : 템플릿 메서드 패턴
		- 상위 클래스의 견본 메서드에서 하위클래스가 오버라이딩한 메서드를 호출하는 패턴
		- 중복된 부분을 상위 클래스로, 달라지는 부분만 하위 클래스로 분할
		- 공통 로직을 수행하는 상위클래스의 템플릿 메서드
		- 하위클래스에 오버라이딩을 강제하는 추상메서드 또는 선택적으로 오버라이딩할 수 있는 훅 메서드
		- DIP
	- factory method : 팩토리 메서드 패턴 => [실습링크](https://github.com/creatingeveryday/STUDY_REVIEW/tree/main/DesignPattern/factoryMethod)
		- 객체를 생성하는 공장
		- 객체를 생성 반환 하는 메서드
		- 하위 클래스에서 팩터리 메서드를 오버라이딩해서 객체를 반환하게 하는 것
			- 상위클래스에서 뼈대를 잡고 하위 클래스에서 객체 생성을 구체적으로 결정하는 패턴
			- 상위 클래스에서는 인스턴스 생성방식을 몰라도 되어서 유연성 향상
			- 객체 생성 로직 분리 되어있음
		- DIP
	- strategy : 전략 패턴
		- 전략 메서드를 가진 전략 객체 
		- 전략 객체를 사용하는 컨텍스트 : 전략 객체의 사용자
		- 전략 객체를 생성해 컨텍스트에 주입하는 클라이언트(제 3자, 전략 객체의 공급자)
		- 전략을 다양하게 변경하면서 컨텍스트를 실행할 수 있다.
		- 객체의 행위를 전략을 변경하여 쉽게 교체할 수 있다.
		- OCP, DIP
	- template callback : 템플릿 콜백 패턴
		- 전략 패턴과 유사하나 전략을 익명 내부 클래스로 정의해서 사용한다. 
		- 중복되는 클라이언트의 코드를 컨텍스트로 이동하여 중복 제거
		- OCP, DIP
8. 스프링 삼각형
	- IoC/DI
		- 의존성이란?
		- 의존성 주입: 생성자, 속성, 스프링, @Autowired, @Resource
		- 확장성과 유연성 확보, 유지보수성 향상
		- 응집도는 높이고 결합도를 낮춰라. 
	- AOP
		- 관점 지향 프로그래밍
		- 로직 주입
		- cross-cutting-concern 분리하여 런타임에 메서드에 로직 주입
		- SOLID:SRP원칙 적용하기 쉬워진다.
		- 개발자는 Aspect 관련 코딩을 베이스로 횡단 관심사를 처리하고 핵심 로직에 집중할 수 있다.
		- 인터페이스, 프록시, 런타임
	- PSA
		- 일관성 있는 서비스 추상화
		- 어댑터 패턴을 적용
		- 같은 일을 하는 다수의 기술을 공통의 인터페이스로 제어할 수 있게 하는 서비스 추상화
		- 어떤 기술을 쓰던 일관된 방식으로 코드를 작성할 수 있게 PSA를 지원한다. 
		- 스프링은 ORM, 캐시, 트랜잭션 등 다양한 기술에 대한 PSA 제공 
