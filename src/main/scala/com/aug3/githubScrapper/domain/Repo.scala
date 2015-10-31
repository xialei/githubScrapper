package com.aug3.githubScrapper.domain

import argonaut.Argonaut._
import argonaut.CodecJson

/**
 * Created by roger on 15/10/13.
 */

case class Repo(
                 id: Option[Long],
                 name: Option[String],
                 url: Option[String],
                 desc: Option[String],
                 size: Option[Long],
                 fork: Option[Boolean],
                 forks: Option[Int],
                 stargazers: Option[Int],
                 watchers: Option[Int],
                 commits: Option[Int],
                 open_issues: Option[Int],
                 language: Option[String],
                 owner: Option[String],
                 created_at: Option[String]
                 )

object Repo {
  /**
   * Creates the encode/decode codec for the User object.
   */
  implicit val RepoResultCodec: CodecJson[Repo] =
    casecodec14(Repo.apply, Repo.unapply)("id", "name", "url", "desc", "size", "fork",
      "forks", "stargazers", "watchers", "commits", "open_issues", "language", "owner", "created_at")
}