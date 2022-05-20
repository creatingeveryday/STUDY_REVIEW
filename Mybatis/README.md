# Mybatis

Persistence Framework
- SQL Mapper - Mybatis : SQL문장으로 직접 DB데이터를 다룸
- Object-relational Mapper -  Hibernate : 객체를 통해 간접적으로 DB 데이터를 다룸 

특징
- 개발, 유지보수가 쉽도록 비즈니스 로직과 SQL을 별도의 파일로 분리하여 관리
- JDBC 프로그래밍 캡슐화

mybatis 설정파일 => SqlSessionFactoryBuilder => SqlSessionFactory => SqlSession

1. DAO가 SqlSessionFactory에게 SQL 실행할 객체를 요구한다.
2. SqlSessionFactory는 SqlSession 객체를 생성하여 반환한다. 
3. DAO는 반환 받은 SqlSession 객체에게 SQL 실행을 요구한다. 
4. SqlSession 객체는 SQL이 저장된 mapper 파일에서 SQL을 찾는다. 
5. SqlSession은 JDBC 드라이버를 통해 데이터베이스에 질의를 실행한다.
6. SqlSession은 데이터베이스로부터 가져온 데이터로 조회 목록을 생성하여 반환한다.
7. DAO는 사용이 끝난 SqlSession 을 닫는다.  


### 오류

1.  The content of element type "configuration" must match "(properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,reflectorFactory?,plugins?,environments?,databaseIdProvider?,mappers?)".

참고 : https://mybatis.org/mybatis-3/ko/configuration.html

configuration의 요소 정의 순서를 지키지 않아 발생한 오류였다.

-   configuration
    -   [properties](https://mybatis.org/mybatis-3/ko/configuration.html#properties)
    -   [settings](https://mybatis.org/mybatis-3/ko/configuration.html#settings)
    -   [typeAliases](https://mybatis.org/mybatis-3/ko/configuration.html#typeAliases)
    -   [typeHandlers](https://mybatis.org/mybatis-3/ko/configuration.html#typeHandlers)
    -   [objectFactory](https://mybatis.org/mybatis-3/ko/configuration.html#objectFactory)
    -   [plugins](https://mybatis.org/mybatis-3/ko/configuration.html#plugins)
    -   [environments](https://mybatis.org/mybatis-3/ko/configuration.html#environments)
        -   environment
            -   transactionManager
            -   dataSource
    -   [databaseIdProvider](https://mybatis.org/mybatis-3/ko/configuration.html#databaseIdProvider)
    -   [mappers](https://mybatis.org/mybatis-3/ko/configuration.html#mappers)