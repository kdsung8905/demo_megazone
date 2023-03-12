package com.example.demo_megazone.entity;

import com.example.demo_megazone.data.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity(name = "mgz_role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    @Comment("역할명")
    private String roleName;

    @Column(name = "del_yn")
    @Enumerated(STRING)
    @Comment("삭제여부")
    private YN delYN;

    @OneToMany(mappedBy = "role")
    private List<Rights> rightsList = new ArrayList<>();


}
