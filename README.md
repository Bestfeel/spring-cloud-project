

###  Microservices 


## Prerequisites

### Develop

- [Git](http://git-scm.com/downloads)
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)


####   maven   清理仓库缓存（由于网络问题导致的依赖包下载问题）

```
mvn clean  install  -U  -Dmaven.test.skip=true

```

####  打包编译


```
mvn clean compile  package  -Dmaven.test.skip=true

```





