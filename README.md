java-graph2013
=
Git repository for an open-source Java graph library
started 12/13/2012

Supersedes: https://github.com/aisthesis/java-graph2012

This library currently includes relatively lightweight
classes that avoid the overhead involved in insuring thread-safety.
It is a rebuilt version of java-graph2012 using templates
to keep the library as lightweight and flexible as possible.
The main goal in this implementation is generality: Each algorithm
should be runnable on any graph that supports the required parameters
(not just specific implementations of graph types having these
parameters).
I plan to include thread-safe classes in a later version.

Javadocs documentation available at 
http://www.codemelon.com/content/documentation/graph2013/index.html
