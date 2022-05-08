package com.jeyog.springboottodoapi.service

import com.jeyog.springboottodoapi.dto.user.UserCreationDTO
import com.jeyog.springboottodoapi.dto.user.UserDTO
import com.jeyog.springboottodoapi.dto.user.UserDetailDTO
import com.jeyog.springboottodoapi.exception.UserNotFoundException
import com.jeyog.springboottodoapi.repository.UserRepository
import com.jeyog.springboottodoapi.repository.entity.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepository.findByUsername(username!!)?: throw UserNotFoundException(username)
    }

    fun signUp(request: UserCreationDTO): UserDTO {
        var user = User(request)
        user.password = passwordEncoder.encode(user.password)
        user = userRepository.save(user)
        return UserDTO(user)
    }

    fun one(id: Int): UserDetailDTO {
        val user = userRepository.findById(id).orElseThrow {
            UserNotFoundException(id)
        }
        return UserDetailDTO(user)
    }
}