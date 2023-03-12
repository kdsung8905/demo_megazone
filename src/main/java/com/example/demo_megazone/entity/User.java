package com.example.demo_megazone.entity;

import com.example.demo_megazone.data.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity(name = "mgz_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"role\"", columnDefinition = "bigint COMMENT 'role'")
    private Role role;

    @Column(name = "user_id")
    @Comment("로그인 아이디")
    private String userId;

    @Column(name = "password")
    @Comment("로그인 비밀번호")
    private String password;

    @Column(name = "user_name")
    @Comment("이름")
    private String userName;

    @Column(name = "del_yn")
    @Enumerated(STRING)
    @Comment("삭제여부")
    private YN delYN;
}
