FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://sshd_config"
SRC_URI += "file://authorized_keys"

do_install:append() {
    # Install sshd_config to override the default OpenSSH config
    install -m 0644 ${WORKDIR}/sshd_config ${D}${sysconfdir}/ssh/sshd_config

    # Ensure the SSH directory exists for the user
    install -d -m 0700 ${D}/home/jetsonnano01/.ssh

    # Install the authorized_keys file for SSH key authentication
    install -m 0600 ${WORKDIR}/authorized_keys ${D}/home/jetsonnano01/.ssh/authorized_keys

    # Set the correct ownership for the SSH directory and authorized_keys file
    chown -R 1000:1000 ${D}/home/jetsonnano01/.ssh
}
