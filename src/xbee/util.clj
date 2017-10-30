(ns xbee.util)

(defn str->int
  [number]
  (if (string? number)
    (Integer/parseInt number)
    number))

(defn str->bytes
  [msg]
  (if (string? msg)
    (.getBytes msg)
    msg))

