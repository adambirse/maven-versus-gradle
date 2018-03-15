## Modular

One of the things that I really like about gradle is 
being able to split your buid logic into separate gradle files.

I find this really useful when integrating third party plugins and building 
functionality for continuous integration.

My goal when doing this is to keep the 'main' build file as clean as possible
and apply a lot of plugins 

for example:

<pre>
<code>
buildscript {
	repositories {
		mavenCentral()
	}
}

repositories {
    mavenCentral()
}

apply plugin: 'java'
apply plugin: 'idea'
apply from: rootProject.file("gradle_support/code-coverage.gradle")
apply from: rootProject.file("gradle_support/spring-boot.gradle")
apply from: rootProject.file("gradle_support/docker-compose.gradle")

group = 'com.worth.warp'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = 1.8
</code>
</pre>

and an example of <code>spring-boot.gradle</code>

<pre>
<code>
apply plugin: org.springframework.boot.gradle.plugin.SpringBootPlugin

buildscript {
    ext {
        springBootVersion = '1.5.9.RELEASE'
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter')
    compile("org.springframework.boot:spring-boot-starter-web")
    testCompile('org.springframework.boot:spring-boot-starter-test')
}
</code>
</pre>

This approach allows you to easily switch technologies and approaches.  
For example it is nice and simple to get rid of docker-compose and replace it with something else.

It also allows you to think about your build files in a way you should as software artifacts!
Often build files are seen as an after thought and not given the same care and attention that we give
the 'normal' code base this is wrong and can lead to problems.

For example on a project I worked on I extracted a 'spring gradle' file and in the process discovered that 
we were applying this plugin everywhere and disabling the tasks that we didn't need. 

By performing the refactor I simplified things and perhaps more importantly sped up the build time.

