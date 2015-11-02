Demo to use scrapy for scrapying
=================================

## install virtualenv

pip install virtualenv

pip install virtualenvwrapper

virtualenv envscrapy

source bin/activate


### install dependency packages

pip install lxml

pip install pyOpenSSL


### install Scrapy

pip install Scrapy


## create scrapy project

scrapy startproject github

### create a spider for github.com
scrapy genspider github github.com -t basic

> spiders 目录中的.py文件不能和项目名同名。
scrapy edit gitusers

scrapy crawl gitusers -o users.json -t json

name
//*[@id="user_search_results"]/div[1]/div[1]/div[2]/a
//*[@id="user_search_results"]/div[1]/div[2]/div[2]/a
img
//*[@id="user_search_results"]/div[1]/div[1]/a/img
//*[@id="user_search_results"]/div[1]/div[2]/a/img
email
//*[@id="user_search_results"]/div[1]/div[1]/div[2]/ul/li[2]/span/a
//*[@id="user_search_results"]/div[1]/div[2]/div[2]/ul/li[2]/span/a


## using scrapy cloud

https://dash.scrapinghub.com/p/23231/spider/gitusers/
http://doc.scrapinghub.com/scrapy-cloud.html#deploying-a-scrapy-spider

pip install shub

[deploy]
project = PROJECT_ID
username = APIKEY

shub login

shub deploy

shub logout


## deactivate
