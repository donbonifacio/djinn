(ns djinn.wishes-spec
  (:require [speclj.core :refer :all]
            [djinn.wishes :refer :all]))

(describe "create"
  (with wish (Wish. :improvement
                    "a description"
                    :new))
  (it "adds a new wish"
    (should false)))
