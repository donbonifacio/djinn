(ns djinn.wishes-spec
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
    (should= :success (:code (create wish))))

  (it ""))
