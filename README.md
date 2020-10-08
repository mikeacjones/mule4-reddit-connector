# Mule 4 Reddit Connector

![Publish Package](https://github.com/mikeacjones/mule4-reddit-connector/workflows/Publish%20package/badge.svg?branch=1.0.0)

This connector provides a post and comment listener, as well as fairly common operations, against the Reddit API. The Post and Comment listeners automatically handle paginating through new submissions and filtering out already processed items.

![screenshot1](/.github/images/screenshot1.png)

![screenshot2](/.github/images/screenshot3.png)

![screenshot3](/.github/images/screenshot2.png)

## Installation

This package is currently published via GitHub Packages. You can find the latest package [here](https://github.com/mikeacjones/mule4-reddit-connector/packages).

To utilize GitHub Packages with Maven you need to do the following:

#### Generate GitHub Token

1. Log into GitHub
2. Click on your profile image in the upper right and click on settings
3. On the left navigation list, click on Developer settings
4. On the left navigation list, click on Personal access tokens
5. Click Generate new token
6. Name tokens something like `GitHub Packages - Read`
7. Select the scope `read:packages` - no other scope is necessary.
8. Copy this token and save somewhere secure, such as LastPass. If you lose track of the token, you'll need to generate a new token.

#### Update your maven settings.xml

1. Add a new `server` entry

```XML
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<settings>
  <servers>
    <server>
      <id>github-mule4-reddit-connector</id>
      <username>GITHUB_USERNAME</username>
      <password>GITHUB_PERSONAL_ACCESS_TOKEN</password>
    </server>
  </servers>
  ...
</settings>
```

2. Create a new repository entry either in `pom.xml` or `settings.xml` if being used in multiple projects

```XML
<repository>
  <id>github-mule4-reddit-connector</id>
  <name>GitHub Mulesoft-FHIR Apache Maven Packages</name>
  <url>https://maven.pkg.github.com/mikeacjones/mule4-reddit-connector</url>
  <releases><enabled>true</enabled></releases>
  <snapshots><enabled>true</enabled></snapshots>
</repository>
```

#### Reddit Setup

To connect to reddit, you need a reddit account and `client_id` and `client_secret`. These instructions assume you're using reddit.com and not old.reddit.com.

1. Log into reddit.com
2. Go to `User settings`
3. click on `Safety and Privacy`
4. Scroll to the bottom of the page and click on `Manage third-party app authorization`
5. Click button to create an app
6. Select `persoanl use script` and generate. Copy and save `id` (visible code under app name) and `secret`.
7. Input these settings into global Reddit config object

## Usage

#### Comment/Post Listener

By default, the comment and post listeners will only feed in new comments and posts since startup of app. If you would like to add the ability for the app to poll missed submissions, create a persistent object store and assign to listener. 

Up to 100 new posts/comments are fed into the flow at a time, based on how many are found on each poll. The listener will continue firing even while flow is processing, so set your max concurrency if necessary.

The listeners will respect Reddit's rate limiting and attemp to automatically queue operations/polling; however, I don't recommend setting polling frequency lower than 5,000ms.

#### Operations

The following operations are support:

* Approve Thing
* Delete My Comment/Post
* Get Comment by Fullname
* Get Comments Listin g
* Get Host Posts Listing
* Get New Posts Listing
* Get Post Comments
* Get Post by Fullname
* Get Rising Posts Listing
* Get Subreddit Flair Templates
* Get Subreddit Moderators
* Get User Information
* Get User's Subreddit Flair
* Post Comment
* Remove Thing
* Send Private Message
* Set Comment/Post Lock Status
* Set Post Sticky
* Set User's Subreddit Flair (Extended)
* Set User's Subreddit Flair (Simple)
* Submit Text Post
* Update Comment/Text Post

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
