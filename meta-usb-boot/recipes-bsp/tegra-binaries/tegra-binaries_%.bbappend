FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://extlinux.conf"

do_install:append() {
    install -m 0644 ${WORKDIR}/extlinux.conf ${D}/boot/extlinux/extlinux.conf
}
