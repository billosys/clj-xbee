(defn get-prompt
  [ns]
  (str "\u001B[35m[\u001B[34m"
       ns
       "\u001B[35m]\u001B[33m λ\u001B[m=> "))

(defproject systems.billo/clj-xbee "0.1.0-SNAPSHOT"
  :description "Clojure Wrapper for Digi's Official XBee Java Library"
  :url "https://github.com/billosys/clj-xbee"
  :license {
    :name "Apache License Version 2.0"
    :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :exclusions [
    [org.clojure/clojure]]
  :dependencies [
    [com.digi.xbee/xbee-java-library "1.2.1"]
    [org.clojure/clojure "1.8.0"]
    [potemkin "0.4.4"]]
  :profiles {
    :ubercompile {:aot :all}
    :custom-repl {
      :repl-options {
        :init-ns xbee.dev
        :prompt ~get-prompt}}
    :dev {
      :source-paths ["dev-resources/src"]
      :dependencies [
        [clojusc/trifl "0.2.0"]
        [org.clojure/tools.namespace "0.2.11"]]}
    :test {
      :plugins [
        [lein-ancient "0.6.14"]
        [jonase/eastwood "0.2.5"]
        [lein-bikeshed "0.5.0" :exclusions [org.clojure/tools.namespace]]
        [lein-kibit "0.1.5"]
        [venantius/yagni "0.1.4"]]}}
  :aliases {
    "repl"
      ["with-profile" "+test,+custom-repl" "repl"]
    "check-deps"
      ^{:doc (str "Check if any deps have out-of-date versions")}
      ["with-profile" "+test" "ancient" "check" ":all"]
    "lint"
      ^{:doc (str "Perform lint checking")}
      ["with-profile" "+test" "kibit"]
    "ubercompile"
      ["with-profile" "+ubercompile" "compile"]
    "build"
      ^{:doc (str "Perform build tasks for CI/CD & releases\n\n"
                 "Additional aliases:")}
      ["with-profile" "+test" "do"
        ["check-deps"]
        ["lint"]
        ["test"]
        ["compile"]
        ["uberjar"]]})
