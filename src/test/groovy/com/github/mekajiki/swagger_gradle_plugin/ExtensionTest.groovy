package com.github.mekajiki.swagger_gradle_plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class ExtensionTest {
  @Test
  void pluginGenerateSwaggerTask() {
    Project project = ProjectBuilder.builder().build()
    project.apply plugin: 'swagger'
    def version = '1.0.0'
    project.swagger {
      apiSource {
        locations = 'jp.pocket_change.voucher'
        info {
          title = 'PocketChange Voucher API'
          delegate.version = version
        }
      }
    }

    project.tasks.generateSwagger.run()
  }
}
