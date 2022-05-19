# Mybatis

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