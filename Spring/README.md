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

## Spring MVC

### 핵심 구성 요소 및 요청 처리 순서
```
1.  클라이언트 측에서 요청 전송하면 DispatcherServlet이 받는다.
    
2.  DispatcherServlet은 HandlerMapping에게 요청 URL과 매칭되는 컨트롤러 검색을 요청하고 HandlerMapping은 컨트롤러 객체를 찾아서 전달한다.
    
3.  DispatcherServlet은 HandlerMapping이 찾아준 컨트롤러 객체를 HandlerAdapter 에게 보내어 요청 처리를 위임한다. HandlerAdapter는 컨트롤러의 메서드를 호출해서 요청을 처리하고 그 결과를 ModelAndView 객체로 변환하여 DispatcherServlet에게 리턴한다.
    
4.  DispatcherServlet은 결과를 보여줄 뷰를 찾기 위해 리턴 받은 뷰 이름을 통해 ViewResolver 객체를 이용해 뷰 객체를 생성하거나 찾아서 리턴한다.
    
5.  DispatcherServlet은 리턴 받은 뷰 객체에게 응답 결과 생성을 요청한다.
 
6.  뷰 객체가 전송할 응답 결과를 생성한다.    
```

## Redirect( 리다이렉트) “redirect: 경로”

-   경로가 / 로 시작시 웹 애플리케이션을 기준으로 이동경로를 생성
    
-   경로가 / 로 시작하지 않으면 현재 경로를 기준으로 상대 경로를 사용
    
-   프로토콜까지 포함하는 완전한 URL 경로를 사용할 수도 있음
    

## 커맨드 객체를 이용한 요청 파라미터 처리

-   커맨드 객체는 요청 파라미터가 담긴 객체이다.
    
-   요청 파라미터를 하나씩 받아서 쓰는게 아니라 커맨드 객체를 이용해 요청파라미터를 객체 형태로 한번에 받아 편하게 관리하고 사용할 수 있다.
    
-   스프링 내부적으로 HttpServletRequest와 setter 이용해 요청 파라미터를 전달한다.
    
-   스프링 MVC는 커맨드 객체를 자동적으로 Model 객체에 넣고 뷰 쪽에서는 커맨드 객체의 이름 첫글자를 소문자로 바꾼 값을 이용해 커맨드 객체에 접근이 가능하다.
    
-   커맨드객체 이름 변경: @ModelAttribute 적용하면 뷰 쪽에서 변경된 이름으로 접근 가능.
    
-   커맨드 객체 중첩의 경우 MVC에서 알맞게 바인딩 해주는 기능 제공
    

-   name 속성으로 res.age
    

-   커맨드 객체 리스트타입을 다루는 경우 MVC에서 알맞게 바인딩 해주는 기능 제공
    

-   name 속성으로 responses[0]
    

## 스프링 MVC : 메시지 처리

-   뷰 쪽에서 사용할 문자열을 언어별로 파일에 보관하고 있다가 언어에 따라 알맞은 파일에서 문자열을 읽어와서 표시하는 기능을 제공.

## 스프링 MVC : 커맨드 객체 검증 및 에러 메시지 처리

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

## 세션

상태를 유지하기 위해 세션 이용

컨트롤러에서 HttpServletRequest 파라미터를 이용해 HttpSession 객체를 사용하거나 바로 HttpSession 파라미터를 이용해서 사용합니다.

## 인터셉터

컨트롤러 실행 전, 실행 후, 클라이언트에 뷰를 전송한 이후에 원하는 로직을 실행할 수 있다.

-   preHandle : 리턴 타입이 boolean 이므로 false 일 경우 컨트롤러를 실행하지 않는다.
    
-   postHandle : 컨트롤러에서 Exception 발생시 postHandle 메서드는 실행되지 않는다.
    
-   afterCompletion : 컨트롤러 실행과정에서 Exception이 발생하면 객체가 전달된다. 발생하지 않으면 네번째 파라미터인 Exception 파라미터는 null이 된다.
    
HandlerInterceptor 인터페이스를 구현하여 사용하며 인터셉터를 만든 뒤에 addInterceptors 메서드를 통해 적용될 경로와 인터셉터를 등록하여 사용한다.

## 쿠키

컨트롤러단에서 HttpServletResponse 객체에 쿠키를 설정하고 addCookie 메서드를 통해 쿠키를 생성한다.

@CookieValue 어노테이션을 사용해서 쉽게 쿠키를 파라미터로 전달 받을 수 있다.

-   value : 쿠키의 이름을 지정
    
-   required : true 가 기본 값이며 지정한 이름을 가진 쿠키가 존재하지않으면 Exception 발생
    
-   defaultValue : 기본 값을 지정


## 날짜 변환

@DateTimeFormat : 날짜 문자열을 날짜 객체로 변환한다. 커맨드 객체 필드에 적용하여 사용한다. 커맨드 객체에 @DateTimeFormat 어노테이션이 적용되어 있으면 @DateTimeFormat에서 지정한 형식을 이용해서 문자열을 LocalDateTime 타입으로 변환한다.

-   변환 처리 과정

스프링 MVC는 컨트롤러의 요청 url 매핑된 메서드와 DispatcherServlet 사이를 연결하기 위해 RequestMappingHandlerAdapter 객체를 사용하는데 이 핸들러 어댑터 객체가 요청 파라미터와 커맨드 객체 사이의 변환 처리를 위해 WebDataBinder 를 사용합니다.

WebDataBinder는 커맨드 객체를 생성하고 커맨드 객체와 같은 이름을 갖는 요청파라미터를 이용해 프로퍼티 값을 생성합니다. 이 과정에서 WebDataBinder는 직접 타입을 변환하지 않고 ConversionService에 그 역할을 위임합니다.

ConversionService 인터페이스는 기본적인 타입들의 변환을 지원하고 사용자가 작성한 컨버터를 등록할 수 있게 해준다. 기본적으로 ’FormattingConversionServiceFactoryBean’을 사용한다.


## 익셉션 처리

  

### @ExceptionHandler 
해당 컨트롤러에 @ExceptionHandler 어노테이션을 적용한 메서드가 존재하면그 메서드가 익셉션을 처리한다.

-   적용한 메서드는 컨트롤러의 요청 매핑 어노테이션 적용 메서드와 마찬가지로 뷰 이름을 리턴할 수도 있다.
    
-   익셉션 객체에 대한 정보를 알고 싶다면 메서드의 파라미터로 익셉션 객체를 전달받아 사용하면 된다.
    
-   적용 메서드가 가질 수 있는 파라미터 : HttpServletRequest, HttpServletResponse, HttpSession, Model, Exception
    
-   적용 메서드가 가질 수 있는 리턴 타입: ModelAndView, String, ResponseEntity, 임의의 객체 (@ResponseBody 어노테이션을 붙인 경우)
    

### @ControllerAdvice
이렇게 컨트롤러마다 익셉션 처리 메서드를 작성하면 많은 중복이 발생하므로 @ControllerAdvice 어노테이션을 이용해서 중복을 없앨 수 있다. 적용된 클래스는 지정한 범위의 컨트롤러에 공통으로 사용될 설정을 지정할 수 있다.

-   적용된 클래스는 지정한 범위의 컨트롤러에 공통으로 사용될 설정을 지정할 수 있다.
-   사용하기 위해서 해당 클래스는 빈으로 등록되어야 한다.
-   속성
	-   value, basePackages : 공통 설정을 적용할 컨트롤러가 속하는 기준 패키지
	-   annotations : 특정 어노테이션이 적용된 컨트롤러를 대상으로 지정
	-   assignableTypes : 특정 타입 또는 그 하위 타입인 컨트롤러 대상으로 지정


## JSON 응답과 요청 처리

  

스프링MVC는 자바객체를 HTTP 응답으로 변환할 떄 HttpMessageConverter를 사용한다. Jackson 을 이용해서 자바객체를 JSON으로 변환할 때는 MappingJackson2HttpConverter를 사용


## 프로필과 프로퍼티 파일 : Profile

개발환경 설정과 실제 서비스 운영환경 설정을 구분하여 관리하는 스프링의 기능은 Profile 이다.

각기 다른 프로필을 전환하여 편리하게 스프링컨테이너를 초기화해서 사용할 수 있다.

프로필 설정 및 적용 방법

-   @Configuration 설정에서 프로필을 사용하려면 @Profile 어노테이션을 붙여서 사용한다. 컨테이너를 초기화하기전에 setActiveProfiles 메서드를 사용해서 프로필을 선택한다. 적용된 클래스는 해당 프로필을 활성화했을때 적용되는 설정클래스를 의미한다.
	-   spring.profiles.active 시스템 속성에 값을 지정한다.
	-   java -Dspring.profiles.active=dev xxx.jar
    
-   프로퍼티 파일을 이용
	-   스프링은 외부의 프로퍼티 파일을 이용해서 스프링 빈을 설정하는 방법을 제공한다.
	-   PropertySorucePlaceholderConfigurer 빈 설정하고 프로퍼티 파일 경로를 설정한다. 그 후 @Value 어노테이션으로 프로퍼티 값 사용 가능
	-   스프링부트에서는 src/main/resources 디렉토리에 있는 application.properties 파일을 자동으로 감지하여 바로 @Value 어노테이션을 사용가능합니다.
