FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://user-password"

do_install:append() {
    install -m 0644 ${WORKDIR}/user-password ${D}/etc/shadow
}
