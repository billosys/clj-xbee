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
    [org.clojure/clojure]
    [org.slf4j/slf4j-api]]
  :dependencies [
    [com.digi.xbee/xbee-java-library "1.2.1"]
    [org.clojure/clojure "1.9.0"]
    [org.slf4j/slf4j-api "1.7.25"]
    [potemkin "0.4.5"]]
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
        [clojusc/twig "0.3.2"]
        [org.clojure/tools.namespace "0.2.11"]]}
    :lint {
      :plugins [
        [lein-ancient "0.6.15"]
        [jonase/eastwood "0.2.6"]
        [lein-bikeshed "0.5.1"
          :exclusions [org.clojure/tools.namespace]]
        [lein-kibit "0.1.6"]
        [venantius/yagni "0.1.4"]]}
    :test {
      :plugins [
        [lein-ltest "0.3.0"]]}}
  :aliases {
    "repl"
      ["do"
        ["clean"]
        ["with-profile" "+test,+custom-repl,+dev" "repl"]]
    "check-vers"
      ["with-profile" "+lint" "ancient" "check" ":all"]
    "check-jars"
      ["with-profile" "+lint" "do"
        ["deps" ":tree"]
        ["deps" ":plugin-tree"]]
    "check-deps"
      ["do"
        ["check-jars"]
        ["check-vers"]]
    "kibit"
      ["with-profile" "+lint" "kibit"]
    "eastwood"
      ["with-profile" "+lint" "eastwood" "{:namespaces [:source-paths]}"]
    "lint"
      ["do"
        ["kibit"]
        ;["eastwood"]
        ]
    "ltest"
      ["with-profile" "+test" "ltest"]
    "ubercompile"
      ["do"
        ["clean"]
        ["with-profile" "+ubercompile" "compile"]]
    "build"
      ^{:doc (str "Perform build tasks for CI/CD & releases\n\n"
                 "Additional aliases:")}
      ["with-profile" "+test" "do"
        ["check-deps"]
        ["lint"]
        ["ltest"]
        ["compile"]
        ["uberjar"]]})
