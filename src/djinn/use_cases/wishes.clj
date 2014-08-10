(ns djinn.use-cases.wishes
  (:require [djinn.validators.wish :refer :all]))
  (defn create [wish]
    (if (valid? wish)
      {:code :success :wish wish}
      {:code :error}))
