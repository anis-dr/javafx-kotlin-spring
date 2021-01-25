package me.dragan.javafxkotlinspring

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Stage
import me.dragan.javafxkotlinspring.config.ApplicationConfig
import me.dragan.javafxkotlinspring.controller.ApplicationController
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Uses Spring Context to manage services as beans which are shared
 * across one or more application controllers
 */
class Main : Application() {
    private val context: AnnotationConfigApplicationContext =
        AnnotationConfigApplicationContext(ApplicationConfig::class.java)

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        // load all controllers via Spring Framework
        val controller = context.getBean("applicationController") as ApplicationController

        val loader = FXMLLoader(javaClass.getResource("/springkotlin.fxml"))
        loader.setController(controller)
        val root = loader.load<Pane>()

        primaryStage.title = "Spring, Events, MultipleControllers"
        primaryStage.scene = Scene(root, 750.0, 550.0)
        primaryStage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java, *args)
        }
    }
}
