package com.jeyog.springboottodoapi.controller.advice.user

import com.jeyog.springboottodoapi.dto.ErrorResponse
import com.jeyog.springboottodoapi.exception.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class UserNotFoundExceptionAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(ex: UserNotFoundException): ErrorResponse {
        return ErrorResponse(
            status = HttpStatus.NOT_FOUND,
            message = ex.message!!
        )
    }
}