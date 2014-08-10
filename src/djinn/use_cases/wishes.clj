(ns djinn.use-cases.wishes
  (:require [djinn.validators.wish :refer :all]))
  (defn create [wish]
    (let [errors (validate wish)]
      (if (empty? errors)
        {:code :success :wish wish}
        {:code :error :errors errors})))

