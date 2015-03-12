(ns blocking-js.core
  (:import [org.antlr.v4.runtime ANTLRFileStream CommonTokenStream]))


; ANTLRInputStream input = new ANTLRFileStream(args[0]);
; RLexer lexer = new RLexer(input);
; CommonTokenStream tokens = new CommonTokenStream(lexer);
; RParser parser = new RParser(tokens);
; parser.setBuildParseTree(true);
; RuleContext tree = parser.prog();
; tree.inspect(parser); // show in gui
; //tree.save(parser, "/tmp/R.ps"); // Generate postscript
; System.out.println(tree.toStringTree(parser));

(defn restart []
  (let [parser (-> (ANTLRFileStream. "resources/hiWaitBye.js")
                   ECMAScriptLexer. 
                   CommonTokenStream.
                   ECMAScriptParser.)]
    (.setBuildParseTree parser true)
    (let [tree (.program parser)]
      (.inspect tree parser)
      (.println System/out (.toStringTree tree parser)))))

(restart)

