# Java의 Garbage Collection

> 참고할 좋은 글
>[JDK 8 Garbage Collection 공식문서](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/)
>[Java Reference와 GC](https://d2.naver.com/helloworld/329631)
>[Java Garbage Collection](https://d2.naver.com/helloworld/1329)

### Garbage Collection 이란? 
- 소개
	- JAVA에서는 개발자가 직접 메모리를 할당하고 해제하지 않는다.
	-  JVM의 Garbage Collector 가 사용하지 않고 참조되지 않는 Heap 영역의 객체를 자동으로 정리해준다.
	- GC를 이해하기 위해서는 JVM의 메모리 구조와 동작 방식도 이해해야한다. 글을 읽어보니 매우 밀접하게 관련되어있음. 더 공부해야할 것 같다. 
- 기본적인 작업 순서
	1. 힙 영역의 객체들 중 접근불가능한(unreachable) Garbage 객체를 찾는다.
	2. 찾아낸 객체를 정리하여 힙의 메모리를 회수한다. 쓰레기 객체를 정리하여 한정된 메모리를 효율적으로 사용할 수 있다.
		- 이 과정에서 GC를 실행시 쓰레드를 제외한 나머지 쓰레드는 작업을 멈추고 대기한다. (Stop-the-world)
		- 멈추는 시간을 최소화 하기 위해 Garbage Collector를 튜닝할 수도 있다.
		-  정리하는 방법은 다양함. 여러 알고리즘이 존재하며 개선되어가는 중임.
- GC 알고리즘
	- 단순무식하게 힙 영역의 모든 객체를 검사하는 방법도 사용은 가능하겠지만 현실적으로 매우 비효율적인 방법이다. 
	- 이렇게 비효율적인 방법을 사용하지 않기 위해 경험적으로 관찰된 속성으로 가설을 가정하였고 그 중에 가장 중요한 가설은 약한 세대 가설(weak generational hypothesis)이다.
	- 약한 세대 가설은 대부분의 객체는 짧은 시간 동안만 생존하고 금방 접근불가능한 객체가 되고 오래된 객체에서 젊은 객체로의 참조는 매우 적게 존재한다는 가설이다. 
	- 이 가설을 받아들인다면 대부분의 객체가 힙 영역에 생긴 후 빠른 시간 안에 쓰레기(참조할 수 없는 객체)가 되므로 힙 메모리 구조 자체를 논리적으로 세대 단위로 구분하여 관리하여 보다 효율적인 GC를 수행할 수 있다.  
- GC 알고리즘의 종류
	- Serial GC
	- Parallel GC
	- Parallel old GC
	- Concurrent Mark & Sweep GC (CMS)
	- Garbage First GC (G1)
