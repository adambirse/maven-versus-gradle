## Plugins

If you need to do something in gradle its probably a safe bet that someone 
has already done the same and has written a plugin for you to use.

There is a huge variety of plugins for you to choose from, some of my favourites and most used are:

- [Docker](https://github.com/bmuschko/gradle-docker-plugin)
- [Docker Compose](https://github.com/avast/gradle-docker-compose-plugin)
- [Dependency Updates](https://github.com/ben-manes/gradle-versions-plugin)
- [Flyway](https://flywaydb.org/getstarted/firststeps/gradle)
- [Release](https://github.com/researchgate/gradle-release)

You can of course write your own [custom plugin](https://docs.gradle.org/current/userguide/custom_plugins.html) too.


This allows you to very quickly extend the power of your builds to do whatever you want.

A word of caution regards applying these plugins to your build. Is to make sure that you apply them only where needed.
Applying a plugin will add to your configuration time, even if you are not using it.

For example you should typically avoid applying plugins in <code>allprojects{}</code> or <code>subprojects{}</code>
If you have 10 projects and only one of them uses a database then only apply the flyway plugin to that project.
