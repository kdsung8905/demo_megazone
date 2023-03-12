package com.example.demo_megazone.entity;

import com.example.demo_megazone.data.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity(name = "mgz_rights")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rights {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rights_name")
    @Comment("권한명")
    private String rightsName;

    @Column(name = "uri")
    @Comment("uri")
    private String uri;

    @Column(name = "del_yn")
    @Enumerated(STRING)
    @Comment("삭제여부")
    private YN delYN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"role\"", columnDefinition = "bigint COMMENT 'role'")
    private Role role;


}
