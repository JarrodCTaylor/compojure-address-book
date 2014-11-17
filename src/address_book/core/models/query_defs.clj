(ns address-book.core.models.query-defs
  (:require [address-book.core.models.database :refer [database db]]
            [yesql.core :refer [defqueries]]))

(defqueries "address_book/core/models/address_book_queries.sql" {:connection db})
