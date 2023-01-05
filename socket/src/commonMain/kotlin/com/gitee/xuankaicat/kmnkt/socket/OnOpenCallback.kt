package com.gitee.xuankaicat.kmnkt.socket

import com.gitee.xuankaicat.kmnkt.socket.utils.ILoggable

/**
 * OnOpenCallback的默认实现
 */
expect open class OnOpenCallback(loggable: ILoggable) : IOnOpenCallback {
    fun success(method: (socket: ISocket) -> Unit)
    fun failure(method: (socket: ISocket) -> Boolean)
    fun loss(method: (socket: ISocket) -> Boolean)
}