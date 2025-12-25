package org.example.project.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


sealed interface Destination : NavKey {
    @Serializable
    data object SignInScreen : Destination
    @Serializable
    data class SignUpScreen(val profile: Profile?= null) : Destination
    @Serializable
    data object HomeScreen : Destination
    @Serializable
    data object CategoryScreen : Destination
}


@Serializable
data class Profile(
    val name : String = "Sajib",
    val age : Int = 25,
    val subject : Subject ?= null
)
@Serializable
data class Subject(val courseID : String = "45845", val courseTitle : String = "CSE")