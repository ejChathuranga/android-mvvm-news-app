package com.github.ejchathuranga.newsapp.data.model

data class LoginUser(var username: String, var password: String) {
    fun validate(username: String?, password: String?): ValidateResponse {
        if (username == null || username.toString().isEmpty()) {
            return ValidateResponse(false, "Wrong username")
        }
        if (password == null || password.toString().isEmpty()) {
            return ValidateResponse(false, "Wrong password")
        }
        return ValidateResponse(true, "")
    }
}