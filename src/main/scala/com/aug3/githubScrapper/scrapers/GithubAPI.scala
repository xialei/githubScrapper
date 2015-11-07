package com.aug3.githubScrapper.scrapers

import com.aug3.githubScrapper.domain.{Item, SearchParam}

/**
 * Created by roger on 15/11/7.
 */
class GithubAPI {

  def search(p: SearchParam): List[Item] = {
    
  }

}

object GithubAPI {

  val instance = new GithubAPI()

  def apply(): GithubAPI = {
    return instance
  }
}
