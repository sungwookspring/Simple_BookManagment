# mariadb 설치
```
sudo docker pull mariadb:10.5.5
```

# 컨테이너 실행
```
sudo docker run --rm -d -p 3306:3306 -v /tmp/data:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=password  -e MYSQL_DATABASE=bookmanagement -e MYSQL_USER=testuser -e MYSQL_PASSWORD=password mariadb
```

# 네트워크 오류 발생 해결
* 만약 2003에러가 발생하면 도커 네트워크를 host로 설정
```
sudo docker run --rm -d --net Host -p 3306:3306 -v /tmp/data:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=password  -e MYSQL_DATABASE=bookmanagement -e MYSQL_USER=testuser -e MYSQL_PASSWORD=password mariadb
```

# 참고자료
* [1] 스택오버플로우 번역: https://www.it-swarm.dev/ko/mysql/docker-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88%EC%97%90%EC%84%9C-localhost%EC%9D%98-mysql%EC%97%90-%EC%97%B0%EA%B2%B0/830209657/
