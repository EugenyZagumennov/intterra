package ru.intterra.userservice.service

import ru.intterra.userservice.dto.UserDto

interface IUserService {
    fun simplify(users: List<UserDto>):  Map<String, Set<String>>
}