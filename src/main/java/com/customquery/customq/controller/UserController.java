package com.customquery.customq.controller;

import com.customquery.customq.dto.UserDto;
import com.customquery.customq.dto.UserRequest;
import com.customquery.customq.model.User;
import com.customquery.customq.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest userRequest){
        var user =userService.createUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/jpa/active")
    public List<UserDto> getActiveUsersJPA() {
        return userService.getActiveUsersJPA();
    }

    @GetMapping("/jpql/active")
    public List<UserDto> getActiveUsersJPQL() {
        return userService.getActiveUsersJPQL();
    }

    @GetMapping("/jpa/findByUsernameAndActiveTrue")
    public List<UserDto> findByUsernameAndActiveTrueJPA(@RequestParam String username) {
        return userService.findByUsernameAndActiveTrueJPA(username);
    }

    @GetMapping("/jpql/findByUsernameAndActiveTrue")
    public List<UserDto> findByUsernameAndActiveTrueJPQL(@RequestParam String username) {
        return userService.findByUsernameAndActiveTrueJPQL(username);
    }

    @GetMapping("/native/findByUsernameAndActiveTrue")
    public List<UserDto> findByUsernameAndActiveTrueNative(@RequestParam String username) {
        return userService.findByUsernameAndActiveTrueNative(username);
    }

    @GetMapping("/jpa/findBySalaryGreaterThan/{salary}")
    public List<UserDto> findBySalaryGreaterThanJPA(@PathVariable long salary) {
        return userService.findBySalaryGreaterThanJPA(salary);
    }

    @GetMapping("/jpql/findBySalaryGreaterThan/{salary}")
    public List<UserDto> findBySalaryGreaterThanJPQL(@PathVariable long salary) {
        return userService.findBySalaryGreaterThanJPQL(salary);
    }

    @GetMapping("/native/findBySalaryGreaterThan/{salary}")
    public List<UserDto> findBySalaryGreaterThanNative(@PathVariable long salary) {
        return userService.findBySalaryGreaterThanNative(salary);
    }

    @GetMapping("/jpa/findBySalaryBetween/{minSalary}/{maxSalary}")
    public List<UserDto> findBySalaryBetweenJPA(@PathVariable long minSalary, @PathVariable long maxSalary) {
        return userService.findBySalaryBetweenJPA(minSalary, maxSalary);
    }

    @GetMapping("/jpql/findBySalaryBetween/{minSalary}/{maxSalary}")
    public List<UserDto> findBySalaryBetweenJPQL(@PathVariable long minSalary, @PathVariable long maxSalary) {
        return userService.findBySalaryBetweenJPQL(minSalary, maxSalary);
    }

    @GetMapping("/native/findBySalaryBetween/{minSalary}/{maxSalary}")
    public List<UserDto> findBySalaryBetweenNative(@PathVariable long minSalary, @PathVariable long maxSalary) {
        return userService.findBySalaryBetweenNative(minSalary, maxSalary);
    }

    @GetMapping("/jpa/countActiveUsers")
    public long countActiveUsersJPA() {
        return userService.countActiveUsersJPA();
    }

    @GetMapping("/jpql/countActiveUsers")
    public long countActiveUsersJPQL() {
        return userService.countActiveUsersJPQL();
    }

    @GetMapping("/native/countActiveUsers")
    public long countActiveUsersNative() {
        return userService.countActiveUsersNative();
    }

}
