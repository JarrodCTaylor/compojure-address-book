(ns address-book.core.routes.address-book-routes
  (:require [compojure.core :refer :all]
            [address-book.core.views.address-book-layout :refer [common-layout]]))

(defn example-post [request]
  (let [post-value (get-in request [:params :example-post])]
    (str "You posted: " post-value)))

(defn example-get [request]
  (common-layout
    [:p "Example GET"]))

(defroutes address-book-routes
  (GET "/" [] example-get)
  (POST "/post" [] example-post))
