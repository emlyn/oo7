# oo7

A Clojure library designed to help with debugging.

## Usage

Add a `oo7` dependency to your project, and refer the `oo7.core/spy` macro in your code:
```clojure
(ns my.ns
  (:require [oo7.core :refer [spy]]
            ...
```

Insert calls to `spy` in your code.
Each call will log the position in the code (namespace, file, line, column),
as well as the time, and the names and values of all locals (`let` bindings).

If you pass one or more arguments to `spy` they will also be logged,
as well as the amount of time they take to be evaluated.
The return value will be the value of the last argument (as in a `do`),
so you can wrap existing code in a call to `spy` without changing the structure of your code.

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
