package com.aug3.githubScrapper.scrapers

import com.aug3.githubScrapper.domain.{Item, SearchParam}

import dispatch._
import dispatch.liftjson.Js._
import net.liftweb.json.JsonAST._
import org.json4s.JsonAST._


/**
 * Created by roger on 15/11/7.
 */
class GithubAPI {

  def search(p: SearchParam): List[Item] = {
    //https://api.github.com/search/users?q=tom+repos:%3E42+followers:%3E1000
    val params = Map(
      "q" -> p.keywords.getOrElse(""),
      "sort" -> "followers",
      "order" -> "desc"
    )

    val request = :/("https://api.github.com/search/users") <<? params

    println("===request path:" + request.path)

    val items = Http(url OK asJsonWithUtf8).toLiftFuture.map { jv =>
      jv.children.map { item =>
        val JString(id) = item \ "id"
        val JString(name) = item \ "name"
        val JString(columnId) = item \ "idList"
        val checkListItems = ChecklistExtractor.extract(item \ "checklists")
        Card(
          id = id,
          name = name,
          columnId = columnId,
          checklistItems = checkListItems
        )
      }
    }
//    val items = http( request ># { json =>
//      (json \ "items" children) flatMap( _ match {
//        case JField("login", JString(d)) => Some(d).orElse(None)
//        case JString("avatar_url") => Some(d).orElse(None)
//        case JString("url") => Some(d).orElse(None)
//        case _ => None
//      })
//    } )

    return items
  }



//      val uid = Some(it.select(selectorMap.get("uid").get._1).text()).orElse(None)
//      val name = Some(it.select(selectorMap.get("name").get._1).text()).orElse(None)
//      val avatar = Some(it.select(selectorMap.get("avatar").get._1).attr(selectorMap.get("avatar").get._2)).orElse(None)
//      val location = Some(it.select(selectorMap.get("location").get._1).text()).orElse(None)
//      val email = Some(it.select(selectorMap.get("email").get._1).text()).orElse(None)
//      val url = Some(it.select(selectorMap.get("url").get._1).attr(selectorMap.get("url").get._2)).orElse(None)
//
//      val item = Item(uid, name, avatar, location, email, url)

}

object GithubAPI {

  val instance = new GithubAPI()

  def apply(): GithubAPI = {
    return instance
  }
}
