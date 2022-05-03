package com.github.ejchathuranga.newsapp.data.model

data class User(
    var userId: Int,
    var username: String?,
    var email: String?,
    var age: String?,
    var pass: String?,
    var passC: String?
) {
    constructor(userId: Int) : this(userId, "", "", "", "", "")
}