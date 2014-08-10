(ns djinn.validators.wish-spec
  (:require [speclj.core :refer :all]
            [djinn.data-types.wish :refer :all]
            [djinn.validators.wish :refer :all])
  (:import [djinn.data_types.wish Wish]))

(describe "validate"

  (with labels ["dashboard" "invoicing"])
  (with requests { :user-voice 2 :desk 3 })

  (it "shows type errors"
    (let [invalid-type-wish (Wish. :invalid "description"
                                   :new     "observations"
                                   labels   requests)]
      (should-not-be nil? (:type (validate invalid-type-wish)))))

  (it "shows status errors"
    (let [invalid-status-wish (Wish. :improvement "desc"
                                     :invalid     "an observation"
                                     labels       requests)]
      (should-not-be nil? (:status (validate invalid-status-wish))))))

