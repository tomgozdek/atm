package command

import dagger.Component
import modules.HelloWorldModule
import modules.LoginCommandModule
import modules.SystemOutModule
import modules.UserCommandsModule
import javax.inject.Singleton

@Singleton
@Component(modules = [SystemOutModule::class, LoginCommandModule::class, HelloWorldModule::class, UserCommandsModule::class])
interface CommandRouterFactory {
    fun router() : CommandRouter
}