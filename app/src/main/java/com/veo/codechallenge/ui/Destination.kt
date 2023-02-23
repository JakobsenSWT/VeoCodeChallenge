package com.veo.codechallenge.ui

import androidx.navigation.NamedNavArgument

interface Destination {
    val route: String
    val arguments: List<NamedNavArgument>
}