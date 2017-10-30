(ns xbee.models.core-test
  (:require [clojure.test :refer :all]
            [xbee.models.core :as models]))

(deftest protocols
  (is (= 15
         (models/get-id (:cellular models/protocols))))
  (is (= "Cellular"
         (models/get-name (:cellular models/protocols))))
  (is (= 16
         (models/get-id (:cellular-nbiot models/protocols))))
  (is (= "Cellular NB-IoT"
         (models/get-name (:cellular-nbiot models/protocols)))))
