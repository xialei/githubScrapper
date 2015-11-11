package com.aug3.githubScrapper.scrapers

import com.aug3.githubScrapper.domain.{Item, SearchParam}
import dispatch._
import Defaults._

import net.liftweb.json.JsonAST._
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.collection.mutable

/**
 * Created by roger on 15/11/7.
 */
class GithubAPI {

  def getSource(): String = {
    "github"
  }

  def search(p: SearchParam): List[Item] = {
    //https://api.github.com/search/users?q=tom+repos:%3E42+followers:%3E1000
    val params = Map(
      "q" -> p.keywords.getOrElse(""),
      "sort" -> "followers",
      "order" -> "desc"
    )

    val request = url("https://api.github.com/search/users") <<? params

    println("===request path:" + request.toString)

    val response = Http(request OK dispatch.as.String)

    for (c <- response)
      println("===" + c)

//      .toLiftFuture.map { jv =>
//      jv.children.map { item =>
//        val JString(id) = item \ "id"
//        val JString(name) = item \ "name"
//        val JString(columnId) = item \ "idList"
//        val checkListItems = ChecklistExtractor.extract(item \ "checklists")
//        Item(
//          uid = uid,
//          name = name,
//          avatar = avatar,
//          location = location,
//          email = email,
//          url = url
//        )
//      }
//    }

    return mutable.MutableList[Item]().toList
  }

}

object GithubAPI {

  val instance = new GithubAPI()

  def apply(): GithubAPI = {
    return instance
  }
}
