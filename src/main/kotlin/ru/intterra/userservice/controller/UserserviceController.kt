package ru.intterra.userservice.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.intterra.userservice.dto.UserDto
import ru.intterra.userservice.service.IUserService

@RestController
class UserserviceController(
   private val userService: IUserService
) {

    @PostMapping("/simplify")
    fun simplify(@RequestBody users: List<UserDto>): List<UserDto> {
        return userService.simplify(users);
    }
}