(ns oo7.core)

(def log
  "Log of execution traces"
  (atom []))

(defn clear
  "Clear log"
  []
  (reset! log []))

(defn log-trace
  "Log a trace"
  [trace]
  (swap! log conj trace)
  (:val trace))

(defn- local-bindings
  "Returns a map of the names of local bindings to their values."
  [env]
  (reduce (fn [m sym] (assoc m `'~sym sym))
          {} (keys env)))

(defmacro spy
  "Spy on code execution"
  [& body]
  `(let [t0# (System/nanoTime)
         val# [~@body]
         t1# (System/nanoTime)]
     (log-trace {:ns (ns-name *ns*)
                 :file *file*
                 :line ~(:line (meta &form))
                 :column ~(:column (meta &form))
                 :locals ~(local-bindings &env)
                 :body (apply array-map (mapcat vector ~(mapv (fn [a] `'~a) body) val#))
                 :timestamp (java.time.Instant/now)
                 :start t0#
                 :stop t1#
                 :val (last val#)})))
