package com.slashmobility.seleccion.matias.deandrea.core

import com.squareup.moshi.Json

// DATA: Model of API responses
data class Data(
    @field:Json(name = "origin") var origin: String?
)
