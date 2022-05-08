package com.jeyog.springboottodoapi.controller.v1

import com.jeyog.springboottodoapi.dto.user.UserCreationDTO
import com.jeyog.springboottodoapi.dto.user.UserDTO
import com.jeyog.springboottodoapi.dto.user.UserDetailDTO
import com.jeyog.springboottodoapi.service.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun signUp(@Valid @RequestBody request: UserCreationDTO): UserDTO {
        return userService.signUp(request)
    }

    @GetMapping("{id}")
    fun one(@PathVariable id: Int): UserDetailDTO {
        return userService.one(id)
    }
}