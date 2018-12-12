package com.gmail.pmanenok.tasks.presentation.base.recycler

abstract class BaseItemViewModel<Entity> {
    abstract fun bindItem(item: Entity, position: Int)
    open fun onItemClick() {}
}