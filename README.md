Factory News Reader (android mobile app)
=================

Factory News Reader app illustrating Android development best practices with Android Jetpack.

Getting Started
---------------

Screenshots
-----------
| [![Screen1](https://raw.githubusercontent.com/Becirr/Factory-News-Reader/master/screenshots/s1.jpg)]() | [![Screen2](https://raw.githubusercontent.com/Becirr/Factory-News-Reader/master/screenshots/s2.jpg)]() |
|:---:|:---:|:---:|:---:|:---:|

Architecture
--------------
**Model–View–ViewModel (MVVM)** is a software design pattern that is structured to separate program logic and user interface controls. MVVM is also known as model-view-binder and was created by Microsoft architects Ken Cooper and John Gossman. Like many other design patterns, MVVM helps organize code and break programs into modules to make development, updating and reuse of code simpler and faster. The pattern is often used in Windows and web graphics presentation software.

![MVVM](https://upload.wikimedia.org/wikipedia/commons/8/87/MVVMPattern.png "Model–View–ViewModel")

**Repository module** handle data operations. They provide more generic API so that the rest of the app can access data layer easily.

![Repository patternb](https://raw.githubusercontent.com/Becirr/Factory-News-Reader/master/screenshots/diagram.png "Repository pattern")

Libraries
--------------
* [Retorift](https://github.com/square/retrofit) Used for API requests
* [Room](https://developer.android.com/topic/libraries/architecture/room) Used for database
* [Dagger 2](https://github.com/google/dagger) Used for dependency injection
* [Glide](https://github.com/bumptech/glide) Used for image loading
* [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started) Handle everything needed for in-app navigation
* [ViewModel](https://www.google.com/aclk?sa=l&ai=DChcSEwjF_9mdi9rsAhWFGHsKHfBeCUMYABAAGgJsZQ&sig=AOD64_3JpFaMS2BFPlkU6waX4Jkw3UVD1g&q&adurl&ved=2ahUKEwil39Cdi9rsAhUK_CoKHaWPDa8Q0Qx6BAgwEAE) Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution
