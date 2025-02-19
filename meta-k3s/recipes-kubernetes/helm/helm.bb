SUMMARY = "Helm - The Kubernetes Package Manager"
DESCRIPTION = "Installs Helm for Kubernetes"
HOMEPAGE = "https://helm.sh"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI = "https://get.helm.sh/helm-v3.11.3-linux-arm64.tar.gz"
SRC_URI[sha256sum] = "9f58e707dcbe9a3b7885c4e24ef57edfb9794490d72705b33a93fa1f3572cce4"

S = "${WORKDIR}/helm-v3.11.3"

do_install() {
    install -d ${D}/usr/local/bin
    install -m 0755 ${S}/linux-arm64/helm ${D}/usr/local/bin/helm
}

FILES:${PN} += "/usr/local/bin/helm"
