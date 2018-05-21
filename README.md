# Launcher

[![Build Status](https://travis-ci.org/arthurbdiniz/Launcher.svg?branch=master)](https://travis-ci.org/arthurbdiniz/Launcher)
![Maven Central Latest](https://maven-badges.herokuapp.com/maven-central/net.wasdev.wlp.gradle.plugins/liberty-gradle-plugin/badge.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1634f57e864d44a797baaa707472ff87)](https://www.codacy.com/app/arthurbdiniz/Launcher?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=arthurbdiniz/Launcher&amp;utm_campaign=Badge_Grade)
[![JDK](https://img.shields.io/badge/JDK-8-brightgreen.svg)]()
[![Version](https://img.shields.io/badge/version-1.0-blue.svg)]()



### Install Gradle

It’s highly recommended to use an installer:

[SDKMAN](http://sdkman.io/)

[Homebrew](https://brew.sh/) (brew install gradle)

As a last resort, if neither of these tools suit your needs, you can download the binaries from [http://www.gradle.org/downloads](http://www.gradle.org/downloads). Only the binaries are required, so look for the link to gradle-version-bin.zip. (You can also choose gradle-version-all.zip to get the sources and documentation as well as the binaries.)

Unzip the file to your computer, and add the bin folder to your path.


### Test Gradle Installation
To test the Gradle installation, run Gradle from the command-line:

```
$ gradle
```

If all goes well, you see a welcome message:
```
:help

Welcome to Gradle 2.3.

To run a build, run gradle <task> ...

To see a list of available tasks, run gradle tasks

To see a list of command-line options, run gradle --help

BUILD SUCCESSFUL

Total time: 2.675 secs
```

### What Gradle can do?

Find out what Gradle can do
Now that Gradle is installed, see what it can do. Before you even create a build.gradle file for the project, you can ask it what tasks are available:

```
$ gradle tasks
```
You should see a list of available tasks. Assuming you run Gradle in a folder that doesn’t already have a build.gradle file, you’ll see some very elementary tasks such as this:

```
:tasks

== All tasks runnable from root project

== Build Setup tasks
setupBuild - Initializes a new Gradle build. [incubating]

== Help tasks
dependencies - Displays all dependencies declared in root project 'gs-gradle'.
dependencyInsight - Displays the insight into a specific dependency in root project 'gs-gradle'.
help - Displays a help message
projects - Displays the sub-projects of root project 'gs-gradle'.
properties - Displays the properties of root project 'gs-gradle'.
tasks - Displays the tasks runnable from root project 'gs-gradle'.

To see all tasks and more detail, run with --all.

BUILD SUCCESSFUL

Total time: 3.077 secs
```

Even though these tasks are available, they don’t offer much value without a project build configuration. As you flesh out the build.gradle file, some tasks will be more useful. The list of tasks will grow as you add plugins to build.gradle, so you’ll occasionally want to run tasks again to see what tasks are available.


### Build project with Gradle Wrapper
The Gradle Wrapper is the preferred way of starting a Gradle build. It consists of a batch script for Windows and a shell script for OS X and Linux. These scripts allow you to run a Gradle build without requiring that Gradle be installed on your system. This used to be something added to your build file, but it’s been folded into Gradle, so there is no longer any need. Instead, you simply use the following command.

```
$ gradle wrapper --gradle-version 2.13
```

After this task completes, you will notice a few new files. The two scripts are in the root of the folder, while the wrapper jar and properties files have been added to a new gradle/wrapper folder.

```
└── <project folder>
    └── gradlew
    └── gradlew.bat
    └── gradle
        └── wrapper
            └── gradle-wrapper.jar
            └── gradle-wrapper.properties
```

The Gradle Wrapper is now available for building your project. Add it to your version control system, and everyone that clones your project can build it just the same. It can be used in the exact same way as an installed version of Gradle. Run the wrapper script to perform the build task, just like you did previously:

```
./gradlew build
```

The first time you run the wrapper for a specified version of Gradle, it downloads and caches the Gradle binaries for that version. The Gradle Wrapper files are designed to be committed to source control so that anyone can build the project without having to first install and configure a specific version of Gradle.

At this stage, you will have built your code. You can see the results here:

```
build
├── classes
│   └── main
│       └── launcher
│           └── Main.class
├── dependency-cache
├── libs
│   └── gs-gradle-0.1.0.jar
└── tmp
    └── jar
        └── MANIFEST.MF
```

### Run project

Then you can run the app!
```
$ ./gradlew run
```

* Output

```shell
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:run
The current local time is: 16:16:20.544

BUILD SUCCESSFUL

Total time: 3.798 secs
```
