package com.naat.yaapp.data.internal.sharedpreferences

import android.content.Context
import com.naat.yaapp.data.models.UserSession

object SessionPreferences {

    private const val USER: String = "user"
    private const val ACCESS_TOKEN: String = "access_token"
    private const val TOKEN_TYPE: String = "token_type"
    private const val REFRESH_TOKEN: String = "refresh_token"
    private const val EXPIRES_IN: String = "expires_in"
    private const val SCOPE: String = "scope"
    private const val JTI: String = "jti"

    fun setUserSession(userSession: UserSession, context: Context) {
        val saveUser = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        val editor = saveUser.edit()
        with(editor) {
            putString(ACCESS_TOKEN, userSession.accessToken)
            putString(TOKEN_TYPE, userSession.tokenType)
            putString(REFRESH_TOKEN, userSession.refreshToken)
            putInt(EXPIRES_IN, userSession.expiresIn)
            putString(SCOPE, userSession.scope)
            putString(JTI, userSession.jti)
            commit()
        }

    }

}