package me.dragan.javafxkotlinspring.config

import com.google.common.eventbus.EventBus
import me.dragan.javafxkotlinspring.controller.ApplicationController
import me.dragan.javafxkotlinspring.controller.FileDataController
import me.dragan.javafxkotlinspring.controller.FileListController
import me.dragan.javafxkotlinspring.controller.FilePropertiesController
import me.dragan.javafxkotlinspring.service.FileService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * All controllers and EventBus are Spring beans using Contructor-based Dependency Injection
 */
@Configuration
open class ApplicationConfig {

   @Bean
   open fun applicationController(fileListController: FileListController,
                                  filePropertiesController: FilePropertiesController,
                                  fileDataController: FileDataController
   ): ApplicationController {
      return ApplicationController(fileListController, fileDataController, filePropertiesController)
   }

   @Bean
   open fun eventBus(): EventBus {
      return EventBus()
   }

   @Bean
   open fun fileService(): FileService {
      return FileService()
   }

   @Bean
   open fun fileDataController(eventBus: EventBus): FileDataController {
      return FileDataController(eventBus)
   }

   @Bean
   open fun fileListController(eventBus: EventBus): FileListController {
      return FileListController(eventBus)
   }

   @Bean
   open fun filePropertiesController(eventBus: EventBus): FilePropertiesController {
      return FilePropertiesController(eventBus)
   }
}
