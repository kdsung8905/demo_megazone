package com.example.demo_megazone.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "회원가입")
public class SignupRequest {

    @Schema(description = "로그인 아이디", example = "test")
    private String userId;

    @Schema(description = "비밀번호", example = "1234")
    private String password;

    @Schema(description = "이름", example = "홍길동")
    private String name;

}
