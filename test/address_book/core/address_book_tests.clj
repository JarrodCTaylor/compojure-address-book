(ns address-book.core.address-book-tests
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [address-book.core.handler :refer :all]
            [address-book.core.routes.address-book-routes :refer [contacts]]))

(facts "Example GET and POST tests"

  (fact "Test GET"
    (let [response (app (mock/request :get "/"))]
      (:status response) => 200
      (:body response) => (contains "<div class=\"column-1\">Jarrod Taylor</div>")
      (:body response) => (contains "<div class=\"column-1\">Johnny Utah</div>")
      (:body response) => (contains "<div class=\"column-1\">James Dalton</div>")))

  (fact "Test POST"
    (let [response (app (mock/request :post "/post" {:name "Bodhi" :phone "555-7890" :email "bells@beach.com"}))
          new-contact (filter #(= 4 (:id %)) @contacts)]
      (:status response) => 302
      (:name (first new-contact)) => "Bodhi")))
