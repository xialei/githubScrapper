package com.aug3.githubScrapper.scrapers

import com.aug3.githubScrapper.api.endpoints.Search
import com.aug3.githubScrapper.domain.{SearchParam, Item}
import dispatch.classic.{url, :/, Request}

/**
 * Created by roger on 15/10/18.
 */
class GithubScrapers extends AbstractScraper with Search {

  override def getSource(): String = {
    "github"
  }

  val selectorMap = Map[String, (String, String)] (
    "items" -> ("div.user-list > div", ""),
    "uid" -> ("div.user-list-info > a", ""),
    "name" -> ("div.user-list-info", ""),
    "avatar" -> ("a > img", "src"),
    "location" -> ("div.user-list-info > ul > li:nth-child(1) > span", ""),
    "email" -> ("div.user-list-info > ul > li:nth-child(2) > span > a", ""),
    "url" -> ("div.user-list-info > a", "href")
  )

  override def search(p:SearchParam):List[Item] = {
    super.searchRequest(p, selectorMap, buildRequestUrl)
  }

  def buildRequestUrl(p:SearchParam):Request = {

    //https://github.com/search?q=location%3AShanghai+location%3AChina+language%3AScala&type=Users&ref=advsearch
    val params = Map (
      "ref" -> "advsearch",
      "type" -> "Users",
      "q" -> p.keywords.getOrElse("")//java.net.URLEncoder.encode(p.keywords.getOrElse(""), "utf-8")
    )

    println("===request params: " + params.size + " , " + params)

    val myRequest = url("https://github.com/search")

    //val site = "github.com"

    //:/(site) / "search" <<? params

    myRequest <<? params

  }

}

object GithubScrapers {

  val instance = new GithubScrapers()

  def apply():GithubScrapers = {
    return instance
  }
}
