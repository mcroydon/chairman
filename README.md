Chairman
========

A small demo project using [BlueEyes](https://github.com/jdegoes/blueeyes), a lightweight [Scala](http://www.scala-lang.org/) web framework inspired by [Sinatra](http://www.sinatrarb.com/) and [Scalatra](https://github.com/scalatra/scalatra) that uses one of my favorite async networking libraries [Netty](http://www.jboss.org/netty).

Chairman is based on the demo code provided in [BlueEyesDemo.scala](https://github.com/jdegoes/blueeyes/blob/master/src/main/scala/blueeyes/demo/BlueEyesDemo.scala).  It includes an sbt configuration based on [a gist by michaelklishin](https://gist.github.com/1063337) and `com.postneo.chairman.ChairmanServer` is a good example of a minimally useful read-only web service.

While it doesn't do anything particularly useful I hope that it's helpful to others looking for a simple example BlueEyes project.

Getting and running Chairman
----------------------------

1. Download and install [sbt](https://github.com/harrah/xsbt/wiki/Setup) 0.10.x if you haven't already.
2. Change to a directory that you would like to work in: `cd ~/code`
3. Check out Chairman: `git clone git://github.com/mcroydon/chairman.git`
4. Change to the Chairman directory: `cd chairman`
5. Update dependencies and run: `sbt run`
6. Check out the demo URLs at `http://127.0.0.1:8888/test/` and `http://127.0.0.1:8888/time/`.

License
-------

Chairman is based on example code from the BlueEyes project and is released under the MIT license.
