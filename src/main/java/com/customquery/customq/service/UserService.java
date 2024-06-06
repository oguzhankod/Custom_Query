package com.customquery.customq.service;

import com.customquery.customq.dto.UserDto;
import com.customquery.customq.dto.UserRequest;
import com.customquery.customq.model.User;
import com.customquery.customq.repository.UserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDto createUser(UserRequest userRequest){
        User user = User.builder()
                .active(userRequest.isActive())
                .username(userRequest.getUsername())
                .salary(userRequest.getSalary())
                .build();

        var users = userRepository.save(user);


        return UserDto.toDto(users);

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public List<UserDto> getActiveUsersJPA() {
        List<User> activeUsers = userRepository.findByActiveTrue();
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> getActiveUsersJPQL() {
        List<User> activeUsers = userRepository.findActiveUsersJPQL();
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> getActiveUsersNative() {
        List<User> activeUsers = userRepository.findActiveUsersNative();
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findByUsernameAndActiveTrueJPA(String username) {
        List<User> activeUsers = userRepository.findByUsernameAndActiveTrue(username);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findByUsernameAndActiveTrueJPQL(String username) {
        List<User> activeUsers = userRepository.findActiveUsersByUsernameJPQL(username);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findByUsernameAndActiveTrueNative(String username) {
        List<User> activeUsers = userRepository.findActiveUsersByUsernameNative(username);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryGreaterThanJPA(long salary) {
        List<User> activeUsers = userRepository.findBySalaryGreaterThan(salary);
        return UserDto.toDtoList(activeUsers);
    }


    public List<UserDto> findBySalaryGreaterThanJPQL(long salary) {
        List<User> activeUsers = userRepository.findUsersWithSalaryGreaterThanJPQL(salary);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryGreaterThanNative(long salary) {
        List<User> activeUsers = userRepository.findUsersWithSalaryGreaterThanNative(salary);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryBetweenJPA(long minSalary, long maxSalary) {
        List<User> activeUsers = userRepository.findBySalaryBetween(minSalary, maxSalary);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryBetweenJPQL(long minSalary, long maxSalary) {
        List<User> activeUsers = userRepository.findUsersWithSalaryBetweenJPQL(minSalary, maxSalary);
        return UserDto.toDtoList(activeUsers);
    }

    public List<UserDto> findBySalaryBetweenNative(long minSalary, long maxSalary) {
        List<User> activeUsers = userRepository.findUsersWithSalaryBetweenNative(minSalary, maxSalary);
        return UserDto.toDtoList(activeUsers);
    }

    public long countActiveUsersJPA() {
        return userRepository.countByActiveTrue();
    }

    public long countActiveUsersJPQL() {
        return userRepository.countActiveUsersJPQL();
    }

    public long countActiveUsersNative() {
        return userRepository.countActiveUsersNative();
    }
}
