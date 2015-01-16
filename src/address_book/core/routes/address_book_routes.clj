(ns address-book.core.routes.address-book-routes
  (:require [ring.util.response :as response]
            [compojure.core :refer :all]
            [address-book.core.views.address-book-layout :refer [common-layout
                                                                 read-contact
                                                                 add-contact-form
                                                                 edit-contact]]
            [address-book.core.models.query-defs :as query]))

(defn display-contact [contact contact-id]
  (if (not= (and contact-id (Integer. contact-id)) (:id contact))
    (read-contact contact)
    (edit-contact contact)))

(defn post-route [request]
  (let [name  (get-in request [:params :name])
        phone (get-in request [:params :phone])
        email (get-in request [:params :email])]
    (query/insert-contact<! {:name name :phone phone :email email})
    (response/redirect "/")))

(defn get-route [request]
  (let [contact-id (get-in request [:params :contact-id])]
    (common-layout
      (for [contact (query/all-contacts)]
        (display-contact contact contact-id))
      (add-contact-form))))

(defn delete-route [request]
  (let [contact-id (get-in request [:params :contact-id])]
    (query/delete-contact<! {:id (Integer. contact-id)})
    (response/redirect "/")))

(defn update-route [request]
  (let [contact-id (get-in request [:params :id])
        name       (get-in request [:params :name])
        phone      (get-in request [:params :phone])
        email      (get-in request [:params :email])]
    (query/update-contact<! {:name name :phone phone :email email :id (Integer. contact-id)})
    (response/redirect "/")))

(defroutes address-book-routes
  (GET  "/"                   [] get-route)
  (POST "/post"               [] post-route)
  (GET  "/edit/:contact-id"   [] get-route)
  (POST "/edit/:contact-id"   [] update-route)
  (POST "/delete/:contact-id" [] delete-route))
