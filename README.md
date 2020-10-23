# clj-exp

Clojure experiments using Leiningen for building a simple http server

## Usage

First spin up any Clojure REPL

    $ lein repl

Then require clj-exp.core, with an optional alias to quickly access it's namespace

    (user) => (require '[clj-exp.core :as c])

Right away you can get the server up and running

    (user) => (def server (c/create-server)
 
And you're good to go
    
-
    
Afterwards you can pass the created server to the stop-server function to put it down

    (user) => (c/stop-server server)


