(defproject blocking-js "0.1.0-SNAPSHOT"
  :description "A javascript transpiler that aims to allow programs to be
               written synchronously."
  :url "https://github.com/logaan/blocking-js"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.antlr/antlr4-runtime "4.5"]]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"])
