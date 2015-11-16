package com.aug3.githubScrapper.scrapers

import com.aug3.githubScrapper.domain.{User, Item, SearchParam}
import dispatch._
import Defaults._

import org.json4s._
import org.json4s.native.JsonMethods._

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

    val response = Http(request OK dispatch.as.String)

    val json = parse(response())

    val results = for {
      JObject(item) <- json
      JField("login", JString(name)) <- item
      JField("avatar_url", JString(avatar)) <- item
      JField("url", JString(url)) <- item
    //      JField("score", JInt(score)) <- item
    //      if score > 4
    } yield Item(
        uid = Some(name).orElse(None),
        name = Some(name).orElse(None),
        avatar = Some(avatar).orElse(None),
        location = None,
        email = None,
        url = Some(url).orElse(None)
      )

    return results
  }

  def queryUser(uid: String): User = {
    //https://api.github.com/users/{uid}

    val request = url("https://api.github.com/users/" + uid)

    val response = Http(request OK dispatch.as.String)

    val json = parse(response())

    println("===" + json)

    return User(
      compact(render(json \ "id")).toLong,
      Some(compact(render(json \ "login"))).orElse(None),
      Some(compact(render(json \ "name"))).orElse(None),
      Some(compact(render(json \ "email"))).orElse(None),
      Some(compact(render(json \ "location"))).orElse(None),
      Some(compact(render(json \ "url"))).orElse(None),
      Some(compact(render(json \ "avatar"))).orElse(None),
      Some(compact(render(json \ "company"))).orElse(None),
      compact(render(json \ "followers")).toInt,
      compact(render(json \ "followers")).toInt,
      compact(render(json \ "public_repos")).toInt,
      Some(compact(render(json \ "repos_url"))).orElse(None),
      Some(compact(render(json \ "created_at"))).orElse(None),
      Some(compact(render(json \ "updated_at"))).orElse(None)
    )
  }

}

object GithubAPI {

  val instance = new GithubAPI()

  def apply(): GithubAPI = {
    return instance
  }
}
