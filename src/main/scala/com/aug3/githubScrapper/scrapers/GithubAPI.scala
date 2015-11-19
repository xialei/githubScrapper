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

    val results = for {
      JObject(item) <- json
      JField("id", JInt(id)) <- item
      JField("login", JString(login)) <- item
      JField("name", JString(name)) <- item
      JField("email", JString(email)) <- item
      JField("location", JString(location)) <- item
      JField("html_url", JString(url)) <- item
      JField("avatar_url", JString(avatar)) <- item
//      JField("company", JString(company)) <- item
      JField("followers", JInt(followers)) <- item
      JField("following", JInt(following)) <- item
      JField("public_repos", JInt(public_repos)) <- item
      JField("repos_url", JString(repos_url)) <- item
      JField("created_at", JString(created_at)) <- item
      JField("updated_at", JString(updated_at)) <- item
    } yield User(
        id.toInt,
        Some(login).orElse(None),
        Some(name).orElse(None),
        Some(email).orElse(None),
        Some(location).orElse(None),
        Some(url).orElse(None),
        Some(avatar).orElse(None),
//        Some(company).orElse(None),
      None,
        followers.toInt,
        following.toInt,
        public_repos.toInt,
        Some(repos_url).orElse(None),
        Some(created_at).orElse(None),
        Some(updated_at).orElse(None)
      )

    if (results.size > 0)
      return results.head
    else
      return User.nullableUser

  }


}

object GithubAPI {

  val instance = new GithubAPI()

  def apply(): GithubAPI = {
    return instance
  }
}
