package com.example.demo_megazone.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "로그인")
public class LoginRequest {

    @Schema(description = "로그인 아이디", example = "systemAdmin")
    private String userId;
    @Schema(description = "로그인 아이디", example = "1234")
    private String password;
}
