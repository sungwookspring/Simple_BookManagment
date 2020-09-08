# yaml파일 하나에 여러개 프로파일 관리
* active에 적용할 프로파일 이름 설정
```
spring:
  profiles:
    active: prod
---
spring:
  profiles: dev

  datasource:
    url: jdbc:h2:tcp://localhost/~/test
    username: sa
    password:
    driver-class-name: org.h2.Driver

  jpa:
    hibernate:
      ddl-auto: create-drop
    properties:
      hibernate:
        format_sql: true

logging:
  level:
    org.hibernate.SQL: debug
    org.hibernate.type: trace
---
spring:
  profiles: prod

  datasource:
    url: jdbc:mariadb://localhost:3306/bookmanagement
    username: testuser
    password: password
    driver-class-name: org.mariadb.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: create-drop
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MariaDB53Dialect
        format_sql: true

logging:
  level:
    org.hibernate.SQL: debug
    org.hibernate.type: trace
```

# 파일을 여는 방식
* 설정파일이름을 application-xx.yml로 생성
* 

# 참고자료
* [1] 블로그: https://galid1.tistory.com/664
* [2] 공식문서: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config