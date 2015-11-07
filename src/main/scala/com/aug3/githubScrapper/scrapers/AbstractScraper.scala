package com.aug3.githubScrapper.scrapers

import com.aug3.githubScrapper.domain.{Item, SearchParam}

import dispatch.classic.{Http, Request}
import dispatch.classic.jsoup.JSoupHttp._
import org.jsoup.nodes.Document

import scala.collection.mutable

/**
 * Created by roger on 15/10/13.
 */
trait AbstractScraper {

  def getSource(): String

  def searchRequest(p: SearchParam, selectorMap: Map[String, (String, String)],
                    buildRequestUrl: SearchParam => Request): List[Item] = {

    val headers = Map(
      "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
      "User-Agent" -> "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)",
      "Accept-Encoding" -> "gzip, deflate"
    )

    val request = buildRequestUrl(p) //<< headers

    println("===request path:" + request.path)

    val items = Http(request </> { doc =>
      parse(doc, selectorMap)
    })

    return items
  }

  def parse(doc: Document, selectorMap: Map[String, (String, String)]): List[Item] = {

    val childrenIt = doc.select(selectorMap.get("items").get._1).iterator()
    val items = mutable.MutableList[Item]()

    while (childrenIt.hasNext) {

      val it = childrenIt.next()
      val uid = Some(it.select(selectorMap.get("uid").get._1).text()).orElse(None) //.attr(selectorMap.get("uid").get._2)).orElse(None)
      val name = Some(it.select(selectorMap.get("name").get._1).text()).orElse(None) //.attr(selectorMap.get("name").get._2)).orElse(None)
      val avatar = Some(it.select(selectorMap.get("avatar").get._1).attr(selectorMap.get("avatar").get._2)).orElse(None)
      val location = Some(it.select(selectorMap.get("location").get._1).text()).orElse(None) //.attr(selectorMap.get("location").get._2)).orElse(None)
      val email = Some(it.select(selectorMap.get("email").get._1).text()).orElse(None) //.attr(selectorMap.get("email").get._2)).orElse(None)
      val url = Some(it.select(selectorMap.get("url").get._1).attr(selectorMap.get("url").get._2)).orElse(None)

      val item = Item(uid, name, avatar, location, email, url)

      items += item
    }

    println("===items size = " + items.length)

    return items.toList
  }

}
