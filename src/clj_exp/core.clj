(ns clj-exp.core
  (:require [org.httpkit.server :as s]
            [compojure.core :refer [routes GET]]))

(defn handler [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "<h1>Hello World</h1>"})

(defn app []
  (routes
    (GET "/" [:as req]
      {:status 200
       :headers {"Content-Type" "text/html"}
       :body "<h1>Hello world from root route!</h1>"})
    (GET "/:user-name" [user-name :as req]
      {:status 200
       :headers {"Content-Type" "text/html"}
       :body (format "<h1>Hi from %s</h1>" user-name)})
    (GET "/*" [:as req]
      {:status 404
       :headers {"Content-Type" "text/html"}
       :body "<h1>Not found</h1>"})))

(defn create-server []
  (s/run-server (app) {:port 5000}))

(defn stop-server [server]
  (server :timeout 100))