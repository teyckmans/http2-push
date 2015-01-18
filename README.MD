# HTTP/2 push blog code

This repository contains code used to test the resource push functionality of HTTP/2.

## Structure
The repository contains a multi module Gradle build containing 3 modules:
- blog-http2-core: contains some shared code used by the other modules
- blog-http1-no-push: contains a servlet that does no push and can be deployed to any servlet container.
- blog-http2-push: contains a servlet that uses a Jetty specific api in order to perform HTTP/2 push, and can therefor only be deployed to Jetty.