-- name: all-contacts
-- Selects all contacts
SELECT id
       ,name
       ,phone
       ,email
FROM contacts;

-- name: insert-contact<!
-- Queries a single contact
INSERT INTO contacts (name, phone, email)
    VALUES (:name, :phone, :email);

-- name: delete-contact<!
-- Deletes a single contact
DELETE FROM contacts
    WHERE id = :id;

-- name: update-contact<!
-- Update a single contact
UPDATE contacts SET name = :name, phone = :phone, email = :email
    WHERE id = :id;

-- name: drop-contacts-table!
-- drop the contacts table
DROP TABLE contacts;

-- name: create-contacts-table-if-not-exists!
-- create the contacts table if it does not exist
CREATE TABLE IF NOT EXISTS contacts (
   id serial PRIMARY KEY,
   name VARCHAR (20) NOT NULL,
   phone VARCHAR (14) NOT NULL,
   email VARCHAR (25) NOT NULL);
