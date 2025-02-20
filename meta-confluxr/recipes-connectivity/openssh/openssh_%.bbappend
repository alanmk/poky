FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://sshd_config"

do_install:append() {
    install -m 0600 ${WORKDIR}/sshd_config ${D}/etc/ssh/sshd_config
}
