(ns xbee.core-test
  (:require [clojure.test :refer :all]
            [xbee.core :as xbee]))

(deftest version
  (is (= "1.2.1" xbee/version)))
