package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


// DB 테이블
// 클래스 위에 선언하여 이 클래스가 엔티티임을 알려준다.
// 이렇게 되면 JPA에서 정의된 필드들을 바탕으로 데이터베이스에 테이블을 만들어준다.
@Entity
@Getter @Setter
public class Member {

    // 해당 엔티티의 주요 키(Primary Key, PK)가 될 값을 지정해주는 것이 @Id
    // @GeneratedValue는 이 PK가 자동으로 1씩 증가하는 형태로 생성될지 등을 결정해주는 어노테이션이다.
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    // 숨겨서 address를 만듦
    @Embedded
    private Address address;

    // order테이블이랑 1대 다 관계(리스트로 가져옴)
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
