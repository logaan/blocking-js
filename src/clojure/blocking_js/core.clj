(ns blocking-js.core
  (:require [clojure.reflect :as r]
            [clojure.set :as s])
  (:import [org.antlr.v4.runtime ANTLRFileStream CommonTokenStream ParserRuleContext]
           [clojure.lang Reflector]))

; Might be easier to implement in terms of .children
; Doesn't maintain order of child nodes

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

(defn do-mapify [context]
  (->> (find-branch-method-names context)
       (map #(vector (keyword %) (call-method context %)))
       (into {})))

(defn sorted-map-from-value-list [unsorted-map value-list]
  (let [inverted (s/map-invert unsorted-map)]
    (reduce (fn [acc value]
              (let [key (inverted value)]
                (if (nil? key) #spy/p value)
                (assoc acc key  value)))
            (sorted-map) value-list)))

(defn map-vals [t m]
  (into (empty m) (map (fn [[k v]] [k (t v)]) m)))

(defn with-children [context]
  (if (zero? (.getChildCount context))
    {:object context}
    {:object context 
     :children (map-vals
                 with-children
                 (sorted-map-from-value-list
                   (do-mapify context)
                   (.children context)))}))

(defn main []
  (let [parser (-> (ANTLRFileStream. "resources/hiWaitBye.js")
                   ECMAScriptLexer. 
                   CommonTokenStream.
                   ECMAScriptParser.)]
    (.setBuildParseTree parser true)
    (.program parser)))

(with-children (main))

