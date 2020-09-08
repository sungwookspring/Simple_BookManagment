# 1. 프로젝트 목적
- 책 관리 앱
- 책을 등록하고 읽었는지 읽지 않았는지 기록

<br>

# 2. 실행방법
1.db설치: mariadb 10.5.5버전
```
$ sudo docker pull mariadb:10.5.5
```
2.빌드
* 리눅스
```
$ chmod u+x ./gradlew
$ ./gradlew clean build -Dspring.profiles.active=prod
``` 
* 윈도우
```
> ./gradlew.bat clean build -Dspring.profiles.active=prod
```
3.jar실행
```
$ cd ./build/libs
$ java -jar checkbox-0.0.1-SNAPSHOT.jar --spring.profiles.active=../../src/main/resources/application-prod.yaml
```

# 3. 목표
- [x] 책 등록: Form 요청 방식
- [x] 책 수정: Form 요청 방식
- [x] 책 삭제: Form 요청 방식
- [x] 책 등록: API 요청
- [x] 책 수정: API 요청
- [x] 책 삭제: API 요청
- [x] 스프링부트 프로필관리: 개발, 배포
- [ ] 컨테이너화
- [ ] CI
- [ ] 로그인
- [ ] 세션관리

<br>

# 4. 요구사항
- [x] 사용자는 책을 등록할 수 있어야 한다.
- [x] 사용자는 책을 읽었는지 안읽었는지 선택할 수 있어야 한다.
- [x] 사용자는 등록한 책 정보를 수정할 수 있어야 한다.
- [x] 사용자는 등록한 책을 삭제 할 수 있어야 한다.
- [x] 위 요구 사항을 API와 FORM형식으로 구현해야 한다.

<br>

# 5. 기술
- Springboot
- thymeleaf
- JPA
- Docker
- Jenkins
- Cloud
- gradle build, test 설정

<br>

# 6. 설계
## 6.1 클래스 다이어그램
![class_diagram](imgs/class_diagram.png) 

<br>

## 6.2 유즈 케이스 다이어그램
![use_case](imgs/use_case.png)

<br>

# 7. Todo
- [x] 수정 HTTP Method를 PUT으로 변경 <-- API만 적용 가능
- [x] 컨테이너화 과정 중 어떻게 테스트 코드를 돌리는지(DB상관없이)