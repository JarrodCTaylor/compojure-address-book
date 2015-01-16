(ns address-book.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn example-post [request]
  (let [post-value (get-in request [:params :example-post])]
    (str "You posted: " post-value)))

(defroutes app-routes
  (GET "/" [] "Example GET")
  (POST "/post" [] example-post)
  (route/not-found "Not Found"))

(def app (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
