package ru.intterra.userservice.service

import org.springframework.stereotype.Service
import ru.intterra.userservice.dto.UserDto

@Service
class UserService : IUserService {
    override fun simplify(users: List<UserDto>): Map<String, Set<String>> {
        val result = mutableMapOf<String, MutableSet<String>>()
        val emailMap  = mutableMapOf<String, String>()

        for(user in users) {
            var emailDuplicate: String? = null
            for(email in user.emails) {
                if (emailMap.containsKey(email)) {
                    emailDuplicate = email
                    break
                }
            }

            var toUser: String
            if (emailDuplicate == null) {
                toUser = user.name
                result.put(toUser, user.emails)
            } else {
                toUser = emailMap[emailDuplicate]!!
                result[toUser]?.addAll(user.emails)
            }
            for(email in user.emails) {
                emailMap.put(email, toUser)
            }
        }

        return result
    }
}