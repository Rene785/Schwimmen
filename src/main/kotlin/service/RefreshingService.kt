package service

import view.Refreshables
import java.util.*

/**
 * Abstract class of the service layer. Connects the view layer with the service layer.
 */
abstract class RefreshingService {

    private val refreshables = LinkedList<Refreshables>()

    /**
     * Iterates and runs each [Refreshables] method passed.
     * @param method All [Refreshables] methods passed
     */
    fun onAllRefreshables(method: Refreshables.() -> Unit){
        refreshables.forEach { it.method() }
    }

    /**
     * Adds a [Refreshables] to the [refreshables] list
     * @param refAble Method to be added to the [refreshables] list.
     */
    fun addRefreshable(refAble:Refreshables){
        refreshables.add(refAble)
    }
}