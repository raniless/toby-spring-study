# toby-spring-study
토비의 스프링 Vol2 3.1 Study
- Member : Hyunmin Kim, Miyoung Jung, Hyoki Min
- The first round started on November 18 and ended on December 14
- forked from hmkim829/toby-spring-study since 2020.12.29
---

# 1장 IoC 컨테이너와 DI
### 1.1 IoC 컨테이너: 빈 팩토리와 애플리케이션 컨텍스트
- [1.1.1 IoC 컨테이너를 이용해 애플리케이션 만들기](/wiki/chapter1/part1/1.1.1.md)
- [1.1.2 IoC 컨테이너의 종류와 사용 방법](/wiki/chapter1/part1/1.1.2.md)
- [1.1.3 IoC 컨테이너 계층구조](/wiki/chapter1/part1/1.1.3.md)
- [1.1.4 웹 애플리케이션의 IoC 컨테이너 구성](/wiki/chapter1/part1/1.1.4.md)

### 1.2 IoC/DI를 위 빈 설정 메타정보 작성
- [1.2.1 빈 설정 메타정보](/wiki/chapter1/part2/1.2.1.md)
- [1.2.2 빈 등록 방법](/wiki/chapter1/part2/1.2.2.md)
- [1.2.3 빈 의존관계 설정 방법](/wiki/chapter1/part2/1.2.3.md)
- [1.2.4 프로퍼티 값 설정 방법](/wiki/chapter1/part2/1.2.4.md)
- [1.2.5 컨테이너가 자동등록하는 빈](/wiki/chapter1/part2/1.2.5.md)

### 1.3 프로토타입과 스코프
- [1.3.1 프로토타입 스코프](/wiki/chapter1/part3/1.3.1.md)
- [1.3.2 스코프](/wiki/chapter1/part3/1.3.2.md)

### 1.4 기타 빈 설정 메타정보
- [1.4.1 빈이름](/wiki/chapter1/part4/1.4.1.md)
- [1.4.2 빈 생명주기 메소드](/wiki/chapter1/part4/1.4.2.md)
- [1.4.3 팩토리 빈과 팩토리 메소드](/wiki/chapter1/part4/1.4.3.md)

### 1.5 스프링 3.1의 IOC 컨테이너와 DI
- [1.5.1 빈의 역할과 구분](/wiki/chapter1/part5/1.5.1.md)
- [1.5.2 컨테이너 인프라 빈을 위한 자바 코드 메타정보](/wiki/chapter1/part5/1.5.2.md)
- [1.5.3 웹 애플리케이션의 새로운 IoC 컨테이너 구성](/wiki/chapter1/part5/1.5.3.md)
- [1.5.4 런타임 환경 추상화와 프로파일](/wiki/chapter1/part5/1.5.4.md)
- [1.5.5 프로퍼티 소스](/wiki/chapter1/part5/1.5.5.md)

---

# 2장 데이터 액세스 기술
### 2.6 트랜잭션
- [2.6.1 트랜잭션 추상화와 동기화](/wiki/chapter2/part6/2.6.1.md)
- [2.6.2 트랜잭션 경계설정 전략](/wiki/chapter2/part6/2.6.2.md)
- [2.6.3 트랜잭션 속성](/wiki/chapter2/part6/2.6.3.md)
- [2.6.4 데이터 액세스 기술 트랜잭션의 통합](/wiki/chapter2/part6/2.6.4.md)
- [2.6.5 JTA를 이용한 글로벌/분산 트랜잭션](/wiki/chapter2/part6/2.6.5.md)

### 2.7 스프링 3.1의 데이터 액세스 기술
- [2.7.3 @EnableTransactionManager](/wiki/chapter2/part7/2.7.3.md)

---

# 3장 스프링 웹 기술과 스프링 MVC
### 3.1 스프링의 웹 프레젠테이션 계층 기술
- [3.1.1 스프링에서 사용되는 웹 프레임워크의 종류](/wiki/chapter3/part1/3.1.1.md)
- [3.1.2 스프링 MVC와 DispatcherServlet 전략](/wiki/chapter3/part1/3.1.2.md)

### 3.2 스프링 웹 애플리케이션 환경 구성
- [3.2.1 간단한 스프링 웹 프로젝트 생성](/wiki/chapter3/part2/3.2.1.md)
- [3.2.2 스프링 웹 학습 테스트](/wiki/chapter3/part2/3.2.2.md)

### 3.3 컨트롤러
- [3.3.1 컨트롤러의 종류와 핸들러 어댑터](/wiki/chapter3/part3/3.3.1.md)
- [3.3.2 핸들러 매핑](/wiki/chapter3/part3/3.3.2.md)
- [3.3.3 핸들러 인터셉터](/wiki/chapter3/part3/3.3.3.md)
- [3.3.4 컨트롤러 확장](/wiki/chapter3/part3/3.3.4.md)

### 3.4 뷰
- [3.4.1 뷰](/wiki/chapter3/part4/3.4.1.md)
- [3.4.2 뷰 리졸버](/wiki/chapter3/part4/3.4.2.md)

### 3.5 기타 전략
- [3.5.1 핸들러 예외 리졸버](/wiki/chapter3/part5/3.5.1.md)
- [3.5.2 지역정보 리졸버](/wiki/chapter3/part5/3.5.2.md)
- [3.5.3 멀티파트 리졸버](/wiki/chapter3/part5/3.5.3.md)