package ru.intterra.userservice.service

import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import ru.intterra.userservice.dto.UserDto

@RunWith(SpringRunner::class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private lateinit var userService: UserService

    @Test
    internal fun simplifyTest() {
        var list = listOf(
                UserDto("user1", mutableSetOf("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")),
                UserDto("user2", mutableSetOf("foo@gmail.com", "ups@pisem.net")),
                UserDto("user3", mutableSetOf("xyz@pisem.net", "vasya@pupkin.com")),
                UserDto("user4", mutableSetOf("ups@pisem.net", "aaa@bbb.ru")),
                UserDto("user5", mutableSetOf("xyz@pisem.net"))
        )

        var result = userService.simplify(list)

        assertEquals(2, result.size)
        assertTrue(result.containsKey("user1"))
        assertTrue(result.containsKey("user3"))
        assertEquals(mutableSetOf("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"), result["user1"])
        assertEquals(mutableSetOf("xyz@pisem.net", "vasya@pupkin.com"), result["user3"])
    }
}