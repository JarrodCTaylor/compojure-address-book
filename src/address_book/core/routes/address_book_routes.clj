(ns address-book.core.routes.address-book-routes
  (:require [ring.util.response :as response]
            [compojure.core :refer :all]
            [address-book.core.views.address-book-layout :refer [common-layout
                                                                 read-contact
                                                                 add-contact-form]]
            [address-book.core.models.query-defs :as query]))

(defn post-route [request]
  (let [name  (get-in request [:params :name])
        phone (get-in request [:params :phone])
        email (get-in request [:params :email])]
    (query/insert-contact<! {:name name :phone phone :email email})
    (response/redirect "/")))

(defn get-route [request]
  (common-layout
    (for [contact (query/all-contacts)]
      (read-contact contact))
    (add-contact-form)))

(defroutes address-book-routes
  (GET  "/"     [] get-route)
  (POST "/post" [] post-route))
