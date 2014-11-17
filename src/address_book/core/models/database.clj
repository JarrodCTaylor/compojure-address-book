(ns address-book.core.models.database)

(def database {:dev  {:subprotocol "postgresql"
                      :subname "//127.0.0.1:5432/address_book"
                      :user "address_book_user"
                      :password "password1"}
               :test {:subprotocol "postgresql"
                      :subname "//127.0.0.1:5432/address_book_test"
                      :user "address_book_user"
                      :password "password1"}})

(def db (database :dev))
