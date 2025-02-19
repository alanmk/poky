SUMMARY = "Helm - The Kubernetes Package Manager"
DESCRIPTION = "Installs Helm for Kubernetes"
HOMEPAGE = "https://helm.sh"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI = "https://get.helm.sh/helm-v3.11.3-linux-arm64.tar.gz"

S = "${WORKDIR}/helm-v3.11.3"

do_install() {
    install -d ${D}/usr/local/bin
    install -m 0755 ${S}/linux-arm64/helm ${D}/usr/local/bin/helm
}

FILES:${PN} += "/usr/local/bin/helm"
