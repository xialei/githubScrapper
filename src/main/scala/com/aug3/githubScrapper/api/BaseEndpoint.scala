package com.aug3.githubScrapper.api

/**
 * Created by roger on 15/10/28.
 */
trait BaseEndpoint {

  val apiVersion = "v1"
  val apiCommonPath = "apis"

  val paths = List(apiCommonPath, apiVersion)

}
