package com.icarus.enums

enum class WorkorderStatus(val i: Int) {
    OPEN(1), IN_PROGRESS(2), COMPLETED(3), CLOSED(4), RE_OPENED(5), CANCEL(6), DELETED(7);

    fun getValue(): Int {
        return i
    }
}
