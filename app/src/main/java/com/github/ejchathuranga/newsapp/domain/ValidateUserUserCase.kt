package com.github.ejchathuranga.newsapp.domain

import com.github.ejchathuranga.newsapp.data.model.User
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import org.jetbrains.annotations.NotNull

class ValidateUserUserCase {
    fun validateUser(@NotNull user: User): ValidateResponse {
        if (user.username == null || user.username!!.isEmpty()) {
            return ValidateResponse(false, "Username Required")
        }
        if (user.email == null || user.email!!.isEmpty()) {
            return ValidateResponse(false, "Email Required")
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(user.email).matches())
            return ValidateResponse(false, "Wrong format on Email")

        if (user.age == null || user.age!!.isEmpty()) {
            return ValidateResponse(false, "Age Required")
        }
        if (user.pass == null || user.pass!!.isEmpty()) {
            return ValidateResponse(false, "Password Required")
        }
        if (user.passC == null || user.passC!!.isEmpty()) {
            return ValidateResponse(false, "Password Confirm Required")
        }
        if (!user.pass.equals(user.passC))
            return ValidateResponse(false, "Password Didn't Matched")

        return ValidateResponse(true, "")
    }
}