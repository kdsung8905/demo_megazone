package com.example.demo_megazone.service;

import com.example.demo_megazone.config.SHA256;

import com.example.demo_megazone.data.MgzRole;
import com.example.demo_megazone.data.YN;
import com.example.demo_megazone.dto.request.LoginRequest;
import com.example.demo_megazone.dto.request.SignupRequest;

import com.example.demo_megazone.dto.response.FindMeResponse;
import com.example.demo_megazone.dto.response.RightsResponse;
import com.example.demo_megazone.dto.response.RoleResponse;
import com.example.demo_megazone.entity.Role;
import com.example.demo_megazone.entity.User;
import com.example.demo_megazone.repository.RoleRepository;
import com.example.demo_megazone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MgzService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public void signup(SignupRequest dto) throws Exception{

        //아이디 중복체크
        List<User> duplicated = userRepository.findAllByUserIdAndDelYN(dto.getUserId(), YN.N);

        if(duplicated.size() > 0){
            throw new HttpServerErrorException(HttpStatus.CONFLICT, "이미 사용중인 아이디 입니다.");
        }

        //비밀번호 암호화
        SHA256 sha256 = new SHA256();
        String password = sha256.encrypt(dto.getPassword());

        Role role = findRoleByRoleName(MgzRole.Empty.name());

        //신규가입자는 role을 갖지 않음
        User user = User.builder()
                .userId(dto.getUserId())
                .role(role)
                .password(password)
                .userName(dto.getName())
                .delYN(YN.N)
                .build();

        userRepository.save(user);

    }

    public void login(LoginRequest dto, HttpServletRequest request){

        User user = findUserByUserId(dto.getUserId());

        HttpSession session = request.getSession();

        //기존 정보가 있으면 삭제
        session.removeAttribute("loginUser");

        //현재 로그인 정보 등록
        session.setAttribute("loginUser", user.getUserId());

    }

    public FindMeResponse findMe(HttpServletRequest request){

        HttpSession session = request.getSession();

        if(session.getAttribute("loginUser") == null){
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "로그인 정보를 확인할 수 없습니다.");
        }

        String userId = (String) session.getAttribute("loginUser");

        User user = findUserByUserId(userId);

        RoleResponse roleDTO = null;

        if(user.getRole() != null){
            //현재 사용중인 role 과 role이 갖고 있는 권한을 dto 형태로 만드는 작업
            String roleName = user.getRole().getRoleName();
            List<RightsResponse> rightsList = user.getRole().getRightsList()
                    .stream()
                    .map(rights -> {
                        RightsResponse dto = RightsResponse.builder()
                                .rightsName(rights.getRightsName())
                                .build();
                        return dto;
                    })
                    .collect(Collectors.toList());

            roleDTO = RoleResponse.builder()
                    .roleName(roleName)
                    .rightsList(rightsList)
                    .build();
        }


        return FindMeResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .name(user.getUserName())
                .role(roleDTO)
                .build();
    }

    @Transactional
    public void changeRole(Long id, MgzRole role){

        User user = findUserById(id);

        Role savedRole = findRoleByRoleName(role.name());
        user.setRole(savedRole);
    }


    public User findUserByUserId(String userId){
        return userRepository.findByUserIdAndDelYN(userId, YN.N)
                .orElseThrow(()-> new HttpServerErrorException(HttpStatus.NOT_FOUND, "아이디, 비밀번호에 일치하는 회원이 없습니다."));
    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new HttpServerErrorException(HttpStatus.NOT_FOUND, "회원 정보를 조회할 수 없습니다."));
    }

    public Role findRoleByRoleName(String name){
        return roleRepository.findByRoleNameAndDelYN(name, YN.N)
                .orElseThrow(()-> new HttpServerErrorException(HttpStatus.NOT_FOUND, "역할(role) 정보를 조회할 수 없습니다."));
    }

}
