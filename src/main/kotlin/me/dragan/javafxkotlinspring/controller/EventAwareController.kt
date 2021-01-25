package me.dragan.javafxkotlinspring.controller

import com.google.common.eventbus.EventBus

/*
A controller which can subscribe to application-wide events which all share
the same event bus.
 */
abstract class EventAwareController(val eventBus: EventBus) {

    init {
        eventBus.register(this)
    }
}