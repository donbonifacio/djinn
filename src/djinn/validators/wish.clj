(ns djinn.validators.wish
  (:require [metis.core :refer :all]))

  (defvalidator validate
    [:type :inclusion {:in [:improvement :new-feature]}])

  (defn valid? [wish]
    (= (validate wish) {}))
