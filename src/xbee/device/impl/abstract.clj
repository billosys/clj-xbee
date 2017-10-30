(ns xbee.device.impl.abstract
  (:require [xbee.util :as util]))

(defn get-16bit-addr
  [this]
  (let [addr (.getValue (.get16BitAddress this))]
    (new String addr)))

(defn get-ipv6-dest-addr
  [this]
  (try (.getIPv6DestinationAddress this)
    (catch Exception e
      {:error (.getMessage e)})))

(defn get-power-level
  [this]
  (let [pl (.getPowerLevel this)]
    {:id (.getValue pl) :name (.getDescription pl)}))

(defn get-xbee-protocol
  [this]
  (let [prtl (.getXBeeProtocol this)]
    {:id (.getID prtl) :name (.getDescription prtl)}))

(def behaviour
  {:execute-param #(.executeParameter %1 %2)
   :get-16bit-addr get-16bit-addr
   :get-64bit-addr #(.generateDeviceID (.get64BitAddress %))
   :get-adc-value #(.getADCValue %1 %2)
   :get-conn-interface #(.getConnectionInterface %)
   :get-dest-addr #(.getDestinationAddress %)
   :get-dio-change-detection #(.getDIOChangeDetection %)
   :get-dio-value #(.getDIOValue %1 %2)
   :get-firmware-version #(.getFirmwareVersion %)
   :get-hardware-version #(.getValue (.getHardwareVersion %))
   :get-io-config #(.getIOConfiguration %1 %2)
   :get-io-sampling-rate #(.getIOSamplingRate %)
   :get-ipv6-addr #(.getIPv6Address %)
   :get-ipv6-dest-addr get-ipv6-dest-addr
   :get-node-id #(.getNodeID %)
   :get-pan-id #(.getPANID %)
   :get-param #(.getParameter %1 %2)
   :get-power-level get-power-level
   :get-pwm-duty-cycle #(.getPWMDutyCycle %1 %2)
   :get-xbee-protocol get-xbee-protocol
   :apply-config-changes? #(.isApplyConfigurationChangesEnabled %)
   :remote? #(.isRemote %)
   :read-device-info #(.readDeviceInfo %)
   :read-io-sample #(.readIOSample %)
   :reset #(.reset %)
   :set-dest-addr #(.setDestinationAddress %1 %2)
   :set-dio-change-detection #(.setDIOChangeDetectio %1 %2)
   :set-dio-value #(.setDIOValue %1 %2 %3)
   :set-io-config #(.setIOConfiguration %1 %2 %3)
   :set-io-sampling-rate #(.setIOSamplingRate %1 %2)
   :set-ipv6-dest-addr #(.setIPv6DestinationAddress %1 %2)
   :set-node-id #(.setNodeID %1 %2)
   :set-pan-id #(.setPANID %1 %2)
   :set-param #(.setParameter %1 %2 %3)
   :set-power-level #(.setPowerLevel %1 %2)
   :set-pwm-duty-cycle #(.setPWMDutyCycle %1 %2 %3)
   :update-device-data-from #(.updateDeviceDataFrom %1 %2)
   :write-changes #(.writeChanges %)})
