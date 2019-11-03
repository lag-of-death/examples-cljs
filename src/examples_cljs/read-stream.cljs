(ns examples-cljs.read-stream)

(defonce opts
  {:start (fn [controller]
            (do
              (js/console.log "starting")
              (js/setInterval #(.enqueue controller "abc") 1000)))})

(-> (clj->js opts)
    (js/ReadableStream.)
    (.getReader)
    (.read)
    (#(do (js/console.log "xyz" %1) %1))
    (.then #(js/console.log %1))
    (.finally #(js/console.log %1))
    (js/console.log))

(defonce decoder (js/TextDecoder. "utf-8"))

(-> (js/fetch "/")
    (.then #(.-body %1))
    (.then #(.getReader %1))
    (.then #(do (js/console.log %1) %1))
    (.then #(.read %1))
    (.then #(.decode decoder (.-value %1)))
    (.then js/console.log))