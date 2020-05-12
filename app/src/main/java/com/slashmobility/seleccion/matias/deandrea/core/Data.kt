package com.slashmobility.seleccion.matias.deandrea.core

import com.squareup.moshi.Json

// RESPONSE: Models of API responses
data class Data(
//    @field:Json(name = "args") val args: String?,
//    @field:Json(name = "headers") val headers: List<String>,
    @field:Json(name = "origin") var origin: String?
//    @field:Json(name = "url") val url: String?
)

data class Headers(
    @field:Json(name = "Accept-Encoding") val acceptEncoding: String?,
    @field:Json(name = "Accept-Language") val acceptLanguage: String?,
    @field:Json(name = "Host") var host: String?,
    @field:Json(name = "User-Agent") val userAgent: String?,
    @field:Json(name = "Connection") val connection: String?,
    @field:Json(name = "Accept-Charset") val acceptCharset: String?,
    @field:Json(name = "Cookie") val cookie: String?
)