package com.jeyog.springboottodoapi.validator

import com.jeyog.springboottodoapi.annotation.UniqueUsername
import com.jeyog.springboottodoapi.repository.UserRepository
import org.springframework.stereotype.Component
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Component
class UniqueUsernameValidator(
    private val userRepository: UserRepository
): ConstraintValidator<UniqueUsername, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return !userRepository.existsByUsername(value!!)
    }

}