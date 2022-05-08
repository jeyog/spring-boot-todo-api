package com.jeyog.springboottodoapi.annotation

import com.jeyog.springboottodoapi.validator.UniqueUsernameValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [UniqueUsernameValidator::class])
@Retention(AnnotationRetention.RUNTIME)
annotation class UniqueUsername(
    val message: String = "이미 사용 중인 사용자 이름입니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)