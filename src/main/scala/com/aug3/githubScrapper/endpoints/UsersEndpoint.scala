package com.aug3.githubScrapper.endpoints

import com.aug3.githubScrapper.domain.{SearchParam, SearchResult}
import com.aug3.githubScrapper.endpoints.SearchEndpoint._
import com.aug3.githubScrapper.scrapers.GithubAPI
import io.finch.argonaut._
import io.finch.request._
import io.finch.response.Ok
import io.finch.route._
import org.joda.time.DateTime


/**
 * Created by roger on 15/10/12.
 */
object UsersEndpoint {

  val module = apiCommonPath / apiVersion / "users"

  val search =
    post(module ? body.as[SearchParam]) {
      s: SearchParam =>

        val githubAPI = GithubAPI()

        val items = githubAPI.search(s)

        val searchResult = SearchResult(
          Some(githubAPI.getSource()),
          None,
          None,
          s.keywords,
          None,
          Some(items),
          Some(DateTime.now().getMillis),
          Some(""))

        Ok(searchResult)
    }

  val query =
    get(module / string("uid")) {
      uid: String => Ok()
    }

  val UserAPIs = search | query

}