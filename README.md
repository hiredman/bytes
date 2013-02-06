# bytes

A Clojure library that gives you a data_readers.clj that provides for
printing and reading of byte arrays as base64 encoded data

## Usage

```clojure
user> (require 'com.thelastcitadel.bytes)
nil
user> (.getBytes (str (java.util.UUID/randomUUID)))
#bytes/base64 "MDgyZDZjNWYtMDYxYi00YTI4LWI0ZWItZmY0MmQ3NDgyODVl"
user> (type #bytes/base64 "MDgyZDZjNWYtMDYxYi00YTI4LWI0ZWItZmY0MmQ3NDgyODVl")
[B
user> (String. #bytes/base64 "MDgyZDZjNWYtMDYxYi00YTI4LWI0ZWItZmY0MmQ3NDgyODVl")
"082d6c5f-061b-4a28-b4eb-ff42d748285e"
user> 
```

## License

Copyright © 2013 Kevin Downey

Distributed under the Eclipse Public License, the same as Clojure.
