(ns xbee.models.core
  (import (com.digi.xbee.api.models XBeeProtocol)))

(def protocols
  {:cellular XBeeProtocol/CELLULAR
   :cellular-nbiot XBeeProtocol/CELLULAR_NBIOT})

(defprotocol XBeeProtocolAPI
  (get-id [this])
  (get-name [this]))

(def xbee-protocol-behaviour
  {:get-id (fn [this] (.getID this))
   :get-name #(str %)})

(extend XBeeProtocol
        XBeeProtocolAPI
        xbee-protocol-behaviour)
