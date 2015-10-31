package com.aug3.githubScrapper.api

import java.net.InetSocketAddress

import com.aug3.githubScrapper.api.endpoints.{SearchEndpoint, UsersEndpoint}
import com.twitter.finagle.httpx.{Request, Response}
import com.twitter.finagle.{Httpx, Service}
import com.twitter.util.Await

/**
 * Created by roger on 15/10/12.
 */
object WebServer extends App with ErrorHandling {

  val apis = SearchEndpoint.SearchAPIs //|

  def makeService(): Service[Request, Response] = handleExceptions andThen apis.toService

  Await.ready(
    Httpx.serve(new InetSocketAddress("localhost", 8090), makeService())
  )


}
