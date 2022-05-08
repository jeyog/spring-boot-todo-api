package com.jeyog.springboottodoapi.validator

import com.jeyog.springboottodoapi.annotation.UniqueEmail
import com.jeyog.springboottodoapi.repository.UserRepository
import org.springframework.stereotype.Component
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Component
class UniqueEmailValidator(
    private val userRepository: UserRepository
): ConstraintValidator<UniqueEmail, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return !userRepository.existsByEmail(value!!)
    }

}