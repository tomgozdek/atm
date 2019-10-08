package modules

import dagger.Module
import dagger.Provides
import helper.Outputter
import helper.SystemPrinter

@Module
object SystemOutModule {
    @JvmStatic
    @Provides
    fun textOutputter(): Outputter {
        return SystemPrinter()
    }
}
