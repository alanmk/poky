FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://uEnv.txt"

do_install:append() {
    install -m 0644 ${WORKDIR}/uEnv.txt ${D}/boot/uEnv.txt
}
