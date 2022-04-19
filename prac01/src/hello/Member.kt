package hello

import java.time.Instant

// 클래스는 기본적으로 상속 불가. 확장하려면 부모 클래스  open 으로 선언
class Member(name: String, registered: Instant): Person2(name, registered)

// 클래스 확장과 인터페이스 구현에 같은 구문을 사용