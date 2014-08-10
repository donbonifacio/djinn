(ns djinn.validators.wish
  (:require [metis.core :refer :all]))

  (defvalidator validate
    [:type :inclusion {:in [:improvement :new-feature]}]
    [:status :inclusion {:in [:new :planned :postponed :ignored]}])

  (defn valid? [wish]
    (= (validate wish) {}))
