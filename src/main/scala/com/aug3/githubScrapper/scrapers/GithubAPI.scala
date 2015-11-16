package com.aug3.githubScrapper.scrapers

import com.aug3.githubScrapper.domain.{User, Item, SearchParam}
import dispatch._
import Defaults._

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

    val results = for {
      JField("id", JLong(id)) <- json
      JField("login", JString(login)) <- json
      JField("name", JString(name)) <- json
      JField("email", JString(email)) <- json
      JField("location", JString(location)) <- json
      JField("url", JString(url)) <- json
      JField("avatar", JString(avatar)) <- json
      JField("company", JString(company)) <- json
      JField("followers", JInt(followers)) <- json
      JField("following", JInt(following)) <- json
      JField("public_repos", JInt(public_repos)) <- json
      JField("repos_url", JString(repos_url)) <- json
      JField("created_at", JString(created_at)) <- json
      JField("updated_at", JString(updated_at)) <- json
    } yield User(
        Some(id).orElse(None),
        Some(login).orElse(None),
        Some(name).orElse(None),
        Some(email).orElse(None),
        Some(location).orElse(None),
        Some(url).orElse(None),
        Some(avatar).orElse(None),
        Some(company).orElse(None),
        Some(followers).orElse(None),
        Some(followers).orElse(None),
        Some(public_repos).orElse(None),
        Some(repos_url).orElse(None),
        Some(created_at).orElse(None),
        Some(updated_at).orElse(None)
      )


    return results
  }

}

object GithubAPI {

  val instance = new GithubAPI()

  def apply(): GithubAPI = {
    return instance
  }
}
