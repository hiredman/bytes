(ns com.thelastcitadel.bytes
  (:require [clojure.data.codec.base64 :as b64]))

(defn decode [s]
  (b64/decode (.getBytes s "utf8")))

(defn print-bytes [bytes ^java.io.Writer w]
  (let [bytes (b64/encode bytes)]
    (.write w "#bytes/base64 \"")
    ;; pretty sure this is kosher, none of the base64 alphabet are
    ;; negative (I know, what negative bytes?! jvm you so crazy) bytes
    (dotimes [i (count bytes)]
      (.write w (int (aget bytes i))))
    (.write w "\"")))

(defmethod print-method (Class/forName "[B")
  [bytes w]
  (print-bytes bytes w))

(defmethod print-dup (Class/forName "[B")
  [bytes w]
  (print-bytes bytes w))
