DESCRIPTION = "Adds a new user with sudo access"
LICENSE = "MIT"

SRC_URI += "file://add-user.sh"

do_install() {
    install -m 0755 ${WORKDIR}/add-user.sh ${D}/usr/bin/add-user.sh
}

ROOTFS_POSTPROCESS_COMMAND += " add_custom_user; "

add_custom_user() {
    sh ${D}/usr/bin/add-user.sh
}
