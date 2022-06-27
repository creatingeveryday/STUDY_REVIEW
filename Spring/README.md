## 객체 지향 프로그래밍이란? 객체 지향 언어 Java의 특징, 프레임워크인 스프링과 연결지어서 생각해보자.  

### 역할과 구현을 분리해야하는 이유

### 객체지향 설계의 5가지 원칙 

- SRP : 한 클래스는 하나의 책임만 가져야 한다. 하나의 객체는 하나의 책임만을 지는게 바람직. 변경시 영향 최소화. 
- OCP : 객체는 확장에는 열려있으나 변경에는 닫혀있다. 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀있다. 다형성 활용
- LSP : 상위타입의 인스턴스를 하위 타입으로도 바꾸어도 잘 동작 해야함. 
- ISP : 인터페이스를 분리하면 변경시 영향 최소화
- DIP :  구체화가 아닌 추상화에 의존해라. 실제로 구현된 클래스가 아니라 인터페이스에 의존하면 필요시 유연하게 구현체 변경 가능. 의존성 주입을 이용. 

### 객체 그리고 협력

### 스프링의 핵심은? 왜 만들어졌나? 

### 스프링과 스프링부트의 차이점

- 복잡한 설정을 간단하게!  XML(web.xml, DispatcherServlet...) 설정을 하지 않아도 기본적인 설정을 이용해 개발을 빠르게 시작할 수 있다. (미리 설정된 기본적인 설정을 이용해 개발할 수 있다.)
	- DispatcherServlet : 인터셉터, 컨트롤러와 같은 클래스들의 설정을 지정


- Embed Tomcat을 사용한다. 
	- 설정 참고 : https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.server
	- Tomcat : Web Application Container, Web Application Server
	- Class Loader
		- JVM에 컴파일된 자바 소스 파일을 실행하기 위해 클래스를 로딩
		- 웹 애플리케이션 컨테이너는 WAR 파일의 WEB-INF 폴더를 기준으로 클래스파일을 로드하고, JAR 파일을 로드한다. 
		- Class Loader 특징
			- 로딩한 클래스 언로딩 불가능. -> 가비지 컬렉터 동작 또는 WAS 재시작될때 초기화
			- 사용자는 시스템 클래스 로더가 로드하는 클래스 패스 영역에만 접근할 수 있다.  

### @Bean 과 @Component 의 차이점  
- 둘 다 스프링 컨테이너에 빈 객체를 등록할 때 사용한다. 
- @Bean 은 외부 라이브러리의 클래스를 스프링 컨테이너에 빈 객체로 등록할때 사용한다. 메소드 내부에서 객체 생성후 리턴하여 등록한다.
- @Component 는 개발자가 직접 작성한 클래스를 스프링 컨테이너에 빈 객체로 등록할 때 사용한다.

###  # Spring MVC

#### 핵심 구성 요소 및 요청 처리 순서
```
1.  클라이언트 측에서 요청 전송하면 DispatcherServlet이 받는다.
    
2.  DispatcherServlet은 HandlerMapping에게 요청 URL과 매칭되는 컨트롤러 검색을 요청하고 HandlerMapping은 컨트롤러 객체를 찾아서 전달한다.
    
3.  DispatcherServlet은 HandlerMapping이 찾아준 컨트롤러 객체를 HandlerAdapter 에게 보내어 요청 처리를 위임한다. HandlerAdapter는 컨트롤러의 메서드를 호출해서 요청을 처리하고 그 결과를 ModelAndView 객체로 변환하여 DispatcherServlet에게 리턴한다.
    
4.  DispatcherServlet은 결과를 보여줄 뷰를 찾기 위해 리턴 받은 뷰 이름을 통해 ViewResolver 객체를 이용해 뷰 객체를 생성하거나 찾아서 리턴한다.
    
5.  DispatcherServlet은 리턴 받은 뷰 객체에게 응답 결과 생성을 요청한다.
 
6.  뷰 객체가 전송할 응답 결과를 생성한다.    
```

#### Redirect( 리다이렉트) “redirect: 경로”

-   경로가 / 로 시작시 웹 애플리케이션을 기준으로 이동경로를 생성
    
-   경로가 / 로 시작하지 않으면 현재 경로를 기준으로 상대 경로를 사용
    
-   프로토콜까지 포함하는 완전한 URL 경로를 사용할 수도 있음
    

#### 커맨드 객체를 이용한 요청 파라미터 처리

-   커맨드 객체는 요청 파라미터가 담긴 객체이다.
    
-   요청 파라미터를 하나씩 받아서 쓰는게 아니라 커맨드 객체를 이용해 요청파라미터를 객체 형태로 한번에 받아 편하게 관리하고 사용할 수 있다.
    
-   스프링 내부적으로 HttpServletRequest와 setter 이용해 요청 파라미터를 전달한다.
    
-   스프링 MVC는 커맨드 객체를 자동적으로 Model 객체에 넣고 뷰 쪽에서는 커맨드 객체의 이름 첫글자를 소문자로 바꾼 값을 이용해 커맨드 객체에 접근이 가능하다.
    
-   커맨드객체 이름 변경: @ModelAttribute 적용하면 뷰 쪽에서 변경된 이름으로 접근 가능.
    
-   커맨드 객체 중첩의 경우 MVC에서 알맞게 바인딩 해주는 기능 제공
    

-   name 속성으로 res.age
    

-   커맨드 객체 리스트타입을 다루는 경우 MVC에서 알맞게 바인딩 해주는 기능 제공
    

-   name 속성으로 responses[0]
    

#### 스프링 MVC : 메시지 처리

-   뷰 쪽에서 사용할 문자열을 언어별로 파일에 보관하고 있다가 언어에 따라 알맞은 파일에서 문자열을 읽어와서 표시하는 기능을 제공.

#### 스프링 MVC : 커맨드 객체 검증 및 에러 메시지 처리

** 검증 순서 ** 
1. 스프링은 커맨드 객체를 검증하고 결과를 에러코드로 저장
- Validator, Errors (또는 BindingResult) 인터페이스를 이용해서 검증한다. 
- 요청 매핑 어노테이션을 붙은 메서드에서 Error 타입의 파라미터 추가시 반드시 커맨더 객체 다음에 위치해야한다. 

2. 에러 코드로부터 메시지를 출력
	- 검증 후 추가된 에러 코드를 이용해 작성된 메시지를 검색해서 출력한다.

스프링 MVC는 모든 컨트롤러에 적용할 수 있는 글로벌 Validator와 단일 컨트롤러에 적용할 수 있는 Validator를 설정하는 방법을 제공하고 그리고 더 간편하게 Bean Validation을 이용한 값 검증 처리를 지원한다. 설정하는 방법만 다르고 검증을 수행 방법은 @Valid 어노테이션을 커맨드 객체에 적용하여 사용한다. 
- 직접 Validator 설정
	- 글로벌 범위 Validator 
		- WebMvcConfigurer 인터페이스에 정의된 getValidator 메서드를 구현
	- 컨트롤러 범위 Validator
		 - @InitBinder 를 이용하여 적용할 validator 설정 후 사용한다. 

- Bean Validation을 이용한 간편한 검증 처리 
	1. Bean Validation 관련 의존을 추가한다. 
	2. 'org.springframework.boot:spring-boot-starter-validation' 
	3. OptionalValidatorFactoryBean 클래스를 빈으로 등록한다. 
	4. 커맨드 객체 속성에 @NotEmpty, @NotNull, @Email… 어노테이션을 적용한다. 
	5. 컨트롤러에서 커맨드 객체에 @Valid 어노테이션 적용하여 검증한다.

Service나 Bean에서 사용하기 위해서는 '@Validated'와 '@Valid'를 추가해야 한다.  컨트롤러 클래스는 추가해주지 않아도 된다. 
