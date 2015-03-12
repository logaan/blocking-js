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
 {:EOF {:object #<TerminalNodeImpl <EOF>>, :text "<EOF>"},
  :sourceElements
  {:object #<SourceElementsContext [110]>,
   :children
   ({:object #<SourceElementContext [115 110]>,
     :children
     {:functionDeclaration
      {:object #<FunctionDeclarationContext [121 115 110]>,
       :children
       {:Function
        {:object #<TerminalNodeImpl function>, :text "function"},
        :Identifier
        {:object #<TerminalNodeImpl hiWaitBye>, :text "hiWaitBye"},
        :formalParameterList
        {:object #<FormalParameterListContext [345 121 115 110]>,
         :children
         ({:object #<TerminalNodeImpl timeToWait>,
           :text "timeToWait"})},
        :functionBody
        {:object #<FunctionBodyContext [350 121 115 110]>,
         :children
         {:sourceElements
          {:object #<SourceElementsContext [361 350 121 115 110]>,
           :children
           ({:object #<SourceElementContext [115 361 350 121 115 110]>,
             :children
             {:statement
              {:object
               #<StatementContext [120 115 361 350 121 115 110]>,
               :children
               {:expressionStatement
                {:object
                 #<ExpressionStatementContext [127 120 115 361 350 121 115 110]>,
                 :children
                 {:SemiColon
                  {:object #<TerminalNodeImpl ;>, :text ";"},
                  :expressionSequence
                  {:object
                   #<ExpressionSequenceContext [174 127 120 115 361 350 121 115 110]>,
                   :children
                   ({:object
                     #<ArgumentsExpressionContext [454 174 127 120 115 361 350 121 115 110]>,
                     :children
                     {:arguments
                      {:object
                       #<ArgumentsContext [561 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       {:argumentList
                        {:object
                         #<ArgumentListContext [441 561 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object
                           #<LiteralExpressionContext [446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                           :children
                           {:literal
                            {:object
                             #<LiteralContext [501 446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                             :children
                             {:StringLiteral
                              {:object #<TerminalNodeImpl "Hi.">,
                               :text "\"Hi.\""}}}}})}}},
                      :singleExpression
                      {:object
                       #<MemberDotExpressionContext [86 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       {:identifierName
                        {:object
                         #<IdentifierNameContext [559 86 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         {:Identifier
                          {:object #<TerminalNodeImpl log>,
                           :text "log"}}},
                        :singleExpression
                        {:object
                         #<IdentifierExpressionContext [86 86 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         {:Identifier
                          {:object #<TerminalNodeImpl console>,
                           :text "console"}}}}}}})}}}}}}}
            {:object #<SourceElementContext [115 361 350 121 115 110]>,
             :children
             {:statement
              {:object
               #<StatementContext [120 115 361 350 121 115 110]>,
               :children
               {:expressionStatement
                {:object
                 #<ExpressionStatementContext [127 120 115 361 350 121 115 110]>,
                 :children
                 {:SemiColon
                  {:object #<TerminalNodeImpl ;>, :text ";"},
                  :expressionSequence
                  {:object
                   #<ExpressionSequenceContext [174 127 120 115 361 350 121 115 110]>,
                   :children
                   ({:object
                     #<ArgumentsExpressionContext [454 174 127 120 115 361 350 121 115 110]>,
                     :children
                     {:arguments
                      {:object
                       #<ArgumentsContext [561 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       {:argumentList
                        {:object
                         #<ArgumentListContext [441 561 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object
                           #<IdentifierExpressionContext [446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                           :children
                           {:Identifier
                            {:object #<TerminalNodeImpl timeToWait>,
                             :text "timeToWait"}}})}}},
                      :singleExpression
                      {:object
                       #<IdentifierExpressionContext [86 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       {:Identifier
                        {:object #<TerminalNodeImpl sleep>,
                         :text "sleep"}}}}})}}}}}}}
            {:object #<SourceElementContext [115 361 350 121 115 110]>,
             :children
             {:statement
              {:object
               #<StatementContext [120 115 361 350 121 115 110]>,
               :children
               {:expressionStatement
                {:object
                 #<ExpressionStatementContext [127 120 115 361 350 121 115 110]>,
                 :children
                 {:SemiColon
                  {:object #<TerminalNodeImpl ;>, :text ";"},
                  :expressionSequence
                  {:object
                   #<ExpressionSequenceContext [174 127 120 115 361 350 121 115 110]>,
                   :children
                   ({:object
                     #<ArgumentsExpressionContext [454 174 127 120 115 361 350 121 115 110]>,
                     :children
                     {:arguments
                      {:object
                       #<ArgumentsContext [561 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       {:argumentList
                        {:object
                         #<ArgumentListContext [441 561 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         ({:object
                           #<LiteralExpressionContext [446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                           :children
                           {:literal
                            {:object
                             #<LiteralContext [501 446 441 561 454 174 127 120 115 361 350 121 115 110]>,
                             :children
                             {:StringLiteral
                              {:object #<TerminalNodeImpl "Bye.">,
                               :text "\"Bye.\""}}}}})}}},
                      :singleExpression
                      {:object
                       #<MemberDotExpressionContext [86 454 174 127 120 115 361 350 121 115 110]>,
                       :children
                       {:identifierName
                        {:object
                         #<IdentifierNameContext [559 86 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         {:Identifier
                          {:object #<TerminalNodeImpl log>,
                           :text "log"}}},
                        :singleExpression
                        {:object
                         #<IdentifierExpressionContext [86 86 454 174 127 120 115 361 350 121 115 110]>,
                         :children
                         {:Identifier
                          {:object #<TerminalNodeImpl console>,
                           :text "console"}}}}}}})}}}}}}})}}}}}}})}}}
```

The pretty printer may have messed with the order of children, but they should
be stored in sorted-maps in the correct order.

## License

Copyright © 2015 Logan Campbell

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
