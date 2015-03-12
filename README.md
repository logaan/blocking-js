# blocking-js

A javascript transpiler that aims to allow programs to be written
synchronously.

## Usage

Run `lein repl` and then:

```clojure
(require 'blocking-js.core)
(in-ns 'blocking-js.core)
(clojure.pprint/pprint (with-children (main)))
```

## Example

This javascript:

```javascript
function hiWaitBye(timeToWait) {
  console.log("Hi.");
  sleep(timeToWait);
  console.log("Bye.");
}
```

Will result in this parse tree:

```clojure
{:object #<ProgramContext []>,
 :children
 ({:object #<SourceElementsContext [110]>,
   :children
   ({:object #<SourceElementContext [115 110]>,
     :children
     ({:object #<FunctionDeclarationContext [121 115 110]>,
       :children
       ({:object #<TerminalNodeImpl function>, :text "function"}
        {:object #<TerminalNodeImpl hiWaitBye>, :text "hiWaitBye"}
        {:object #<TerminalNodeImpl (>, :text "("}
        {:object #<FormalParameterListContext [345 121 115 110]>,
         :children
         ({:object #<TerminalNodeImpl timeToWait>,
           :text "timeToWait"})}
        {:object #<TerminalNodeImpl )>, :text ")"}
        {:object #<TerminalNodeImpl {>, :text "{"}
        {:object #<FunctionBodyContext [350 121 115 110]>,
         :children
         ({:object #<SourceElementsContext [361 350 121 115 110]>,
           :children
           ({:object #<SourceElementContext [115 361 350 121 115 110]>,
             :children
             ({:object
               #<StatementContext [120 115 361 350 121 115 110]>,
               :children
               ({:object
                 #<ExpressionStatementContext [127 120 115 361 350 121 115 110]>,
                 :children
                 ({:object
                   #<ExpressionSequenceContext [174 127 120 115 361 350 121 115 110]>,
                   :children
                   ({:object
                     #<ArgumentsExpressionContext [454 174 127 120 115 361 350 121 115 110]>,
                     :children
                     ({:object
                       #<MemberDotExpressionContext [86 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       ({:object
                         #<IdentifierExpressionContext [86 86 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object #<TerminalNodeImpl console>,
                           :text "console"})}
                        {:object #<TerminalNodeImpl .>, :text "."}
                        {:object
                         #<IdentifierNameContext [559 86 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object #<TerminalNodeImpl log>,
                           :text "log"})})}
                      {:object
                       #<ArgumentsContext [561 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       ({:object #<TerminalNodeImpl (>, :text "("}
                        {:object
                         #<ArgumentListContext [441 561 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object
                           #<LiteralExpressionContext [446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                           :children
                           ({:object
                             #<LiteralContext [501 446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                             :children
                             ({:object #<TerminalNodeImpl "Hi.">,
                               :text "\"Hi.\""})})})}
                        {:object #<TerminalNodeImpl )>,
                         :text ")"})})})}
                  {:object #<TerminalNodeImpl ;>, :text ";"})})})}
            {:object #<SourceElementContext [115 361 350 121 115 110]>,
             :children
             ({:object
               #<StatementContext [120 115 361 350 121 115 110]>,
               :children
               ({:object
                 #<ExpressionStatementContext [127 120 115 361 350 121 115 110]>,
                 :children
                 ({:object
                   #<ExpressionSequenceContext [174 127 120 115 361 350 121 115 110]>,
                   :children
                   ({:object
                     #<ArgumentsExpressionContext [454 174 127 120 115 361 350 121 115 110]>,
                     :children
                     ({:object
                       #<IdentifierExpressionContext [86 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       ({:object #<TerminalNodeImpl sleep>,
                         :text "sleep"})}
                      {:object
                       #<ArgumentsContext [561 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       ({:object #<TerminalNodeImpl (>, :text "("}
                        {:object
                         #<ArgumentListContext [441 561 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object
                           #<IdentifierExpressionContext [446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                           :children
                           ({:object #<TerminalNodeImpl timeToWait>,
                             :text "timeToWait"})})}
                        {:object #<TerminalNodeImpl )>,
                         :text ")"})})})}
                  {:object #<TerminalNodeImpl ;>, :text ";"})})})}
            {:object #<SourceElementContext [115 361 350 121 115 110]>,
             :children
             ({:object
               #<StatementContext [120 115 361 350 121 115 110]>,
               :children
               ({:object
                 #<ExpressionStatementContext [127 120 115 361 350 121 115 110]>,
                 :children
                 ({:object
                   #<ExpressionSequenceContext [174 127 120 115 361 350 121 115 110]>,
                   :children
                   ({:object
                     #<ArgumentsExpressionContext [454 174 127 120 115 361 350 121 115 110]>,
                     :children
                     ({:object
                       #<MemberDotExpressionContext [86 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       ({:object
                         #<IdentifierExpressionContext [86 86 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object #<TerminalNodeImpl console>,
                           :text "console"})}
                        {:object #<TerminalNodeImpl .>, :text "."}
                        {:object
                         #<IdentifierNameContext [559 86 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object #<TerminalNodeImpl log>,
                           :text "log"})})}
                      {:object
                       #<ArgumentsContext [561 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       ({:object #<TerminalNodeImpl (>, :text "("}
                        {:object
                         #<ArgumentListContext [441 561 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object
                           #<LiteralExpressionContext [446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                           :children
                           ({:object
                             #<LiteralContext [501 446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                             :children
                             ({:object #<TerminalNodeImpl "Bye.">,
                               :text "\"Bye.\""})})})}
                        {:object #<TerminalNodeImpl )>,
                         :text ")"})})})}
                  {:object #<TerminalNodeImpl ;>, :text ";"})})})})})}
        {:object #<TerminalNodeImpl }>, :text "}"})})})}
  {:object #<TerminalNodeImpl <EOF>>, :text "<EOF>"})}
```

## License

Copyright © 2015 Logan Campbell

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
