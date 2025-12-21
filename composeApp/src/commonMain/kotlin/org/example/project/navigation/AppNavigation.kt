package org.example.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.project.screen.signinScreen.SignInScreen
import org.example.project.ui.screen.signupScreen.SignUpScreen

@Composable
fun AppNavigation() {

    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(NavKey::class) {
                subclass(Destination.SignInScreen::class, Destination.SignInScreen.serializer())
                subclass(Destination.SignUpScreen::class, Destination.SignUpScreen.serializer())
            }
        }
    }

    val element = arrayOf<Destination>(Destination.SignInScreen)
    val backStack = rememberNavBackStack(configuration = config, elements = element)


    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = entryProvider {
            entry<Destination.SignInScreen> {
                SignInScreen(backStack)
            }
            entry<Destination.SignUpScreen> {key ->
                SignUpScreen(backStack, key)
            }
        }
    )

}