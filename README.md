JPA-Mini-Project (08/23~26)

# 🏥 환자 관리 프로그램

- 환자의 기본정보
- 질병&처방 상세 내역 확인


## 🥼 팀 구성원

🧡 김한나 = [https://github.com/aNnaHmiK](https://github.com/aNnaHmiK)

💜 마유진 = [https://github.com/YoojinMa](https://github.com/YoojinMa)

💚 이태경 = [https://github.com/gaetaegoo](https://github.com/gaetaegoo)


## 🎯 학습 목표

MVC + DAO + Entity 활용하기

- MVC 실패
- DAO 성공
- Entity 성공

## 🗂️ 엔티티 관계도

- ERD

    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/20960424-b1d7-4d3b-bbf1-e26002cd6c1e/Untitled.png)

## 😥 **ISSUES**

- 08/24
    - DDL, DML 먼저 만들어서 sqlplus 이용해서 테이블을 생성하는데 한글을 잘 인식하지 못해서 데이터가 정상적으로 입력되지 않음 (ORA-01756: quoted string not properly terminated)
        - [해결] Dbeaver에서 해당 파일을 열어서 깨진 한글을 다시 입력하니 sqlplus에서 정상적으로 입력됨 (but 이클립스에서 파일을 확인해 보니 이번엔 이클립스에서 한글이 깨짐)
        - [원인] 싱글쿼터( ' )가 입력되지 않았다는 의미의 에러인데, 모든 쿼리가 이상이 없었고, sqlplus에서 직접 쿼리를 입력하는 경우에는 정상적으로 입력됨. 정확한 원인은 잘 모르겠지만 한글을 인식하는 과정에서 문제가 생긴 듯 함
- 08/25
    - @ManyToMany를 적용하려고 찾아보니 중간 엔티티 테이블을 생성해서 @OneToMany와 @ManyToOne으로 테이블을 연결하라고 함. 그래서 연결했는데 처음에는 테이블의 관계를 잘못 설정해서 @OneToMany와 @ManyToOne의 순서가 바뀌었음. 다시 바꿨는데도 계속 에러가 남
        - [해결] PK를 long 타입으로 바꿔줌
        - [원인] 엔티티의 PK는 long 또는 int로 설정하는 게 안정적임

    - DROP&CREATE TEST 진행이 되었으나, SQL PLUS에서 DESK 테이블을 확인할 수 없음
        - [해결] 데이터 생성시에 DESK 데이터의 값을 Patient에 대입
        - [원인] 테이블 간 매핑된 관계를 데이터로 넣지 않아서 발생

    - ManyToOne, OneToMany의 호환이 잘 되지않음, ManyToMany 관계로 만드려 하였으나 오류 발생
        - [해결] 기존 만들어 두었던 모든 프로젝트파일을 삭제, 새로 프로젝트를 시작함. 클래스와 테이블간의 관계를 새로 성립시켜 Recipe,Patient,Disease 구성 및 제작
        - [원인] Recipe,Patien,Clinc,Desk 등 클래스간의 PK/FK 등의 관계모호, 맵핑불가, AarrayList를 통한 리스트 불러오기 불가

    - tx.commit() 할 때 계속 에러 발생
        - [해결] 각 Entity에서 PK를 시퀀스로 생성한 숫자 값으로 설정
        - [원인] Entity는 PK를 설정할 때 String이면 이슈 발생하는 듯
- 08/26
    - 25일의 반복, DAO와 Controller를 연결하는중 오류 발생
    - ManyToOne & OneToMany 에서 fech EAGER & LAZY 오류
    - RecipeDAO 에서 삭제 기능 불가
        - [해결] RecipeDAO 클래스 안에 rDelete 제외
        - [원인] Recipe 는 Patient & Disease 와 자식 부모 관계로 삭제 할 수 없는 관계

- Github
    - push를 하는 과정에서 새로 수정이 진행된 파일만 업로드가 되고 전체 파일이 업로드가 안되는 경우가 발생, Gitbash를 통하여 전체 파일을 add 및 commit을 진행하였으나, 파일이 누락된채 업로드 진행
        - [해결] 수정된 파일만 필요할 시 Github에서 install 진행, 전체파일 필요시 드라이브로 파일 공유
        - [원인] 아직 모르겠음

## 😊 **REFACTORING**

- 08/25
    - 변수 설정 줄이기

        ```java
        // 수정 전
        List<Patient> all = em.createNamedQuery("Patient.findAll").getResultList();
        all.forEach(v -> System.out.println(v));

        // 수정 후
        em.createNamedQuery("recipe.findAll").getResultList().forEach(v -> System.out.println(v));
        ```

    - NamedQuerry문 사용

        ```java
        @NamedQuery(query = "select d from disease d", name = "disease.findAll")
        @NamedQuery(query = "select d from disease d where d.sign=:sign", name = "disease.findBysign")
        ```

    - @ManyToOne 사용

        ```java
        	@ManyToOne(fetch = FetchType.LAZY)
        	@JoinColumn(name = "recipe_no")
        	private Recipe rNo;
        ```

        @ManyToOne(fetch = FetchType.EAGER) - AarrayList를 불러 올 수 있음

- 08/26
    - toString에서 StringBuilder 사용

        ```java
        @Override
            public String toString() {
               StringBuilder builder = new StringBuilder();
               builder.append(" 1) 질병 번호 : ");
               builder.append(dNo);
               builder.append("\n 2) 증상 : ");
               builder.append(sign);
               builder.append("\n 3) 일반 검사 여부 : ");
               builder.append(general);
               builder.append("\n 4) 정밀 검사 여부 : ");
               builder.append(test);
               builder.append("\n 5) 수술 여부 : ");
               builder.append(surgery);
               builder.append("\n 6) 처방 정보 : ");
               builder.append(rNo + "\n");
               return builder.toString();
            }
        ```

## 👿 아쉬운 -> 개선할 부분

- 처음에 테이블 4개의 매핑 관계를 잘못 생각함

    -> 다음엔 오래 걸리더라도 테이블 간의 관계를 견고하게 만들고 넘어가자

- @ManyToMany를 @OneToMany, @ManyToOne으로 변경할 때 테이블 구성을 잘못 생각함

    -> 기존 테이블 관계에서 벗어나지 말자

- 기본 구조 계획이 탄탄하지 못해서 계속 꼬리를 물고 에러가 생김

    -> 처음에 노션에서 다같이 명확한 테이블을 써놓고 공유하면서 코드를 구현하자

## 🤗 감사합니다

- 첫 날부터 계속된 에러 파티로 여러 조에 방문했는데, 좋은 조언들을 해주셔서 감사합니다.
- 3일 동안 계속 고생하다가 테이블을 다시 생성했는데, 함께 고생하신 우리 조원들 감사합니다.
