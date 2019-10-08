import command.DaggerCommandRouterFactory
import java.util.*

object CommandLineAtm {
    @JvmStatic
    fun main(args : Array<String>){
        println("WELCOME")

        val scanner = Scanner(System.`in`)
        val commandRouterFactory = DaggerCommandRouterFactory.create()
        val commandRouter = commandRouterFactory.router()

        while(scanner.hasNextLine()){
            commandRouter.route(scanner.nextLine())
        }
    }
}