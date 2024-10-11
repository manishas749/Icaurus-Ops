package com.icarus.enums

enum class ChecklistType(val i: Int) {
    Normal(1), Emergency(2), Frequency(3), Glass(4);

    fun getValue(): Int {
        return i
    }
}
