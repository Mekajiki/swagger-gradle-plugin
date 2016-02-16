package com.github.mekajiki.swagger_gradle_plugin

import com.github.kongchen.swagger.docgen.mavenplugin.ApiSource
import com.github.kongchen.swagger.docgen.mavenplugin.SecurityDefinition
import io.swagger.models.Info


class Extension {
  List<ApiSource> apiSources = new ArrayList<>()
  ApiSource currentApiSource

  def apiSource(Closure closure) {
    currentApiSource = new ApiSource()
    closure.setDelegate(currentApiSource)
    closure.run()
    apiSources.add currentApiSource
    currentApiSource = null
  }

  def info(Closure closure) {
    def info = new Info()
    closure.setDelegate(info)
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    closure.run()
    currentApiSource.setInfo(info)
  }

  def securityDefinition(Closure closure) {
    def securityDefinition = new SecurityDefinition()
    closure.setDelegate(securityDefinition)
    currentApiSource.getSecurityDefinitions().add(securityDefinition)
  }
}