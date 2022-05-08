package com.jeyog.springboottodoapi.exception

class UserNotFoundException(value: Any): RuntimeException("Could not find user $value")