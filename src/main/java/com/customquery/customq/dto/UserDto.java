package com.customquery.customq.dto;

import com.customquery.customq.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;
    private boolean active;
    private long salary;

    public static User toEntity(UserDto userDto){
        User user = User.builder()
                .active(userDto.active)
                .username(userDto.username)
                .salary(userDto.salary)
                .build();
        return user;
    }

    public static UserDto toDto(User user){
        UserDto userDto = UserDto.builder()
                .active(user.isActive())
                .salary(user.getSalary())
                .username(user.getUsername())
                .build();
        return userDto;
    }

    public static List<UserDto> toDtoList(List<User> users) {
        return users.stream().map(UserDto::toDto).collect(Collectors.toList());
    }
}
