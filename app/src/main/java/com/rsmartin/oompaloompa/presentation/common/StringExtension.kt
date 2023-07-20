package com.rsmartin.oompaloompa.presentation.common

fun String.toOompaLoompaGender(): String {
    return when {
        this == "F" -> "Female"
        this == "M" -> "Male"
        else -> ""
    }
}