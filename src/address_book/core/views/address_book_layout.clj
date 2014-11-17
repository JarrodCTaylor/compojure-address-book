(ns address-book.core.views.address-book-layout
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.core :refer [html h]]))

(defn common-layout [& body]
  (html5
    [:head
     [:title "Address Book"]
     (include-css "/css/address-book.css")
     (include-css "http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css")]
    [:body
     [:div#wrapper
      [:h1#content-title "Address Book"]
      [:div#contacts
       [:div.contact.header
        [:div.column-1
         [:i.icon-user.icon-style] " Name"]
        [:div.column-2
         [:i.icon-phone.icon-style] " Phone"]
        [:div.column-3
         [:i.icon-envelope.icon-style] " Email"]
        [:div.clear-row]]
       body]]]))

(defn add-contact-form []
  (html
    [:div.contact
      [:form {:action "/post" :method "post"}
        [:div.column-1
          [:input#name-input {:type "text" :name "name" :placeholder "Name"}]]
        [:div.column-2
          [:input#phone-input {:type "text" :name "phone" :placeholder "Phone"}]]
        [:div.column-3
          [:input#email-input {:type "text" :name "email" :placeholder "Email"}]]
        [:button.button.add {:type "submit"} "Add "]]
        [:div.clear-row]]))

(defn read-contact [contact]
  (html
    [:div.contact
      [:div.contact-text
        [:div.column-1 (h (:name contact))]
        [:div.column-2 (h (:phone contact))]
        [:div.column-3 (h (:email contact))]]
      [:div.button-group
        [:form {:action (str "/edit/" (h (:id contact))) :method "get"}
          [:button.button.edit {:type "submit"}
            [:i.icon-pencil]]]
        [:form {:action (str "/delete/" (h (:id contact))) :method "post"}
          [:button.button.remove {:type "submit"}
            [:i.icon-remove]]]]
      [:div.clear-row]]))

(defn edit-contact [contact]
  (html
    [:div.contact
      [:form {:action (str "/edit/" (:id contact)) :method "post"}
        [:input {:type "hidden" :name "id" :value (h (:id contact))}]
        [:div.column-1
          [:input#name-input {:type "text" :name "name" :placeholder "Name" :value (h (:name contact))}]]
        [:div.column-2
          [:input#phone-input {:type "text" :name "phone" :placeholder "Phone" :value (h (:phone contact))}]]
        [:div.column-3
          [:input#email-input {:type "text" :name "email" :placeholder "Email" :value (h (:email contact))}]]
        [:div.button-group
          [:button.button.update {:type "submit"} "Update"]]]
      [:div.clear-row]]))
