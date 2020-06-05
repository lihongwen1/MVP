package com.chenxuan.common.base

abstract class BaseModule<T : BaseService> : IModule {
    val api: T
        get() = createApiService()

    abstract fun createApiService(): T
}