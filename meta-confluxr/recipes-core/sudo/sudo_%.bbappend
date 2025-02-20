FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://sudoers-custom"

do_install:append() {
    install -d ${D}/etc/sudoers.d
    install -m 0440 ${WORKDIR}/sudoers-custom ${D}/etc/sudoers.d/
}
