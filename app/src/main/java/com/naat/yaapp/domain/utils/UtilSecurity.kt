package com.naat.yaapp.domain.utils

import java.security.MessageDigest

object UtilSecurity {

    fun encript(input: String): String {
        return MessageDigest
            .getInstance("SHA-256")
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }

}