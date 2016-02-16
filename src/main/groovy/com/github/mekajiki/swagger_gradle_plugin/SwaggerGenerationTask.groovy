package com.github.mekajiki.swagger_gradle_plugin

import com.github.kongchen.swagger.docgen.mavenplugin.ApiDocumentMojo
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class SwaggerGenerationTask extends DefaultTask {

  static final String TASK_NAME = 'generateSwagger'

  @TaskAction
  def run() {
    Extension swagger = project.swagger

    def mojo = new ApiDocumentMojo()
    mojo.setApiSources(swagger.apiSources)
    mojo.execute()
  }
}
