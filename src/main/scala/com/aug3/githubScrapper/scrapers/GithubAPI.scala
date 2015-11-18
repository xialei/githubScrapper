package com.aug3.githubScrapper.scrapers

import argonaut.Parse
import com.aug3.githubScrapper.domain.{User, Item, SearchParam}
import dispatch._
import Defaults._

import org.json4s._
import org.json4s.native.JsonMethods._

import scala.util.{Success, Failure}

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

    var user: User = 

    response onComplete {
      case Success(content) => {

        user = User(
          parseSimpleIntField(content, "id"),
          parseSimpleField(content, "login"),
          parseSimpleField(content, "name"),
          parseSimpleField(content, "email"),
          parseSimpleField(content, "location"),
          parseSimpleField(content, "url"),
          parseSimpleField(content, "avatar"),
          parseSimpleField(content, "company"),
          parseSimpleIntField(content, "followers"),
          parseSimpleIntField(content, "following"),
          parseSimpleIntField(content, "public_repos"),
          parseSimpleField(content, "repos_url"),
          parseSimpleField(content, "created_at"),
          parseSimpleField(content, "updated_at")
        )

      }
      case Failure(t) => {
        println("An error has occurred: " + t.getMessage)
      }
    }

    return user

  }

  def parseSimpleField(json: String, f: String): Option[String] = {
    Some(Parse.parseWith(json, _.field(f).flatMap(_.string).getOrElse(null), msg => msg)).orElse(None);
  }

  def parseSimpleIntField(json: String, f: String): Int = {
    Parse.parseWith(json, _.field(f).flatMap(_.string).getOrElse(null), msg => msg).toInt;
  }

}

object GithubAPI {

  val instance = new GithubAPI()

  def apply(): GithubAPI = {
    return instance
  }
}
