DESCRIPTION = "Lightweight Kubernetes K3s for Jetson Nano"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4e699e76467c75ff4c9a6d17cdab39e2"

SRC_URI = "https://github.com/k3s-io/k3s/releases/download/v1.27.4%2Bk3s1/k3s-arm64"
SRC_URI += "file://k3s.service"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr/local/bin
    install -m 0755 ${WORKDIR}/k3s-arm64 ${D}/usr/local/bin/k3s

    # Ensure systemd service is installed
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/k3s.service ${D}${systemd_system_unitdir}/k3s.service
}

FILES_${PN} += "/usr/local/bin/k3s"
FILES_${PN} += "${systemd_system_unitdir}/k3s.service"

# Enable the K3s service
SYSTEMD_SERVICE_${PN} = "k3s.service"
