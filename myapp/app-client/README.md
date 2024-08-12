# 40. DBMS 도입하기

## 학습목표

- JDBC API와 JDBC Driver의 관계를 설명할 수 있다.
- JDBC 드라이버의 각 타입에 따라 동작하는 과정과 특징을 설명할 수 있다.
- JDBC API를 사용하여 DB의 데이터에 접근할 수 있다.

## 요구사항

- DBMS를 사용하여 데이터를 저장하라.

## 실행 결과

- 이전과 같다.

## 작업

- 데이터베이스에 테이블 생성 및 예제 데이터 입력
  - myapp_users, myapp_projects, myapp_boards 테이블 생성
  - 예제 데이터 입력
- MySQL JDBC Type4 드라이버 설정
  - build.gradle 변경
- DAO 구현체 생성 및 적용
  - UserDaoImpl 클래스 정의
  - BoardDaoImpl 클래스 정의
    - findBy()에서 날짜를 꺼낼 때 getTimestamp()를 사용
  - ProjectDaoImpl 클래스 정의
    - ProjectDao 인터페이스 변경
  - InitApplicationListener 변경
- 도메인 클래스 변경
  - Project 클래스 변경
    - 시작일, 종료일 타입을 String에서 java.sql.Date 으로 변경 

## 소스 파일

