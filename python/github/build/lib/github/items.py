# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class GithubItem(scrapy.Item):
    name = scrapy.Field()
    logo = scrapy.Field()
    email = scrapy.Field()
    homepage = scrapy.Field()
