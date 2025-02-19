FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = " file://sudoers"

do_install:append() {
    install -m 0440 ${WORKDIR}/sudoers ${D}${sysconfdir}/sudoers
}
