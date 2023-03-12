package com.example.demo_megazone.controller;

import com.example.demo_megazone.data.MgzRole;
import com.example.demo_megazone.dto.request.LoginRequest;
import com.example.demo_megazone.dto.request.SignupRequest;
import com.example.demo_megazone.dto.response.FindMeResponse;
import com.example.demo_megazone.dto.response.RoleResponse;

import com.example.demo_megazone.service.MgzService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Tag(name = "demo", description = "")
@RestController
@RequestMapping("/mgz")
@RequiredArgsConstructor
public class mgzController {

    private final MgzService mgzService;

    @Operation(summary = "회원가입", description = "회원가입")
    @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = Void.class)))
    @PostMapping("/signup")
    public ResponseEntity signup(@Parameter(name = "회원정보", description = "회원정보") @RequestBody SignupRequest dto) throws Exception {
        mgzService.signup(dto);
        return ResponseEntity.created(URI.create("")).build();
    }

    @Operation(summary = "로그인", description = "로그인")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Void.class)))
    @PostMapping("/login")
    public ResponseEntity login(
            @Parameter(name = "로그인정보", description = "로그인정보") @RequestBody LoginRequest dto,
            HttpServletRequest request) {
        mgzService.login(dto, request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "내 정보 보기", description = "내 정보 보기")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = FindMeResponse.class)))
    @PostMapping("/find-me")
    public ResponseEntity findMe(
            HttpServletRequest request) {
        return ResponseEntity.ok().body(mgzService.findMe(request));
    }


    @Operation(summary = "회원 role 변경", description = "회원 role 변경")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Void.class)))
    @PatchMapping("/role/{id}")
    public ResponseEntity changeRole(
            @Parameter(name = "id", description = "회원id(pk)") @PathVariable Long id,
            @Parameter(name = "role", description = "변경 할 role") @RequestParam MgzRole role
    ) {
        mgzService.changeRole(id, role);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "edit system files(api접근 권한만 테스트)", description = "edit system files")
    @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = RoleResponse.class)))
    @PutMapping("/system-files")
    public ResponseEntity editSystemFiles() {
        return ResponseEntity.created(URI.create("")).build();
    }

    @Operation(summary = "Access Network(api접근 권한만 테스트)", description = "Access Network")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = RoleResponse.class)))
    @GetMapping ("/network")
    public ResponseEntity AccessNetwork() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "edit user files(api접근 권한만 테스트)", description = "edit user files")
    @ApiResponse(responseCode = "201", description = "성공", content = @Content(schema = @Schema(implementation = RoleResponse.class)))
    @PutMapping ("/user-files")
    public ResponseEntity editUserFiles() {
        return ResponseEntity.created(URI.create("")).build();
    }

    @Operation(summary = "read/foo/bar files(api접근 권한만 테스트)", description = "read/foo/bar files")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = RoleResponse.class)))
    @GetMapping ("/read-files")
    public ResponseEntity read() {
        return ResponseEntity.ok().build();
    }
}
