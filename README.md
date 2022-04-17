# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 😍 Constraint Check List
* 요구사항 1
  * [x] ~~시작점 main()~~
  * [x] ~~JDK 8~~
  * [x] ~~camp.nextstep.edu.missionutils~~
  * [ ] 2개의 테스트 케이스
* 요구사항 2
  * [x] ~~자바 코드 컨벤션~~
  * [ ] Indent depth == 1
  * [ ] Stream api는 사용하지 않는다. Lambda는 가능.
  * [ ] else 사용 금지
  * [ ] 함수 라인 길이 <= 10
* 요구사항 3
  * [ ] 도메인 로직에 단위테스트를 구현
  * [ ] Junit 학습하기
* 과제진행 요구사항
  * [x] ~~folk/clone으로 시작~~
  * [ ] 기능구현 전 Readme.md에 정리
  * [ ] commit 단위는 의미있는 단위로
  * [ ] 프리코스 과제 제출 문서
* 기타
  * [x] ~~MVC 구조~~
  * [ ] Validate Code 추가
  * [ ] IllegalArgumentException 처리

## 🍔 Feature
* [x] Computher : 임의의 3자리 숫자 생성 --> Answer
  * [x] 숫자 범위는 1~9
  * [x] 숫자는 겹쳐지면 안된다. (ex. 111은 불가)
* [x] Player : 3자리 숫자를 입력할 수 있다 --> Input
* [x] Computher : 입력한 숫자의 힌트를 제공한다 --> Hint
  * [x] 스트라이크 갯수를 셀 수 있다
  * [x] 볼 갯수를 셀 수 있다
  * [x] 낫싱을 확인할 수 있다
  * [x] 최종 정답을 확인할 수 있다
* [x] Computher : 정답을 맞추면 게임 종료 or 재시작
* [x] Player : 게임 종료 or 재시작을 선택
* [ ] Computher : 잘못된 값이 입력되면 IllegalArgumentException 발생 후 애플리케이션 종료

## ⚾️ Example
```
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

## 🐯 Task
* **branch : step0/constraint**
  * 제약사항 중 일부를 확인
  * Random 및 Scanner API 대신 사용할 라이브러리
    * camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API
  * 자바 코드 컨벤션
* **branch : step1/makegame**
  * 게임 생성 및 정답용 숫자 생성
  * 정답용 3자리 숫자에는 중복 숫자가 없어야 한다
  * 플레이어가 숫자를 입력할 수 있어야 한다.
* **branch : step2/showhint**
  * 입력한 숫자의 힌트를 확인할 수 있다.
  * 정답을 맞췄을 경우, 재시도와 종료를 고를 수 있다.
* **branch : step3/refactor**
  * MVC 구조로 변경
  * Validate code 추가
  * IllegalArgumentException 처리
