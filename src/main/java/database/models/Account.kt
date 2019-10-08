package database.models

import java.math.BigDecimal

class Account(val username : String) {
    fun deposit(newBalance: BigDecimal) {
        balance = newBalance
    }

    var balance : BigDecimal = BigDecimal.ZERO


}