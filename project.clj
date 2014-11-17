(defproject address-book "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 [ring/ring-defaults "0.1.2"]
                 [midje "1.6.3"]
                 [hiccup "1.0.5"]
                 [org.clojure/java.jdbc "0.3.5"]
                 [postgresql/postgresql "9.1-901-1.jdbc4"]
                 [yesql "0.5.0-beta2"]]
  :plugins [[lein-ring "0.8.13"]
            [lein-midje "3.1.3"]]
  :ring {:handler address-book.core.handler/app
         :init    address-book.core.handler/init}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
