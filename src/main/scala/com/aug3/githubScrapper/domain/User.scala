package com.aug3.githubScrapper.domain

import argonaut.Argonaut._
import argonaut.CodecJson

/**
 * Created by roger on 15/10/13.
 */
case class User(
                 id: Option[Long],
                 login: Option[String],
                 name: Option[String],
                 email: Option[String],
                 location: Option[String],
                 url: Option[String],
                 avatar: Option[String],
                 company: Option[String],
                 followers: Option[Int],
                 following: Option[Int],
                 public_repos: Option[Int],
                 repos_url: Option[String],
                 created_at: Option[String]
                 )

object User {
  /**
   * Creates the encode/decode codec for the User object.
   */
  implicit val UserCodec: CodecJson[User] =
    casecodec13(User.apply, User.unapply)("id", "login", "name", "email", "location",
      "url", "avatar", "company", "followers", "following", "public_repos",
      "repos_url", "created_at")
}