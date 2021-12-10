@file:Suppress("unused")

package com.gitee.xuankaicat.communicate

import java.nio.charset.Charset

typealias OnReceiveFunc = (String) -> Boolean

interface Communicate {
    companion object {
        @JvmStatic
        val TCPClient: Communicate
            @JvmName("TCPClient")
            get() = TCP()

        /**
         * 构造TCPClient
         * @param build 构造lambda
         * @return TCPClient
         */
        @JvmStatic
        fun getTCPClient(build: (Communicate) -> Unit): Communicate = TCPClient.apply(build)

        @JvmStatic
        val UDP: Communicate
            @JvmName("UDP")
            get() = UDP()

        /**
         * 构造UDP
         * @param build 构造lambda
         * @return UDP
         */
        @JvmStatic
        fun getUDP(build: (Communicate) -> Unit): Communicate = UDP.apply(build)
    }

    /**
     * 通信端口
     */
    var serverPort: Int

    /**
     * 通信地址
     */
    var address: String

    /**
     * 输入编码
     */
    var inCharset: Charset

    /**
     * 输出编码
     */
    var outCharset: Charset

    /**
     * 发送数据
     * @param message 数据内容
     */
    fun send(message: String)

    /**
     * 开始接收数据
     * @param onReceive 处理接收到的数据的函数，函数返回值为是否继续接收消息.
     * 请不要在函数中使用stopReceive()函数停止接收数据，这不会起作用。
     * @return 是否开启成功
     */
    fun startReceive(onReceive: OnReceiveFunc): Boolean

    /**
     * 停止接收数据
     */
    fun stopReceive()

    /**
     * 开启通信，用于TCP建立连接
     * @return 是否开启成功
     */
    fun open(): Boolean

    /**
     * 关闭通信
     */
    fun close()
}