SUMMARY = "Creates a custom user with sudo access"
DESCRIPTION = "Adds 'jetsonnano01' with a hashed password and sudo group membership"
LICENSE = "CLOSED"

EXCLUDE_FROM_WORLD = "1"

inherit useradd

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-u 1200 -d /home/jetsonnano01 -r -s /bin/sh -p '\$6\$5qyAHTOM.Pk2kDrz\$qmICDt2cmJJdJa3FVS0ZGVcsD0w0KXJUTSC7SreeVUvuYws.aeaWo7NPEsqbX3kS7V5l0SCn/Sl16rbpJJVZk1' jetsonnano01"
GROUPADD_PARAM:${PN} = "sudo"
USERADD_PARAM:${PN} += "-G sudo jetsonnano01"

do_install () {
	install -d -m 755 ${D}${datadir}/jetsonnano01
	chown -R jetsonnano01 ${D}${datadir}/jetsonnano01
}

FILES:${PN} += "/home/jetsonnano01"

RDEPENDS:${PN} = "sudo"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"