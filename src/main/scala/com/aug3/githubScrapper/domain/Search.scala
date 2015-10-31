package com.aug3.githubScrapper.domain

import argonaut.Argonaut._
import argonaut.CodecJson

case class SearchParam(keywords:Option[String], source:Option[String])

object SearchParam {
  implicit val SearchCodec: CodecJson[SearchParam] =
    casecodec2(SearchParam.apply, SearchParam.unapply)("keywords", "source")
}

case class SearchResult(
                         source: Option[String],
                         searchLink: Option[String],
                         location: Option[String],
                         searchKeyword: Option[String],
                         userAgent: Option[String],
                         users: Option[List[Item]],
                         ifModifiedSince: Option[Long],
                         eTag: Option[String]
                         )

object SearchResult {
  implicit val SearchResultCodec: CodecJson[SearchResult] =
    casecodec8(SearchResult.apply, SearchResult.unapply)("source", "searchLink", "location",
      "searchKeyword", "userAgent", "users", "ifModifiedSince", "eTag")
}

case class Item(
                 uid: Option[String],
                 name: Option[String],
                 avatar: Option[String],
                 location: Option[String],
                 email: Option[String],
                 url: Option[String]
                 )

object Item {

  implicit val ItemResultCodec: CodecJson[Item] =
    casecodec6(Item.apply, Item.unapply)("uid", "name", "avatar", "location", "email", "url")

}