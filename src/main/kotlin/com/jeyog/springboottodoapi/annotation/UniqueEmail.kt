package com.jeyog.springboottodoapi.annotation

import com.jeyog.springboottodoapi.validator.UniqueEmailValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [UniqueEmailValidator::class])
@Retention(AnnotationRetention.RUNTIME)
annotation class UniqueEmail(
    val message: String = "이미 사용 중인 이메일입니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)