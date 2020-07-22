package ru.intterra.userservice.service

import org.springframework.stereotype.Service
import ru.intterra.userservice.dto.UserDto

@Service
class UserService : IUserService {
    override fun simplify(users: List<UserDto>): List<UserDto> {
        val userMap  = mapOf<String, String>();
        val emailMap  = mapOf<String, String>();

        users.forEach{

        }

    }
}