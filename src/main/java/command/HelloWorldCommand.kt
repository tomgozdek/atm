package command

import command.Command
import helper.Outputter
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(val outputter : Outputter) : Command {

    override fun handleInput(input: List<String>): Command.Status {
        if(!input.isEmpty()){
            return Command.Status.INVALID
        }

        outputter.output("world!")
        return Command.Status.HANDLED
    }

}