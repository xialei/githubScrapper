Github Search
==============
https://developer.github.com/v3/search/

## get user info

curl https://api.github.com/users/xialei
{
  "login": "xialei",
  "id": 1142163,
  "avatar_url": "https://avatars.githubusercontent.com/u/1142163?v=3",
  "gravatar_id": "",
  "url": "https://api.github.com/users/xialei",
  "html_url": "https://github.com/xialei",
  "followers_url": "https://api.github.com/users/xialei/followers",
  "following_url": "https://api.github.com/users/xialei/following{/other_user}",
  "gists_url": "https://api.github.com/users/xialei/gists{/gist_id}",
  "starred_url": "https://api.github.com/users/xialei/starred{/owner}{/repo}",
  "subscriptions_url": "https://api.github.com/users/xialei/subscriptions",
  "organizations_url": "https://api.github.com/users/xialei/orgs",
  "repos_url": "https://api.github.com/users/xialei/repos",
  "events_url": "https://api.github.com/users/xialei/events{/privacy}",
  "received_events_url": "https://api.github.com/users/xialei/received_events",
  "type": "User",
  "site_admin": false,
  "name": "Roger",
  "company": null,
  "blog": null,
  "location": "China Shanghai",
  "email": "roger.xialei@gmail.com",
  "hireable": null,
  "bio": null,
  "public_repos": 16,
  "public_gists": 0,
  "followers": 0,
  "following": 7,
  "created_at": "2011-10-21T01:04:10Z",
  "updated_at": "2015-10-04T04:13:18Z"
}

## get repos info
curl -i https://api.github.com/repos/lgnlgn/ansj4solr
HTTP/1.1 200 OK
Server: GitHub.com
Date: Tue, 13 Oct 2015 16:02:42 GMT
Content-Type: application/json; charset=utf-8
Content-Length: 4867
Status: 200 OK
X-RateLimit-Limit: 60
X-RateLimit-Remaining: 58
X-RateLimit-Reset: 1444755284
Cache-Control: public, max-age=60, s-maxage=60
Last-Modified: Mon, 12 Oct 2015 10:32:16 GMT
ETag: "f1fbdcc3061ca2a97400fe57f0c26a08"
Vary: Accept
X-GitHub-Media-Type: github.v3
X-XSS-Protection: 1; mode=block
X-Frame-Options: deny
Content-Security-Policy: default-src 'none'
Access-Control-Allow-Credentials: true
Access-Control-Expose-Headers: ETag, Link, X-GitHub-OTP, X-RateLimit-Limit, X-RateLimit-Remaining, X-RateLimit-Reset, X-OAuth-Scopes, X-Accepted-OAuth-Scopes, X-Poll-Interval
Access-Control-Allow-Origin: *
X-GitHub-Request-Id: 3B2D4A0A:161C8:645D138:561D2B1F
Strict-Transport-Security: max-age=31536000; includeSubdomains; preload
X-Content-Type-Options: nosniff
Vary: Accept-Encoding
X-Served-By: 8dd185e423974a7e13abbbe6e060031e

{
  "id": 13855836,
  "name": "ansj4solr",
  "full_name": "lgnlgn/ansj4solr",
  "owner": {
    "login": "lgnlgn",
    "id": 271985,
    "avatar_url": "https://avatars.githubusercontent.com/u/271985?v=3",
    "gravatar_id": "",
    "url": "https://api.github.com/users/lgnlgn",
    "html_url": "https://github.com/lgnlgn",
    "followers_url": "https://api.github.com/users/lgnlgn/followers",
    "following_url": "https://api.github.com/users/lgnlgn/following{/other_user}",
    "gists_url": "https://api.github.com/users/lgnlgn/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/lgnlgn/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/lgnlgn/subscriptions",
    "organizations_url": "https://api.github.com/users/lgnlgn/orgs",
    "repos_url": "https://api.github.com/users/lgnlgn/repos",
    "events_url": "https://api.github.com/users/lgnlgn/events{/privacy}",
    "received_events_url": "https://api.github.com/users/lgnlgn/received_events",
    "type": "User",
    "site_admin": false
  },
  "private": false,
  "html_url": "https://github.com/lgnlgn/ansj4solr",
  "description": "solr的ansj分词器，支持4.3以上",
  "fork": false,
  "url": "https://api.github.com/repos/lgnlgn/ansj4solr",
  "forks_url": "https://api.github.com/repos/lgnlgn/ansj4solr/forks",
  "keys_url": "https://api.github.com/repos/lgnlgn/ansj4solr/keys{/key_id}",
  "collaborators_url": "https://api.github.com/repos/lgnlgn/ansj4solr/collaborators{/collaborator}",
  "teams_url": "https://api.github.com/repos/lgnlgn/ansj4solr/teams",
  "hooks_url": "https://api.github.com/repos/lgnlgn/ansj4solr/hooks",
  "issue_events_url": "https://api.github.com/repos/lgnlgn/ansj4solr/issues/events{/number}",
  "events_url": "https://api.github.com/repos/lgnlgn/ansj4solr/events",
  "assignees_url": "https://api.github.com/repos/lgnlgn/ansj4solr/assignees{/user}",
  "branches_url": "https://api.github.com/repos/lgnlgn/ansj4solr/branches{/branch}",
  "tags_url": "https://api.github.com/repos/lgnlgn/ansj4solr/tags",
  "blobs_url": "https://api.github.com/repos/lgnlgn/ansj4solr/git/blobs{/sha}",
  "git_tags_url": "https://api.github.com/repos/lgnlgn/ansj4solr/git/tags{/sha}",
  "git_refs_url": "https://api.github.com/repos/lgnlgn/ansj4solr/git/refs{/sha}",
  "trees_url": "https://api.github.com/repos/lgnlgn/ansj4solr/git/trees{/sha}",
  "statuses_url": "https://api.github.com/repos/lgnlgn/ansj4solr/statuses/{sha}",
  "languages_url": "https://api.github.com/repos/lgnlgn/ansj4solr/languages",
  "stargazers_url": "https://api.github.com/repos/lgnlgn/ansj4solr/stargazers",
  "contributors_url": "https://api.github.com/repos/lgnlgn/ansj4solr/contributors",
  "subscribers_url": "https://api.github.com/repos/lgnlgn/ansj4solr/subscribers",
  "subscription_url": "https://api.github.com/repos/lgnlgn/ansj4solr/subscription",
  "commits_url": "https://api.github.com/repos/lgnlgn/ansj4solr/commits{/sha}",
  "git_commits_url": "https://api.github.com/repos/lgnlgn/ansj4solr/git/commits{/sha}",
  "comments_url": "https://api.github.com/repos/lgnlgn/ansj4solr/comments{/number}",
  "issue_comment_url": "https://api.github.com/repos/lgnlgn/ansj4solr/issues/comments{/number}",
  "contents_url": "https://api.github.com/repos/lgnlgn/ansj4solr/contents/{+path}",
  "compare_url": "https://api.github.com/repos/lgnlgn/ansj4solr/compare/{base}...{head}",
  "merges_url": "https://api.github.com/repos/lgnlgn/ansj4solr/merges",
  "archive_url": "https://api.github.com/repos/lgnlgn/ansj4solr/{archive_format}{/ref}",
  "downloads_url": "https://api.github.com/repos/lgnlgn/ansj4solr/downloads",
  "issues_url": "https://api.github.com/repos/lgnlgn/ansj4solr/issues{/number}",
  "pulls_url": "https://api.github.com/repos/lgnlgn/ansj4solr/pulls{/number}",
  "milestones_url": "https://api.github.com/repos/lgnlgn/ansj4solr/milestones{/number}",
  "notifications_url": "https://api.github.com/repos/lgnlgn/ansj4solr/notifications{?since,all,participating}",
  "labels_url": "https://api.github.com/repos/lgnlgn/ansj4solr/labels{/name}",
  "releases_url": "https://api.github.com/repos/lgnlgn/ansj4solr/releases{/id}",
  "created_at": "2013-10-25T08:49:33Z",
  "updated_at": "2015-10-12T10:32:16Z",
  "pushed_at": "2014-04-07T10:15:40Z",
  "git_url": "git://github.com/lgnlgn/ansj4solr.git",
  "ssh_url": "git@github.com:lgnlgn/ansj4solr.git",
  "clone_url": "https://github.com/lgnlgn/ansj4solr.git",
  "svn_url": "https://github.com/lgnlgn/ansj4solr",
  "homepage": null,
  "size": 7580,
  "stargazers_count": 8,
  "watchers_count": 8,
  "language": "Java",
  "has_issues": true,
  "has_downloads": true,
  "has_wiki": true,
  "has_pages": false,
  "forks_count": 8,
  "mirror_url": null,
  "open_issues_count": 0,
  "forks": 8,
  "open_issues": 0,
  "watchers": 8,
  "default_branch": "master",
  "network_count": 8,
  "subscribers_count": 5
}

## Advanced Search

https://github.com/search?utf8=%E2%9C%93&q=location%3AShanghai+location%3AChina+language%3AScala&type=Users&ref=advsearch&l=&l=Scala

+ userlist
    \#user_search_results > div.user-list > div
+ address
    \#user_search_results > div.user-list > div > div.user-list-info > ul > li:nth-child(1) > span
+ email
    \#user_search_results > div.user-list > div > div.user-list-info > ul > li:nth-child(2) > span > a
+ a
    \#user_search_results > div.user-list > div > div.user-list-info > a
