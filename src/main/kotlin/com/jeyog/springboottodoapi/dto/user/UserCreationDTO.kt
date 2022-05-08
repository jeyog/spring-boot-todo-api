package com.jeyog.springboottodoapi.dto.user

import com.jeyog.springboottodoapi.annotation.UniqueEmail
import com.jeyog.springboottodoapi.annotation.UniqueUsername
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserCreationDTO(
    @field:NotBlank(message = "사용자 이름을 입력하세요.")
    @field:UniqueUsername
    var username: String,
    @field:NotBlank(message = "비밀번호를 입력하세요.")
    var password: String,
    @field:NotBlank(message = "이메일을 입력하세요.")
    @field:Email(message = "잘못된 이메일 형식입니다.")
    @field:UniqueEmail
    var email: String,
    @field:NotBlank(message = "이름을 입력하세요.")
    var name: String
) {
}