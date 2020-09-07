# mariadb 설치
```
sudo docker pull mariadb:10.5.5
```

# 컨테이너 실행
```
sudo docker run --rm -d -p 3306:3306 -v /tmp/data:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=password  -e MYSQL_DATABASE=bookmanagement -e MYSQL_USER=testuser -e MYSQL_PASSWORD=password mariadb
```