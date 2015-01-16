# address-book

The code found here corresponds with part 4 of the compojure address book
blog series found at [Compojure-Address-Book-Part-4/](www.jarrodctaylor.com/posts/Compojure-Address-Book-Part-4/)

# Finished application

![address-book](https://cloud.githubusercontent.com/assets/4416952/5063661/e2eff476-6db4-11e4-88fa-814d2eec5106.gif)

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Setting up Postgres

To configure your postgres database for local usage and tests, run:

    psql -U <your_postgres_user> -f provision_example_database.sql

## Running the application locally

To start a web server for the application, run:

    lein ring server

## Running the tests

    lein with-profile test midje

