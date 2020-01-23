(ns auth-cljs-example.core
  (:require [compojure.core         :refer [defroutes GET]]
            [compojure.route        :refer [not-found resources]]
            [hiccup.core            :refer :all]
            [hiccup.page            :refer :all]
            [ring.adapter.jetty     :as jetty]
            [ring.util.response :as resp]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn foo [request]
  (html5 [:h1 "Welcome to the Auth-Cljs-Example"]))

(defroutes app
  (GET "/" [] foo)
  (GET "/login" [] (resp/resource-response "login.html" {:root "public"}))
  ;;(GET "/signup" [] (resp/resource-response "signup.html" {:root "public"}))
  (resources "/")
  (not-found "<h1>Page not found</h1>"))

(defn -main []
  (jetty/run-jetty  (wrap-reload #'app) {:port 8000}))
