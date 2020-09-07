javascript에서 thymeleaf변수를 사용하려면 **[[*{변수이름}]]**로 사용한다.  


```
$.ajax({
                type: 'put',
                url: '/book/api/update/' + [[${book.id}]],
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
```