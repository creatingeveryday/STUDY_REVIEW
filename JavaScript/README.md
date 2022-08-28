# JavaScript
1. 호이스팅
- 실제로 수 많은 JS 파일이 연결되어 사용되다보니 다른 곳에서 선언한 변수가 써야 하는 키워드를 덮어쓰는 상황을 만나게 되었다. 크롬에서 브레이킹 포인트 찍어서 디버깅해보니 명확히 알 수 있었다. 
-  호이스팅이란?
	- 코드가 실행되기전 변수 및 함수 선언을 해당 스코프의 최상단으로 끌어올려진 것처럼 동작하는 것을 말한다. 자바스크립트 엔진이 코드를 실행하기 전에 일어나는 과정에서 일어나며 모든 선언을 스코프에 등록한다고 한다. 
	- var : 선언문 이전에 참조해도 에러가 발생하지 않는다.  선언과 함께 undefind로 초기화되어 메모리에 저장된다. 코드가 실행되기 전 준비 과정에서 선언과 초기화 단계가 한번에 이루어지고 변수 선언문에 도달해서 할당이 이루어진다.
	- const, let : 선언문 이전에 참조하면 에러가 발생. 스코프부터 변수의 선언까지 일시적 사각 지대에서 사용했기 때문이다. const 와 let은 초기화 되지 않은 상태로 선언만 메모리에 저장된다. 초기화되지 않은 변수에는 접근할 수 없다. 변수 선언문에 도달했을 때 초기화와 할당이 이루어진다. 
- 변수 생성 단계
	- 선언 : 실행 컨텍스트의 변수 객체에 등록한다. 스코프는 이 변수 객체를 참조한다. 
	- 초기화 : 변수객체에 등록된 변수를 위한 공간을 메모리에 확보한다. undefind로 초기화된다. 
	- 할당 :  초기화된 변수에 실제 값을 할당한다. 
- 실행 컨텍스트?
- 함수 선언문에서는 호이스팅이 일어난다. 변수에 할당되는 함수 표현식은 선언과 할당의 분리가 발생하며 선언보다 호출이 먼저 발생하는 경우 에러가 발생한다.  