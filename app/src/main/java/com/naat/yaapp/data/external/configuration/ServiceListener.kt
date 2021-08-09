package com.naat.yaapp.data.external.configuration

interface ServiceListener<T, K> {
    fun onServiceSucceed(t: T)
    fun onServiceFail(k: K)
}