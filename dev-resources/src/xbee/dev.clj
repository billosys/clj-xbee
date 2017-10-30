(ns xbee.dev
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [clojure.pprint :refer [pprint]]
    [clojure.string :as string]
    [clojure.tools.namespace.repl :as repl]
    [clojure.walk :refer [macroexpand-all]]
    ;[clojusc.twig :as logger]
    [trifl.java :refer [show-methods]]
    [xbee.device.core :as device-core]
    [xbee.device.impl.abstract :as abstract]
    [xbee.device.impl.raw802 :as raw802]
    [xbee.device.impl.xbee :as xbee]
    [xbee.models.core :as models]))

;;; Setup

;(logger/set-level! '[xbee com.digi] :info)

;;; Aliases

(def reload #'repl/refresh)
(def reset #'repl/refresh)
