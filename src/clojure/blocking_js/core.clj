(ns blocking-js.core
  (:require [clojure.reflect :as r])
  (:import [org.antlr.v4.runtime ANTLRFileStream CommonTokenStream]
           [clojure.lang Reflector]))

(defn find-branch-method-names [context]
  (->> context
       r/reflect
       :members
       (filter (fn [m] (empty? (:parameter-types m))))
       (map :name)
       (map str)
       (filter (fn [m] (not (= "getRuleIndex" m))))))

(defn call-method [object method-name]
  (Reflector/invokeInstanceMethod object method-name (to-array [])))

(defn restart []
  (let [parser (-> (ANTLRFileStream. "resources/hiWaitBye.js")
                   ECMAScriptLexer. 
                   CommonTokenStream.
                   ECMAScriptParser.)]
    (.setBuildParseTree parser true)
    (.program parser)))

(defn do-mapify [context]
  (let [info {:text (.getText context)
              :type (type context)}]
    (if (zero? (.getChildCount context))
      info
      (->> (find-branch-method-names context)
           (map #(vector (keyword %) (mapify (call-method context %))))
           (into {})
           (merge info)))))

(defn mapify [context]
  (if context
    (if (= java.util.ArrayList (class context))
      (map do-mapify context)
      (do-mapify context))))

#spy/p (mapify (restart))

