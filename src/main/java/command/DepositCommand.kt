package command

import database.Database
import helper.Outputter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(private val database: Database, private val outputter: Outputter) : Command {
    override fun handleInput(input: List<String>): Command.Status {
        return if(input.size != 2){
            Command.Status.INVALID
        } else {
            val userName = input[0]
            val account = database.getAccount(userName)
            account.deposit(BigDecimal(input[1]))
            outputter.output("$userName now has: ${account.balance}")
            Command.Status.HANDLED
        }
    }

}