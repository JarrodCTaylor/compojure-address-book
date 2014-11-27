# address-book

This repo is an example address book application written in Clojure using
ring/compojure. This code accompanies the blog series [Compojure-Address-Book](http://www.jarrodctaylor.com/posts/Compojure-Address-Book-Part-1/)

# Finished application

![address-book](https://cloud.githubusercontent.com/assets/4416952/5063661/e2eff476-6db4-11e4-88fa-814d2eec5106.gif)

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

You will need to set up your postgres database, run:

    `psql -U <your_postgres_user> -f database.sql`

## Running the application locally

To start a web server for the application, run:

    `lein ring server`

## Running the tests

    `lein midje`
