# thymeleaf html 커스텀 속성
* th:data-{x}로 html 속성을 부여
```
<button th:data-args="${data.id}"></button>
```


# 참고자료
* [1] thymeleaf custom-attribute: https://www.baeldung.com/thymeleaf-custom-html-attributes
* [2] stackoverflow button args: https://stackoverflow.com/questions/9643311/pass-string-parameter-in-an-onclick-function