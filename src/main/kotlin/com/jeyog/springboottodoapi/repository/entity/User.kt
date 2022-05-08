package com.jeyog.springboottodoapi.repository.entity

import com.jeyog.springboottodoapi.dto.user.UserCreationDTO
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(nullable = false, unique = true)
    private val username: String,
    @Column(nullable = false)
    private var password: String,
    @Column(nullable = false)
    var email: String,
    @Column(nullable = false)
    val name: String
) : BaseTimeEntity(), UserDetails {

    constructor(userCreation: UserCreationDTO) : this(
        username = userCreation.username,
        password = userCreation.password,
        email = userCreation.email,
        name = userCreation.name
    )

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }

    override fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}