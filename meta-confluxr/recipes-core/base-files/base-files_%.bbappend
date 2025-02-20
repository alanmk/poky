FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://securetty"

do_install:append() {
    install -m 0444 ${WORKDIR}/securetty ${D}/etc/securetty
}