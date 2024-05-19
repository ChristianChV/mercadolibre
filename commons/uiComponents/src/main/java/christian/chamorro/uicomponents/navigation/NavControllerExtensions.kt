package christian.chamorro.uicomponents.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

fun NavController.goSingleBack(currentEntry: NavBackStackEntry){
    val currentId = currentEntry.id
    val lastId = this.currentBackStackEntry?.id
    if (currentId == lastId){
        popBackStack()
    }
}