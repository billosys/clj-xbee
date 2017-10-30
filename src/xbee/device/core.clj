(ns xbee.device.core
  (:require [xbee.util :as util])
  (:import (com.digi.xbee.api AbstractXBeeDevice XBeeDevice)))

(defprotocol AbstractXBeeDeviceAPI)

(def abstract-behaviour
  {})

(extend AbstractXBeeDevice
        AbstractXBeeDeviceAPI
        abstract-behaviour)

(defprotocol XBeeDeviceAPI
  (close [this])
  (open [this])
  (send-broadcast-data [this data]))

(def behaviour
  {:close #(.close %)
   :open #(.open %)
   :send-broadcast-data (fn [this data]
                         (.sendBroadcastData
                          this (util/str->bytes data)))})

(extend XBeeDevice
        XBeeDeviceAPI
        behaviour)

(defn create-device
  [port baud-rate]
  ;; The following line is a work-around for a bug in rxtx, taken from
  ;; here: https://bugs.launchpad.net/ubuntu/+source/rxtx/+bug/367833
  (System/setProperty "gnu.io.rxtx.SerialPorts" port)
  (new XBeeDevice port (util/str->int baud-rate)))
