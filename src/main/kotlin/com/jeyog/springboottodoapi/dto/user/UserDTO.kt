package com.jeyog.springboottodoapi.dto.user

import com.jeyog.springboottodoapi.repository.entity.User

data class UserDTO(
    var id: Int,
    var username: String,
    var name: String
) {
    constructor(user: User) : this(
        id = user.id!!,
        username = user.username,
        name = user.name
    )
}