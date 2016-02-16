package com.github.mekajiki.swagger_gradle_plugin

import org.gradle.api.Project

class SwaggerGradlePlugin implements org.gradle.api.Plugin<Project> {

  @Override
  void apply(Project project) {
    project.extensions.create("swagger", Extension)

    project.task(SwaggerGenerationTask.TASK_NAME,
        type:SwaggerGenerationTask,
        dependsOn: 'classes'
      )
  }
}