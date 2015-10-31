package com.aug3.githubScrapper.api.endpoints {

import com.aug3.githubScrapper.api.BaseEndpoint
import com.aug3.githubScrapper.domain.{Item, SearchParam, SearchResult}
import com.aug3.githubScrapper.scrapers.GithubScrapers
import io.finch.argonaut._
import io.finch.request._
import io.finch.response.Ok
import io.finch.route._
import org.joda.time.DateTime

/**
 * Created by roger on 15/10/12.
 */

trait Search {

  def search(p:SearchParam):List[Item]
}

object SearchConfig {
  val searchServiceMap = Map[String, Search](
    "github" -> GithubScrapers()
  )
}

object SearchEndpoint extends BaseEndpoint {

  val modulename = apiCommonPath / apiVersion / "search"

  val CreateSearch =
    post(modulename ? body.as[SearchParam]) {

      s: SearchParam =>

        val searchScarperService = GithubScrapers()//SearchConfig.searchServiceMap.get(s.source.getOrElse("github"))

        val items = searchScarperService.search(s)

        // save to mongo/redis

        val searchResult = SearchResult(
                              Some(searchScarperService.getSource()),
                              None,
                              None,
                              s.keywords,
                              None,
                              Some(items),
                              Some(DateTime.now().getMillis),
                              Some(""))

        Ok(searchResult)
  }

  val SearchAPIs = CreateSearch

}

}