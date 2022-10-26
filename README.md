# CleanArchitecture-Hilt-Kts

당일 박스 오피스 영화 순위 조회하기. 

- CleanArchitecture
- MVVM
- Hilt
- KTS
- DataBinding
- Retrofit(영화진흥위원회 open API), Postman, Json Converter
- Flow
- Coroutine
- Recyclerview (ListAdapter)

## CleanArchitecture
멀티 모듈 구성을 통해 독립적인 실행.
계층을 분리하여 관심사를 완전히 분리하는 것에 있다.

- App
- Data
- Domain
- Presentation


- 새로운 기능이 추가되거나 내부 로직이 변경되어야 할 때 유연하게 대처할 수 있도록 구조화할 수 있다.
- 프레임워크 독립적, 시스템을 프레임워크의 한정된 제약에 억지로 집어넣는 대신 도구로서 사용할 수 있다.
- UI 독립적, UI 변경 시 UI 외의 부분을 변경할 필요가 전혀 없다.
- 쉽고 빠른 테스트
- 그렇게 하려면, 모듈을 적절한 경계로 나눔으로서 한 모듈에 대해 변경사항이 생기면 다른 모듈을 건드릴 일이 없이 그 모듈만 건들게끔 설계해야 한다.
- 좋은 아키텍처는 툴과 프레임워크에 대한 결정사항을 최대한 뒤로 미룰 수 있어야 한다. 

![image](https://blog.coderifleman.com/images/the-clean-architecture/the-clean-architecture.jpg)

출처: https://blog.coderifleman.com/2017/12/18/the-clean-architecture/
