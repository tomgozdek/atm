package command

import javax.inject.Inject
import kotlin.concurrent.timer


class CommandRouter @Inject constructor(val commands : Map<String,@JvmSuppressWildcards Command>){

    fun route(input : String) : Command.Status {
        val splitInput : List<String> = split(input)
        if(splitInput.isEmpty()){
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val status = command.handleInput(splitInput.subList(1, splitInput.size))
        if(status == Command.Status.INVALID) {
            println("$commandKey : invalid arguments")
        }

        return status
    }

    private fun invalidCommand(input: String): Command.Status {
        println(String.format("couldn't understand \"%s\". please try again.", input))
        return Command.Status.INVALID
    }

    private fun split(input: String): List<String> {
        return input.split(" ")
    }
}