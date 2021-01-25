package me.dragan.javafxkotlinspring.controller

import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import me.dragan.javafxkotlinspring.event.FileAddedEvent
import me.dragan.javafxkotlinspring.event.FileSelectedEvent
import org.springframework.stereotype.Component

/**
 * Controller for fileProperties.fxml
 */
@Component
class FilePropertiesController(eventBus: EventBus) : EventAwareController(eventBus) {

    @FXML
    lateinit var nameLabel: Label

    @FXML
    lateinit var pathLabel: Label

    @FXML
    lateinit var sizeLabel: Label

    fun load(): Pane {
        val loader = FXMLLoader(javaClass.getResource("/fileProperties.fxml"))
        loader.setController(this)
        return loader.load<Pane>()
    }

    @Subscribe
    fun handleFileAdded(e: FileAddedEvent) {
        println("FilePropertiesController processing FileAddedEvent")
        nameLabel.text = e.file.name
        pathLabel.text = e.file.path
        sizeLabel.text = e.file.length().toString()
    }

    @Subscribe
    fun handleFileSelectionChanged(e: FileSelectedEvent) {
        println("FilePropertiesController processing FileSelectedEvent")
        nameLabel.text = e.file.name
        pathLabel.text = e.file.path
        sizeLabel.text = e.file.length().toString()
    }

}