(ns djinn.use-cases.wishes-spec
  (:require [speclj.core :refer :all]
            [djinn.use-cases.wishes :refer :all]
            [djinn.data-types.wish :refer :all])
  (:import [djinn.data_types.wish Wish]))


(describe "create"
  (with labels ["dashboard" "invoicing"])
  (with requests { :user-voice 2 :desk 3 })
  (with wish (Wish. :improvement "a description"
                    :new         "observations"
                    labels         requests))

  (it "returns success information"
    (should= :success (:code (create @wish))))

  (it "returns the newly created wish"
    (should= @wish (:wish (create @wish))))

  (context "invalid input"
    (with invalid-wish (Wish. :invalid "description"
                                   :new     "observations"
                                   labels   requests))

    (it "returns error information"
      (should= :error (:code (create invalid-wish))))))
