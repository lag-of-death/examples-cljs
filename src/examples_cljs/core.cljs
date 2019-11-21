(ns examples-cljs.core
  (:require [examples-cljs.read-stream]
            [examples-cljs.request-animation-frame]))

(enable-console-print!)

(println "This text is printed from src/examples-cljs/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(defn on-js-reload [])
