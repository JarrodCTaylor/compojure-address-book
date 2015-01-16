(ns address-book.core.models.query-defs
  (:require [environ.core :refer [env]]
            [yesql.core :refer [defqueries]]))

(defqueries "address_book/core/models/address_book_queries.sql" {:connection (env :database-url)})
