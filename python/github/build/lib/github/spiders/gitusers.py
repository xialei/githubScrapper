# -*- coding: utf-8 -*-
import scrapy
from github.items import GithubItem

# from scrapy.contrib.loader import ItemLoader
# from scrapy.contrib.loader.processor import MapCompose, TakeFirst
# from urlparse import urljoin

# class GithubLoader(ItemLoader):
#     default_input_processor = MapCompose(unicode.strip)
#     default_output_processor = TakeFirst()

class GitusersSpider(scrapy.Spider):
    name = "gitusers"
    allowed_domains = ["github.com"]
    start_urls = (
        'https://github.com/search?utf8=%E2%9C%93&q=location%3APhilippines+language%3ARails&type=Users&ref=searchresults',
    )

    def parse(self, response):
        users = response.xpath('//*[@id="user_search_results"]/div[1]/div[@class="user-list-item"]')
        for user in users:
            item = GithubItem()
            item['name'] = user.xpath('div[@class="user-list-info"]/a/text()').extract()[0]
            item['homepage'] = user.xpath('div[@class="user-list-info"]/a/@href').extract()[0]
            item['logo'] = user.xpath('a/img/@src').extract()[0]
            item['email'] = user.xpath('div[@class="user-list-info"]/ul/li/span/a/@href').extract()[0]
            yield item

    # def parse(self, response):
    #     for x in response.xpath("//table[@class='col2_table_listing']//a/@href").extract():
    #         yield scrapy.Request(urljoin(response.url, x), self.parse_company)

    # def parse_company(self, response):
    #     l = CompanyLoader(item=Company(), response=response)
    #     l.add_xpath("logo", "//div[@id='company_logo']//img/@src")
    #     l.add_xpath("name", "//h1[@class='h1_first']/text()")
    #     l.add_xpath("website", "(//td[@class='td_right']/a/@href)[1]")
    #     return l.load_item()

