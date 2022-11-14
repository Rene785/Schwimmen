package service

import view.Refreshables
import java.util.*


abstract class RefreshingService {

    private val refreshables = LinkedList<Refreshables>()
    fun onAllRefreshables(method: Refreshables.() -> Unit){
        refreshables.forEach { it.method() }
    }

    fun addRefreshable(refAble:Refreshables){
        refreshables.add(refAble)
    }
}