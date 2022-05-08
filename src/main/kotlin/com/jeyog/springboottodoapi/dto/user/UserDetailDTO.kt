package com.jeyog.springboottodoapi.dto.user

import com.jeyog.springboottodoapi.repository.entity.User

class UserDetailDTO(
    var id: Int,
    var username: String,
    var email: String,
    var name: String
) {
    constructor(user: User) : this(
        id = user.id!!,
        username = user.username,
        email = user.email,
        name = user.name
    )
}