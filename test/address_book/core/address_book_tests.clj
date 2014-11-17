(ns address-book.core.address-book-tests
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [address-book.core.handler :refer :all]
            [address-book.core.models.database :refer [database db]]
            [address-book.core.models.query-defs :as query]))

(def test-db (database :test))

(facts "Example GET and POST tests"
  (with-state-changes [(before :facts (query/create-contacts-table-if-not-exists! {} {:connection test-db}))
                       (after  :facts (query/drop-contacts-table!                 {} {:connection test-db}))]

  (fact "Test GET request to / route returns expected contacts"
    (with-redefs [db test-db]
      (query/insert-contact<! {:name "JT" :phone "(321)" :email "JT@JT.com"} {:connection test-db})
      (query/insert-contact<! {:name "Utah" :phone "(432)" :email "J@Buckeyes.com"} {:connection test-db})
      (let [response (app (mock/request :get "/"))]
        (:status response) => 200
        (:body response) => (contains "<div class=\"column-1\">JT</div>")
        (:body response) => (contains "<div class=\"column-1\">Utah</div>"))))

  (fact "Test POST to /post creates a new contact"
    (with-redefs [db test-db]
      (count (query/all-contacts {} {:connection test-db})) => 0
      (let [response (app (mock/request :post "/post" {:name "Some Guy" :phone "(123)" :email "a@a.cim"}))]
        (:status response) => 302
        (count (query/all-contacts {} {:connection test-db})) => 1)))

  (fact "Test UPDATE a post reuqest to /edit/<contact-id> updates desired contact information"
      (with-redefs [db test-db]
        (query/insert-contact<! {:name "JT" :phone "(321)" :email "JT@JT.com"} {:connection test-db})
        (let [response (app (mock/request :post "/edit/1" {:id "1" :name "Jrock" :phone "(999) 888-7777" :email "jrock@test.com"}))]
          (:status response) => 302
          (count (query/all-contacts {} {:connection test-db})) => 1
          (first (query/all-contacts {} {:connection test-db})) => {:id 1 :name "Jrock" :phone "(999) 888-7777" :email "jrock@test.com"})))

    (fact "Test DELETED a post to /delete/<contact-id> deletes desired contact form database"
      (with-redefs [db test-db]
        (query/insert-contact<! {:name "JT" :phone "(321)" :email "JT@JT.com"} {:connection test-db})
        (count (query/all-contacts {} {:connection test-db})) => 1
        (let [response (app (mock/request :post "/delete/1" {:id 1}))]
          (count (query/all-contacts {} {:connection test-db})) => 0)))))
