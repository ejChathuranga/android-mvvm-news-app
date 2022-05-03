package com.github.ejchathuranga.newsapp.data.model

data class ValidateResponse(val success: Boolean, var msg: String, var data: Any?) {
    constructor(success: Boolean) : this(success, "", null)
    constructor(success: Boolean, msg: String) : this(success, msg, null)
    constructor(success: Boolean, data: Any?) : this(success, "", data)
}