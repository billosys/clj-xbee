(ns xbee.device.impl.raw802
  (:require [xbee.util :as util])
  (:import (com.digi.xbee.api Raw802Device)))

(defprotocol Raw802DeviceAPI)

(def behaviour
  {}
  )

(defn create-device
  [port baud-rate]
  (new Raw802Device port (util/str->int baud-rate)))
