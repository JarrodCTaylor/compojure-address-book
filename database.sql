CREATE ROLE address_book_user LOGIN;
ALTER ROLE address_book_user WITH PASSWORD 'password1';
CREATE DATABASE address_book;
CREATE DATABASE address_book_test;
GRANT ALL PRIVILEGES ON DATABASE address_book TO address_book_user;
GRANT ALL PRIVILEGES ON DATABASE address_book_test TO address_book_user;
