(ns address-book.core.views.address-book-layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common-layout [& body]
  (html5
    [:head
      [:title "Address Book"]
      (include-css "/css/address-book.css")]
    [:body
      [:h1 "Address Book"]
      body]))
