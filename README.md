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
   
 🚀 API 실행 방법
---
1. 개발환경
   - Version : Java 23
   - IDE : IntelliJ
   - Framework : SpringBoot 3.4
   - ORM : JPA , QueryDsl
2. 프로젝트 클론:
   ```bash
   git clone https://github.com/leedaero/lezhinBackendProject.git
3. IDE 설정
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
         - request
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
         - request
           ```bash
           {
            "code": 200,
            "msg": "Data Delete Success"
           }
           ```
           

📌 개발내용
---


📌 고려했던 상황과 해결 방안
---