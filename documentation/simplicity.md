## Simplicity


Gradle build files are much easier to read.
Whereas maven build files are written in xml, gradle build files
are specified in groovy. 
It means that every line has meaning and there is no cumbersome document structure that you need to ingore.

Lets compare the two build files for <code>dependency-one</code>

<pre><code>
apply plugin: 'java'
sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    testCompile("org.mockito:mockito-core:2.11.0")
    testCompile("org.hamcrest:hamcrest-all:1.3")
    testCompile 'junit:junit:4.12'
}

repositories {
    mavenCentral()
    jcenter()
}
</code>
</pre>

This is fairly easy to understand even if you dont know the specific constructs 
of the gradle build tasks.

1. We apply some java plugin
2. We pull in some dependencies (test ones in this case)
3. We declare some repositories in which to find our dependencies

That's it. All expressed in 14 lines of succinct and easy to read code

Lets now have a look at it's maven equivalent: 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.worth.warp</groupId>
    <artifactId>dependency-one</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>2.11.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-all</artifactId>
            <version>1.3</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

This build file expresses the same thing but its a lot harder to see what is going on.
Look at how we declare dependencies for examples? 6 line of code instead of one!

Thats fine for my simple project but what will this look like on a real project with many more dependencies.

