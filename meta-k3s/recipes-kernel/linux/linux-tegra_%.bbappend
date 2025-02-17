FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://k3s.cfg"

KERNEL_CONFIG_FRAGMENTS += "${WORKDIR}/k3s.cfg"
