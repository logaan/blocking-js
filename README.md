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

## License

Copyright © 2015 Logan Campbell

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
