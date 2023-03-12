package com.example.demo_megazone.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "role")
public class RoleResponse {

    @Schema(description = "역할명")
    private String roleName;

    @Schema(description = "역할에서 사용 가능한 권한 목록")
    private List<RightsResponse> rightsList;

}

