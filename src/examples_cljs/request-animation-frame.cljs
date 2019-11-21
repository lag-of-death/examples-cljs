(ns examples-cljs.request-animation-frame)

(def start 0)
(def element (js/document.getElementById "el"))

(defn step []
  (set! start (+ start 1))
  (set! (.-transform (.-style element)) (str "translateX(" start "px)"))
  (when (< start 200) (js/requestAnimationFrame step)))

(step)
