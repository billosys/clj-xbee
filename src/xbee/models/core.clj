(ns xbee.models.core
  (import (com.digi.xbee.api.models XBeeProtocol)))

(def protocols
  {:cellular XBeeProtocol/CELLULAR
   :cellular-nbiot XBeeProtocol/CELLULAR_NBIOT
   :digi-mesh XBeeProtocol/DIGI_MESH
   :digi-point XBeeProtocol/DIGI_POINT
   :raw-802.15.4 XBeeProtocol/RAW_802_15_4
   :smart-energy XBeeProtocol/SMART_ENERGY
   :sx XBeeProtocol/SX
   :thread XBeeProtocol/THREAD
   :unknown XBeeProtocol/UNKNOWN
   :xbee-wifi XBeeProtocol/XBEE_WIFI
   :xc XBeeProtocol/XC
   :xcite XBeeProtocol/XCITE
   :xlr XBeeProtocol/XLR
   :xlr-dm XBeeProtocol/XLR_DM
   :xlr-module XBeeProtocol/XLR_MODULE
   :xtend XBeeProtocol/XTEND
   :xtend-dm XBeeProtocol/XTEND_DM
   :zigbee XBeeProtocol/ZIGBEE
   :znet XBeeProtocol/ZNET})

(defprotocol XBeeProtocolAPI
  (get-id [this])
  (get-name [this]))

(def xbee-protocol-behaviour
  {:get-id (fn [this] (.getID this))
   :get-name #(str %)})

(extend XBeeProtocol
        XBeeProtocolAPI
        xbee-protocol-behaviour)
