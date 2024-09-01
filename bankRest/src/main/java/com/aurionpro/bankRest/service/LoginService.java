package com.aurionpro.bankRest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aurionpro.bankRest.dto.LoginDto;
import com.aurionpro.bankRest.dto.PageResponse;
import com.aurionpro.bankRest.entity.Login;
import com.aurionpro.bankRest.repository.LoginRepository;
import com.aurionpro.bankRest.utils.EntityToDtoConverter;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginDto createLogin(Login login) {
        Login savedLogin = loginRepository.save(login);
        return EntityToDtoConverter.toLoginDto(savedLogin);
    }

    public LoginDto getLoginById(int loginId) {
        Optional<Login> login = loginRepository.findById(loginId);
        return login.map(EntityToDtoConverter::toLoginDto).orElse(null);
    }

    public PageResponse<LoginDto> getAllLogins(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Login> loginPage = loginRepository.findAll(pageRequest);

        List<LoginDto> content = loginPage.getContent().stream()
                .map(EntityToDtoConverter::toLoginDto)
                .collect(Collectors.toList());

        return new PageResponse<>(
                loginPage.getTotalPages(),
                loginPage.getSize(),
                loginPage.getTotalElements(),
                content,
                loginPage.isLast()
        );
    }

    public LoginDto updateLogin(int loginId, Login updatedLogin) {
        Optional<Login> existingLogin = loginRepository.findById(loginId);
        if (existingLogin.isPresent()) {
            Login login = existingLogin.get();
            login.setUsername(updatedLogin.getUsername());
            login.setPassword(updatedLogin.getPassword());
            login.setLoginType(updatedLogin.getLoginType());
            Login savedLogin = loginRepository.save(login);
            return EntityToDtoConverter.toLoginDto(savedLogin);
        }
        return null;
    }

    public void deleteLogin(int loginId) {
        loginRepository.deleteById(loginId);
    }
}
