📚 API 정의
---
1. 작품 조회 이력 API 
    - 작품별로 언제, 어떤 사용자가 조회했는지 이력을 조회합니다.
    - 특정사용자는 없이 모든 사용자가 어떤 작품을 조회했는지 이력이 나옵니다.
2. 인기 작품 조회 API
    - 사용자가 가장 많이 조회한 작품 상위 10개를  조회합니다.
3. 작품 구매 API
    - 작품에 각각 설정된 유료/무료 작품 기준으로 주문정보를 저장합니다.
    - 작품이 이벤트 기간에 무료 이벤트 기간에 해당하면 먼저체크하여 주문정보를 저장합니다.
4. 구매 인기작품 조회
    - 사용자가 가장 많이 구매한 작품 상위 10개를 조회합니다.
5. 작품 및 이력 삭제 API
    - 특정 작품과 함께 조회 이력도 모두 삭제합니다.
6. 선택사항 구현
   - 사용자 인증 구현
     - 사용자 등록 API
       - 사용자 정보를 등록합니다.
       - 인증 jwt 토큰 발행 됩니다.
     - 사용자 로그인 API
       - 사용자 로그인 진행을 합니다. 
       - 인증 jwt 토큰 발행 됩니다.
     - 사용자 인증을 활용한 주문 API
       - 앞에서 발행한 인증 검증후 주문을 진행 합니다.
   
 🚀 API 실행 방법
---

1. 프로젝트 클론:
   ```bash
   git clone https://github.com/leedaero/lezhinBackendProject.git
2. IDE 설정
   - 대중적으로 쓰는 인텔리제이 기준으로 설명하는점을 먼저 말씀드립니다.
   
   1. IDE Anonotation Processors 설정
   
   ![설정1](https://github.com/leedaero/lezhinBackendProject/blob/main/IDE_%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4%20%EC%85%8B%ED%8C%85_%EC%BF%A8%EB%9E%98%EC%8A%A4%ED%8C%8C%EC%9D%BC%20%EC%83%9D%EC%84%B1%EA%B4%80%EB%A0%A8%20%EC%84%A4%EC%A0%95.png?raw=trueg)
   
      
   2. IDE 빌드툴 그래들 설정

   ![설정2](https://github.com/leedaero/lezhinBackendProject/blob/main/IDE_%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4_%EC%85%8B%ED%8C%85_%EA%B7%B8%EB%9E%98%EB%93%A4%20%EC%84%A4%EC%A0%95.png?raw=true)

   3. 어플리케이션 실행을 위한 설정 edit Configurations

   ![설정3](https://github.com/leedaero/lezhinBackendProject/blob/main/IDE_%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4%20%ED%99%98%EA%B2%BD%EC%84%A4%EC%A0%951.png?raw=true)

   4. 어플리케이션 실행을 Active profiles local 설정

   ![설정4](https://github.com/leedaero/lezhinBackendProject/blob/main/IDE_%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4%20%ED%99%98%EA%B2%BD%EC%84%A4%EC%A0%952.png?raw=true)
   5. DB 연결설정 application-local.yml 
   - 로컬  url 192.168.0.34 주소만 메일로 전달드린 url 변경 해주시면 됩니다.
      ```yaml
      spring:
         datasource:
         url: jdbc:mysql://192.168.0.34:3306/lezhin?useSSL=false&serverTimezone=UTC
         username: xxxxx
         password: xxxxx
         driver-class-name: com.mysql.cj.jdbc.Driver
         hikari:
            minimum-idle: 5
            maximum-pool-size: 10
            idle-timeout: 30000
            max-lifetime: 1800000
            connection-timeout: 30000
            pool-name: HikariPool
   6. API 명세된 swagger-ui 접속 
      - url :  http://localhost:8080/swagger-ui/index.html
        - Swagger UI API 목록
        ![ui](https://github.com/leedaero/lezhinBackendProject/blob/main/%EC%8A%A4%EC%9B%A8%EA%B1%B0%20UI%20API%20%EB%AA%A9%EB%A1%9D.png?raw=true)
        
        - 사용자 인증 토큰 사용법 1
        ![토큰사용법 1](https://github.com/leedaero/lezhinBackendProject/blob/main/%EC%9D%B8%EC%A6%9D%EA%B4%80%EB%A0%A8%20%ED%86%A0%ED%81%B0%20%EC%9E%85%EB%A0%A51.png?raw=true)
        - 사용자 인증 토큰 사용법 2
          ![토큰사용법 2](https://github.com/leedaero/lezhinBackendProject/blob/main/%EC%9D%B8%EC%A6%9D%EA%B4%80%EB%A0%A8%20%ED%86%A0%ED%81%B0%20%EC%9E%85%EB%A0%A52.png?raw=true)
        - 사용자 인증 토큰 사용법 3
          ![토큰사용법 3](https://github.com/leedaero/lezhinBackendProject/blob/main/%EC%9D%B8%EC%A6%9D%EA%B4%80%EB%A0%A8%20%ED%86%A0%ED%81%B0%20%EC%9E%85%EB%A0%A53.png?raw=true)
        - 사용자 인증 토큰 사용법 4
          ![토큰사용법 4](https://github.com/leedaero/lezhinBackendProject/blob/main/%EC%9D%B8%EC%A6%9D%EA%B4%80%EB%A0%A8%20%ED%86%A0%ED%81%B0%20%EC%9E%85%EB%A0%A54.png?raw=true)
      7. API 상세
         1. 작품 조회 이력 API
         
         - request
            ```bash
           curl -X GET 'http://localhost:8080/v1/artworks/history'
            ```
          - response
             ``` json
               {
               "code": 200,
               "msg": "Request Success",
               "data": [
               {
               "artworkCode": "AR001001",
               "artworkName": "바퀴멘터리",
               "viewDate": "2024-12-03T08:46:22",
               "userId": "daerolee",
               "userName": "이대로"
               },
               {
               "artworkCode": "AR001001",
               "artworkName": "바퀴멘터리",
               "viewDate": "2024-12-03T08:46:52",
               "userId": "daerolee",
               "userName": "이대로"
               }, ....
              ```
      2. 인기 작품 조회 API
          - request
             ```bash
            curl -X GET 'http://localhost:8080/v1/artworks/best'
             ```
          - response
              ``` json
                {
                "code": 200,
                "msg": "Request Success",
                "data": [
                {
                "artworkCode": "AR001001",
                "artworkName": "바퀴멘터리",
                "viewDate": "2024-12-03T08:46:22",
                "userId": "daerolee",
                "userName": "이대로"
                },
                {
                "artworkCode": "AR001001",
                "artworkName": "바퀴멘터리",
                "viewDate": "2024-12-03T08:46:52",
                "userId": "daerolee",
                "userName": "이대로"
                }, ....
               ```
      3. 작품 구매 API 
            - request (무료작품 구매 요청) 
              ```bash
               curl -X POST   'http://localhost:8080/v1/orders' \-H 'accept: */*' \-H 'Content-Type: application/json' \-d '{"artworkCode": "AR001002","userId": "lezhin01"}'
              ```
         - response (무료작품 구매 응답)
            ``` json       
                { 
                  "code": 200,"msg": "Order Success!",       
                  "data": {
                  "artworkCode": "AR001002",
                  "userId": "AR001002",
                  "orderNo": "OR2024120716083151ba7f20",
                  "orderPrice": 0,
                  "paymentCode": "PM001",
                  "orderDate": "2024-12-07T16:08:31.701464",
                  "freeYn": "N"
                    }
                }
             ```
      4. 구매 인기작품 조회
         - request
            ```bash
             curl -X GET 'http://localhost:8080/v1/orders/best'
           ```
         - response
           ```bash
           {
              "code": 200,
              "msg": "Request Success",
              "data": [
               {
                "artworkCode": "AR001006",
                "artworkName": "소꿉친구가 자꾸 괴롭혀!",
                "orderCount": 19
              }.....
           ```
      5. 작품 및 이력 삭제 API
         - request
           ```bash
           curl -X DELETE 'http://localhost:8080/v1/artworks/AR001014'
           ```
         - response
           ```bash
           {
            "code": 200,
            "msg": "Data Delete Success"
           }
           ```
           

📌 개발내용
---
1. 개발환경
    - **언어** : Java 23
    - **프레임워크** : Spring boot 3.4
    - **데이터베이스** : Mysql 8.0.13
    - **IDE** : IntelliJ
    - **인증** : JWT ( 스프링 시큐리티 사용)
    - **ORM** : JPA , QueryDsl
2. 프로젝트 구조
   ![프로젝트 구조](https://github.com/leedaero/lezhinBackendProject/blob/main/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B5%AC%EC%A1%B0.png?raw=true)
3. 테이블 설계 구조
   ![테이블 구조](https://github.com/leedaero/lezhinBackendProject/blob/main/%ED%85%8C%EC%9D%B4%EB%B8%94%20%EC%84%A4%EA%B3%84ERD.png?raw=true)
    - t_artwork_mst : 작품 테이블
      - 작품 전반 적인 내용을 관리 합니다. 
    - t_artwork_view_history : 작품 이력 테이블
      - 작품의 유저의 조회한 이력을 관리 합니다.
    - t_event_mst : 이벤트 테이블
      - 이벤트 내역을 관리 하고 기간을 설정한 만큼 작픔의 유료/무료를 전환이 가능 합니다.
    - t_event_artwork_mapping : 이벤트 매핑 테이블
      - 이벤트 작품을 연결하는 역할을 합니다. 작품코드, 이벤트 코드를 등록/삭제를 통해 특정작품만 이벤트 제어를 합니다.
    - t_order_mst : 작품 구매테이블
      - 사용자가 구매한 내역을 저장합니다. 
    - t_user_mst : 사용자 테이블
      - 사용자 및 인증을 관리 합니다.

4. 코드 참고사항
   - 선택사항으로 사용인증 구현
     - @VerifyHeader 달아주면 해더 정보에서 jwt 사용하여 인증합니다.
     -   사용자 인증을 위한 사용자 등록 API
         - request
           ```bash
           curl -X POST 'http://localhost:8080/v1/external/auth/register'
            -H 'accept: */*' \
            -H 'Content-Type: application/json' \
            -d '{
              "userId": "daero53",
              "userName": "이대로3",
              "userPassword": "123456",
             "emailAddress": "daero53@naver.com",
            "phoneNumber": "01000000000"
            }'
           ```
         - response
           ```bash
           {
             "code": 200,
             "msg": "Request Success",
             "data": {
                 "token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IuydtOuMgOuhnDMiLCJzdWIiOiLsnbTrjIDroZwzIiwiaWF0IjoxNzMzNTc1NDU5LCJleHAiOjE3MzM2NjE4NTl9.FMXAGhywmHaSr73-ygDOjB1rrMJVh0qmjB87wAEs2BM"
            }
           }
           ```
     -   사용자 인증을 위한 로그인 인증 API
       - request
         ```bash
         curl -X POST 'http://localhost:8080/v1/external/auth/register'
          -H 'accept: */*' \
          -H 'Content-Type: application/json' \
          -d '{
            "userId": "daero53",
            "userPassword": "123456"
          }'
         ```
       - response
         ```bash
         {
           "code": 200,
           "msg": "Request Success",
           "data": {
             "token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IuydtOuMgOuhnDMiLCJzdWIiOiLsnbTrjIDroZwzIiwiaWF0IjoxNzMzNTc1NzY0LCJleHAiOjE3MzM2NjIxNjR9.d0o-EGj9EY8qQ-Er6Lh_M6U6zxpRELKyWNGjjmTn5Wg"
          }
         }
         ```
     -   @VerifyHeader 어노테이션 달아주면 해더 정보에서 jwt 사용하여 사용자를 인증합니다.
     -  앞에서 발행한 토큰을 넣어 주문을 진행합니다.
       - request
        ```bash
        curl -X POST 'http://localhost:8080/v1/external/orders'\
        -H 'accept: */*' \
        -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IuydtOuMgOuhnDMiLCJzdWIiOiLsnbTrjIDroZwzIiwiaWF0IjoxNzMzNTc1NzY0LCJleHAiOjE3MzM2NjIxNjR9.d0o-EGj9EY8qQ-Er6Lh_M6U6zxpRELKyWNGjjmTn5Wg' \
        -H 'Content-Type: application/json' \
        -d '{
            "artworkCode": "AR001007",
            "userId": "daero53"
        }'
     ```
        - response
        ```bash
        {
           "code": 200,
           "msg": "Order Success!",
           "data": {
           "artworkCode": "AR001007",
           "userId": "AR001007",
           "orderNo": "OR20241207215130f460d2c0",
           "orderPrice": 300,
           "paymentCode": "PM001",
           "orderDate": "2024-12-07T21:51:30.846606",
           "freeYn": "Y"
            }
      }
     ```


📌 고려했던 상황과 해결 방안
---
1. 민감정보에 대한 처리 방안
    - 문제 : DB연결 하는 사용하는 접속정보를 깃 퍼블릭한 곳에 노출됩니다.
    - 해결 :
      - Config Server (Spring Cloud Config) 활용
      - Config Server는 외부에 있는 중앙 집중형 환경 설정 서버로, 모든 서비스의 설정 파일을 한곳에서 관리할 수 있습니다.
2. 사용자 인증 구현을 개선하는 방안
    - 문제 : 토큰 탈취 위험이 있습니다.
    - 해결 : 
      - 서버에 사용자 정보를 서버 메모리 또는 DB에 세션으로 저장하고, 사용자에게는 세션 ID만 쿠키로 전달합니다.
      
