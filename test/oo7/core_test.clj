(ns oo7.core-test
  (:require [clojure.test :refer :all]
            [oo7.core :refer :all]))

(deftest spy-test
  (let [dummy 123]
    (spy (+ 1 2))
    (is (= 1 (count @log)))
    (let [trace (first @log)]
      ;;(is (= 'oo7.core-test (:ns trace))) ;; returns a ns of user
      ;;(is (= "core_test.clj" (:file trace))) ;; "/private/var/folders/ZZZ/form-initNNN.clj"
      (is (= {'(+ 1 2) 3} (:body trace)))
      (is (= {'dummy 123} (:locals trace)))
      (is (= 3 (:val trace)))
      (is (> (:stop trace) (:start trace))))))
