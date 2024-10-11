package com.icarus.enums

enum class AssignedType(val i: Int) {
    user(1), department(2), vendor(3);

    fun getValue(): Int {
        return i
    }
}