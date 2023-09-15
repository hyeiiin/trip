# Enjoy Trip Project

EnjoyTrip 프로젝트의 DB Table을 만들어 보고 Data를 추출하는 DAO를
작성하기

## 1. 프로젝트 목표
- 요구사항을 분석하고 DB Table을 구축할 수 있다.
- EnjoyTrip 프로젝트의 DB 영역의 역할을 이해하고, DAO 클래스와 DB 데이터를 연동하여 구현할 수 있다.

## 2. 개발언어/프로그램
- Java / Eclipse
- MySQL / MySQL Workbench / ERD 관련

## 3. 작업 순서

① 요구사항을 확인하고, 수정(개선)하여 정리한다.<br/> 
② 팀원과 같이 추가사항(사이트에 적용할 아이디어)을 논의하고 정리한다.<br/> 
③ 요구사항과 추가사항을 분석하고, 데이터를 추가할 DB Table을 만들어 본다.<br/> 
④ MySQL에 EnjoyTrip을 위한 DB System을 구축한다.<br/> 
⑤ 분석된 내용을 만족할 수 있도록 DAO 클래스를 설계한다.<br/> 
⑥ 샘플 프로젝트의 class diagram과 DB 구조를 파악하고 기능을 구현한다.<br/> 

## 4. 구현한 기능

### 1) 기본(필수) 기능

- 지역별, 컨텐츠별 관광지 정보 Table을 설계하고 데이터를 입력하고,
조회할 수 있는 DAO 클래스 구현

Class Diagram - Attraction

![image](/uploads/eab8d650e48d94f2169484430b2dd3c8/image.png)

### 2) 추가 기능

- 회원정보를 관리할 수 있는 Table 설계 및 DAO 클래스 구현.

Class Diagram - Member

![image](/uploads/7bcdf7603970a57422501010276ca687/image.png)

### 3) 심화 기능

- 게시판 등록, 수정, 조회, 삭제를 관리할 수 있는 Table 설계 및 DAO 클래스 구현

Class Diagram - Board

![image](/uploads/a446c1594cb93c53787d94e2064cbb34/image.png)

## 5. 실행 화면
 
 ### 1) 글 번호를 수정. ( subject 1->a content 1->b)
![image](/uploads/ec2db01b9463ba7f9877e8f5bf658286/image.png)  

 <br/> 
 <br/> 

### 2) 2 번으로 글목록을 조회. 현재는 조회수가 5인 상황에서 4번(글보기) 메뉴를 통하여 조회수가 1증가하여 6이 된 모습.
![image](/uploads/d6052cf5ef746d55d191112b877932a8/image.png)  
<br/> 
<br/> 


## 3) 1번으로 회원가입을 진행한 후에 로그인이 잘 되는 모습.
![image](/uploads/da1029da820d793e9826e6c77ed69b35/image.png)  
<br/> 
<br/> 

## 4) 4번으로 (아이디 a 비밀번호 e) 인 회원의 회원탈퇴를 진행한 모습.
![image](/uploads/da1029da820d793e9826e6c77ed69b35/image.png)


## 5) 지역, 컨텐츠 타입별 관광지 정보 검색.
### - 관광지역: 서울 / 관광타입: 여행코스 선택한 화면<br/> 
![image](/uploads/9ec29282d8bf983f0b0fec6f35d3f7fb/image.png)
<br/> 
<br/> 

## 6) 관광지명으로 관광지 정보 검색.
### - 탐색할 관광지: 공원 / 지역: 대전 선택한 화면<br/> 
![image](/uploads/4dd0a7d6257a82cb6cb5ef9705bf64dc/image.png)
<br/> 
<br/> 

