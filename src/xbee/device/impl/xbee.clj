(ns xbee.device.impl.xbee
  (:require [xbee.util :as util])
  (:import (com.digi.xbee.api XBeeDevice)))

(def behaviour
  {:close #(.close %)
   :open #(.open %)
   :send-broadcast-data (fn [this data]
                         (.sendBroadcastData
                          this (util/str->bytes data)))})

(defn create-device
  [port baud-rate]
  (new XBeeDevice port (util/str->int baud-rate)))
