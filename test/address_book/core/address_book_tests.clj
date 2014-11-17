(ns address-book.core.address-book-tests
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [address-book.core.handler :refer :all]))

(facts "Example GET and POST tests"

  (fact "Test GET"
    (let [response (app (mock/request :get "/"))]
      (:status response) => 200
      (:body response) => (contains "Example GET")))

  (fact "Test POST"
    (let [response (app (mock/request :post "/post" {:example-post "Some data"}))]
      (:status response) => 200
      (:body response) => "You posted: Some data")))
