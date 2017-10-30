(ns xbee.device.raw802
  (:require [xbee.device.core :as xbee]
            [xbee.util :as util])
  (:import (com.digi.xbee.api Raw802Device)))

(defprotocol Raw802DeviceAPI
  (close [this])
  (open [this])
  (send-broadcast-data [this data]))

(extend Raw802Device
        Raw802DeviceAPI
        xbee/behaviour)

(defn create-device
  [port baud-rate]
  ;; The following line is a work-around for a bug in rxtx, taken from
  ;; here: https://bugs.launchpad.net/ubuntu/+source/rxtx/+bug/367833
  (System/setProperty "gnu.io.rxtx.SerialPorts" port)
  (new Raw802Device port (util/str->int baud-rate)))
