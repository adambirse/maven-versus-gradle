## Extensible

Inevitably when creating a build / deployment pipeline we will have to do something a little bit different.
Something that there isn't a plugin for. 

Gradle allows us to write our own tasks to do whatever we want, and we can write them so they integrate with any other tasks in the gradle eco-system.

So for example, lets us decided that it is incredibly important for us to print the message 'Gradle is great' every time we run the build!

<pre>
<code>
task gradleIsGreat() {
    doFirst {
        println 'Gradle is Great !!!!'
    }
}

build.dependsOn gradleIsGreat
</code>
</pre> 

And that is all we need to do.  Note that I have included my task actions in a <code> doFirst {}</code> block
If we remove this. our print statement will be executed every time the task is configured rather than run.

To understand this include the task in your gradle file and run <code>clean</code>.  As expected the message does not appear.

However remove the <code>doFirst{}</code> block and run clean again.  The message will appear even though you have not executed the <code>build</code> task. 
This is not what you intended.
