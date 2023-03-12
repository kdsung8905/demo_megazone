# 과제 제출자 : 김대성

### 1. SWAGGER 주소 (http://localhost:8080/swagger-ui/index.html#/) 


### 2. 요구 사항 

* RBAC restApi 서버 구현(spring-security 이외의 방법 사용)

### 3. 구현 방법

* 1) role, rights, user 테이블을 구성합니다.
* 2) 각각의 user에게  role을 부여합니다.
* 3) spring interceptor에서 user의 role이 갖고있는 rights를 확인하여 uri와 비교 후 접근 가능 여부를 체크합니다.

### 4. role, rights 데이터

<img width="655" alt="스크린샷 2023-03-12 오후 10 22 13" src="https://user-images.githubusercontent.com/42694016/224547438-1862ab48-6274-4afd-92c9-46f13357f91a.png">

