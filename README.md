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

Once your XBee radio is plugged in, you can find the device file by doing the
following:

```
$ dmesg
```

and looking for the recent line that mentions "FTDI USB Serial Device
converter"; the message will also give the relative device path, e.g.,
`ttyUSB0`. You can confirm that this is the correct device by this:

```
$ udevadm info -q all /dev/ttyUSB0
```

Note that the device info you'll be seeing is for the USB Serial-to-USB
converter, i.e., the "XBee Explorer".


## Usage

Create and open a device.

Note that the passed device type will depend upon what type of radio you have.
If we haven't wrapped the Java API for your particular XBee radio, just submit
a new ticket and we'll get that done for you.

To get started, your project will need to include the dependency. For `lein`:

```clj
[systems.billo/clj-xbee "0.1.0-SNAPSHOT"]
```

Then, in your `ns` setup, `require` the following:

```clj
[xbee.device.core :as xbee]
```

Example usage from the clj-xbee development REPL:

```clj
[xbee.dev] λ=> (def d (xbee/create-device :raw802 "/dev/ttyUSB0" 9600))
#'xbee.dev/d
[xbee.dev] λ=> (xbee/open d)
nil
```

If you get warnings about minor version mismatches, you can disregard.

Update the device info cache:

```clj
[xbee.dev] λ=> (xbee/read-device-info d)
nil
```

Get some basic device info:

```clj
[xbee.dev] λ=> (xbee/get-firmware-version d)
"10EF"
[xbee.dev] λ=> (xbee/get-hardware-version d)
24
[xbee.dev] λ=> (xbee/get-power-level d)
{:id 4, :name "Highest"}
[xbee.dev] λ=> (xbee/get-xbee-protocol d)
{:id 1, :name "802.15.4"}
[xbee.dev] λ=> (xbee/get-64bit-addr d)
"00000000-00000000-A20040FF-FFD692BD"
```


## License

Copyright © 2017, Billo Systems, Ltd. Co.

Copyright © 2017, Duncan McGreggor

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
