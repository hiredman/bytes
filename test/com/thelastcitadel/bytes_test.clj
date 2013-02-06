(ns com.thelastcitadel.bytes-test
  (:require [clojure.test :refer :all]
            [com.thelastcitadel.bytes])
  (:import (java.util UUID)))

(deftest t
  (dotimes [i 100]
    (let [s (apply str (repeatedly (inc i) #(str (UUID/randomUUID))))]
      (let [x (pr-str (.getBytes s))]
        (is (.startsWith x "#bytes/base64"))
        (is (= s (String. (read-string x))))))))
