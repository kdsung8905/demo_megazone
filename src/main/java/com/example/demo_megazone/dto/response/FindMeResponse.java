package com.example.demo_megazone.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "내 정보")
public class FindMeResponse {

    @Schema(description = "회원id(pk)")
    private Long id;
    @Schema(description = "로그인 아이디")
    private String userId;
    @Schema(description = "이름")
    private String name;
    @Schema(description = "role")
    private RoleResponse role;
}
