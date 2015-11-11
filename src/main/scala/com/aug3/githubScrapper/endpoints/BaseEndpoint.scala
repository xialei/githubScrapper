package com.aug3.githubScrapper.endpoints

/**
 * Created by roger on 15/10/28.
 */
trait BaseEndpoint {

  val apiCommonPath = "apis"
  val apiVersion = "v1"

  val paths = List(apiCommonPath, apiVersion)

}
