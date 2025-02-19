SUMMARY = "Custom SSH and user setup for Yocto"
DESCRIPTION = "Installs OpenSSH, configures a user with sudo access, and ensures SSH is enabled."
LICENSE = "MIT"

inherit useradd

DEPENDS = "openssh"

# Ensure OpenSSH is installed
IMAGE_INSTALL:append = " openssh openssh-sshd shadow sudo"

# Define user creation
USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-m -s /bin/bash -G users,sudo jetsonnano01"
GROUPADD_PARAM:${PN} = "--system users"

# Set default password (SHA-512 hashed)
EXTRA_USERS_PARAMS = "useradd -m -s /bin/bash -G users,sudo jetsonnano01; echo 'jetsonnano01:yocto' | chpasswd"

SRC_URI += " \
    file://sshd_config \
    file://ssh_setup.sh \
    file://authorized_keys \
    file://sudoers-user \
"

do_install () {
    # Install SSHD configuration
    install -d ${D}/etc/ssh
    install -m 0644 ${WORKDIR}/sshd_config ${D}/etc/ssh/sshd_config

    # Ensure user SSH directory exists
    install -d ${D}/home/jetsonnano01/.ssh
    install -m 0700 ${D}/home/jetsonnano01/.ssh
    install -m 0600 ${WORKDIR}/authorized_keys ${D}/home/jetsonnano01/.ssh/authorized_keys
    chown -R 1000:1000 ${D}/home/jetsonnano01/.ssh  # Ensure correct ownership

    # Install sudoers file for user
    install -d ${D}/etc/sudoers.d
    install -m 0440 ${WORKDIR}/sudoers-jetsonnano01 ${D}/etc/sudoers.d/jetsonnano01

    # Install SSH setup script
    install -m 0755 ${WORKDIR}/ssh_setup.sh ${D}/usr/bin/ssh_setup.sh
}

FILES_${PN} += " \
    /etc/ssh/sshd_config \
    /home/jetsonnano01/.ssh/authorized_keys \
    /usr/bin/ssh_setup.sh \
    /etc/sudoers.d/jetsonnano01 \
"

# Ensure SSH starts at boot
SYSTEMD_AUTO_ENABLE:append = " sshd"
