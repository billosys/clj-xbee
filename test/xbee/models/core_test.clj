(ns xbee.models.core-test
  (:require [clojure.test :refer :all]
            [xbee.models.core :as models]))

(deftest protocols
  (is (= 0
         (models/get-id (:zigbee models/protocols))))
  (is (= "ZigBee"
         (models/get-name (:zigbee models/protocols))))
  (is (= 1
         (models/get-id (:raw-802.15.4 models/protocols))))
  (is (= "802.15.4"
         (models/get-name (:raw-802.15.4 models/protocols))))
  (is (= 2
         (models/get-id (:xbee-wifi models/protocols))))
  (is (= "Wi-Fi"
         (models/get-name (:xbee-wifi models/protocols))))
  (is (= 3
         (models/get-id (:digi-mesh models/protocols))))
  (is (= "DigiMesh"
         (models/get-name (:digi-mesh models/protocols))))
  (is (= 4
         (models/get-id (:xcite models/protocols))))
  (is (= "XCite"
         (models/get-name (:xcite models/protocols))))
  (is (= 5
         (models/get-id (:xtend models/protocols))))
  (is (= "XTend (Legacy)"
         (models/get-name (:xtend models/protocols))))
  (is (= 6
         (models/get-id (:xtend-dm models/protocols))))
  (is (= "XTend (DigiMesh)"
         (models/get-name (:xtend-dm models/protocols))))
  (is (= 7
         (models/get-id (:smart-energy models/protocols))))
  (is (= "Smart Energy"
         (models/get-name (:smart-energy models/protocols))))
  (is (= 8
         (models/get-id (:digi-point models/protocols))))
  (is (= "Point-to-multipoint"
         (models/get-name (:digi-point models/protocols))))
  (is (= 9
         (models/get-id (:znet models/protocols))))
  (is (= "ZNet 2.5"
         (models/get-name (:znet models/protocols))))
  (is (= 10
         (models/get-id (:xc models/protocols))))
  (is (= "XSC"
         (models/get-name (:xc models/protocols))))
  (is (= 11
         (models/get-id (:xlr models/protocols))))
  (is (= "XLR"
         (models/get-name (:xlr models/protocols))))
  (is (= 12
         (models/get-id (:xlr-dm models/protocols))))
  (is (= "XLR"
         (models/get-name (:xlr-dm models/protocols))))
  (is (= 13
         (models/get-id (:sx models/protocols))))
  (is (= "XBee SX"
         (models/get-name (:sx models/protocols))))
  (is (= 14
         (models/get-id (:xlr-module models/protocols))))
  (is (= "XLR Module"
         (models/get-name (:xlr-module models/protocols))))
  (is (= 15
         (models/get-id (:cellular models/protocols))))
  (is (= "Cellular"
         (models/get-name (:cellular models/protocols))))
  (is (= 16
         (models/get-id (:cellular-nbiot models/protocols))))
  (is (= "Cellular NB-IoT"
         (models/get-name (:cellular-nbiot models/protocols))))
  (is (= 17
         (models/get-id (:thread models/protocols))))
  (is (= "Thread"
         (models/get-name (:thread models/protocols)))))
