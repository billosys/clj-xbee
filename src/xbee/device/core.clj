(ns xbee.device.core
  (:require
    [xbee.device.impl.abstract :as abstract]
    [xbee.device.impl.raw802 :as raw802]
    [xbee.device.impl.xbee :as xbee]
    [xbee.util :as util])
  (:import
    (com.digi.xbee.api AbstractXBeeDevice Raw802Device XBeeDevice)))

(defprotocol AbstractXBeeDeviceAPI
  (execute-param [this])
  (get-16bit-addr [this])
  (get-64bit-addr [this])
  (get-adc-value [this io-line])
  (get-conn-interface [this])
  (get-dest-addr [this])
  (get-dio-change-detection [this io-line])
  (get-dio-value [this io-line])
  (get-firmware-version [this])
  (get-hardware-version [this])
  (get-io-config [this io-line])
  (get-io-sampling-rate [this])
  (get-ipv6-addr [this])
  (get-ipv6-dest-addr [this])
  (get-node-id [this])
  (get-pan-id [this])
  (get-param [this param])
  (get-power-level [this])
  (get-pwm-duty-cycle [this io-line])
  (get-xbee-protocol [this])
  (apply-config-changes? [this])
  (remote? [this])
  (read-device-info [this])
  (read-io-sample [this])
  (reset [this])
  (set-destination-addr [this address])
  (set-dio-change-detection [this io-lines])
  (set-dio-value [this io-line io-mode])
  (set-io-config [this io-line io-mode])
  (set-io-sampling-rate [this rate])
  (set-ipv6-dest-addr [this address])
  (set-node-id [this node-id])
  (set-pan-id [this paid-id])
  (set-param [this param value])
  (set-power-level [this power-level])
  (set-pwm-duty-cycle [this io-line duty-cycle])
  (update-device-data-from [this device])
  (write-changes [this]))

(extend AbstractXBeeDevice
        AbstractXBeeDeviceAPI
        abstract/behaviour)

(defprotocol XBeeDeviceAPI
  (close [this])
  (open [this])
  (send-broadcast-data [this data]))

(extend XBeeDevice
        XBeeDeviceAPI
        xbee/behaviour)

(extend Raw802Device
        XBeeDeviceAPI
        xbee/behaviour)

(defn create-device
  [device-type port baud-rate]
  ;; The following line is a work-around for a bug in rxtx, taken from
  ;; here: https://bugs.launchpad.net/ubuntu/+source/rxtx/+bug/367833
  (System/setProperty "gnu.io.rxtx.SerialPorts" port)
  (case device-type
    :raw802 (raw802/create-device port baud-rate)
    :xbee (xbee/create-device port baud-rate)))
