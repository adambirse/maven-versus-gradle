

## Speed

One of the biggest advantages gradle has over maven is speed.

It is faster 
It is more efficient. 
Gradle is smart about what tasks it runs. 
 
Gradle looks at the inputs of a task and only runs the task if they have changed. As an example if you haven't changed any class files or test files and you run the tests for a project by default it doesn't do anything.  Why would it?!


I have created a project structure that is typically representative of a real world project and run some scenarios against it.


### Without any performance tweaking

- <code>gradlew clean build</code>  -> 42 seconds
- <code>mvn clean package</code> -> 37 seconds  

hmm so far maven is faster this isn't looking good! Look what happens when we run the commands again though (without clean)

- <code>gradlew build</code> -> 2 seconds 
- <code>mvn package</code> -> 35 seconds

WOW that was better. What happened? Well because we didn't run clean, 
the build directories were not removed this meant that Gradle was smart enough to figure out that nothing had changed 
and so didn't do anything.


Lets do the same thing again but change some code in one of the projects (<code>dependency-one</code>)

- <code>gradlew build</code> -> 14 seconds 
- <code>mvn package</code> -> 34 seconds

Still faster but Gradle has rebuilt and tested only the components that have changed. 

So far we haven't done any special configuration for Gradle. 
This is all functionality straight out of the box. Lets look at some simple changes we can make to optimise things even further.

### Unleash the Daemon

Lets add a flag to our gradle properties.

<pre><code>org.gradle.daemon=true</code></pre>

This flag can be used to avoid some of the start up costs of gradle. 
Although the first build with this flag might be slower, subsequent builds are much faster.

See [here](https://docs.gradle.org/current/userguide/gradle_daemon.html) for more details.

Remember our first <code> gradlew clean build </code> took 42 seconds.  Lets enable the daemon and try again.

<code>gradlew clean build</code>  -> 34 seconds


### Parallel execution

<pre><code>org.gradle.parallel=true</code></pre>

By enabling this simple flag Gradle will execute what it can in parallel.  
Gradle is smart enough to know what tasks can and cannot be executed in parallel but it doesn't have visibility of dependencies outside of its control.
so for example if two projects are using the same database and test data you might run into trouble with this. 

Lets run this again and see what happens.

<code>gradlew clean build</code>  -> 26 seconds


### Configure on demand

<pre><code>org.gradle.configureondemand=true</code></pre>

Lets enable this flag and see what happens

<code>gradlew clean build</code>  -> 28 seconds

hmm ok no difference. Why? 
 
The answer to this is that my project is simply not complex enough.  
When you run any command Gradle runs an initialisation phase 
where it analyses task dependencies and does a variety of things to make sure that your gradle file is correct and capable of being run.
It does this for **EVERY** task not just the ones you are running.  If you imagine a build file that includes a variety of third party plugins
custom tasks etc.  This might take a while. 

<code>org.gradle.configureondemand=true</code> limits this checking to only the tasks that you are running.  
On a complex project this can shave seconds off your build time.

AS this example progresses I will endeavour to create a more realistic example that illustrates this.




