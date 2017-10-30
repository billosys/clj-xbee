# clj-xbee

[![Build Status][travis-badge]][travis]
[![Clojars Project][clojars-badge]][clojars]
[![Tag][tag-badge]][tag]
[![Clojure version][clojure-v]](project.clj)

[![][logo]][logo-large]

*Clojure Wrapper for Digi's Official XBee Java Library*

## Setup

You will need to install the native rxtx serial library: this is easiest with
Linux. For example, with Ubuntu, all you need to do is:

```
$ sudo apt-get install librxtx-java
```

In order to access the serial port as non-root, you will need to add yourself
to the group that owns the device. In most cases, this is the `dialout` group:

```
$ sudo usermod -a -G dialout `whoami`
```

## Usage

Create an open a device.

Note that the passed device type will depend upon what type of radio you have.
If we haven't wrapped the Java API for your particular XBee radio, just submit
a new ticket and we'll get that done for you.

```clj
[xbee.dev] λ=> (def d (device-core/create-device :raw802 "/dev/ttyUSB0" 9600))
#'xbee.dev/d
[xbee.dev] λ=> (device-core/open d)
nil
```

If you get warnings about minor version mismatches, you can disregard.

Update the device info cache:

```clj
[xbee.dev] λ=> (device-core/read-device-info d)
nil
```

Get some basic device info:

```clj
[xbee.dev] λ=> (device-core/get-firmware-version d)
"10EF"
[xbee.dev] λ=> (device-core/get-hardware-version d)
24
[xbee.dev] λ=> (device-core/get-power-level d)
{:id 4, :name "Highest"}
[xbee.dev] λ=> (device-core/get-xbee-protocol d)
{:id 1, :name "802.15.4"}
[xbee.dev] λ=> (device-core/get-64bit-addr d)
"00000000-00000000-A20040FF-FFD692BD"
```


## License

Copyright © 2017, Billo Systems, Ltd. Co.

Distributed under the Apache License Version 2.0.


<!-- Named page links below: /-->

[travis]: https://travis-ci.org/billosys/clj-xbee
[travis-badge]: https://travis-ci.org/billosys/clj-xbee.png?branch=master
[deps]: http://jarkeeper.com/billosys/clj-xbee
[deps-badge]: http://jarkeeper.com/billosys/clj-xbee/status.svg
[logo]: resources/images/Xbee-small.png
[logo-large]: resources/images/Xbee.png
[tag-badge]: https://img.shields.io/github/tag/billosys/clj-xbee.svg
[tag]: https://github.com/billosys/clj-xbee/tags
[clojure-v]: https://img.shields.io/badge/clojure-1.8.0-blue.svg
[jdk-v]: https://img.shields.io/badge/jdk-1.7+-blue.svg
[clojars]: https://clojars.org/clj-xbee
[clojars-badge]: https://img.shields.io/clojars/v/clj-xbee.svg
