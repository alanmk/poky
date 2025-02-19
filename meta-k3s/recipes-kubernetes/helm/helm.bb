SUMMARY = "Helm - The Kubernetes Package Manager"
DESCRIPTION = "Installs Helm for Kubernetes"
HOMEPAGE = "https://helm.sh"
LICENSE = "Apache-2.0"

SRC_URI = "https://get.helm.sh/helm-v3.11.3-linux-arm64.tar.gz \
           https://raw.githubusercontent.com/helm/helm/main/LICENSE"

SRC_URI[sha256sum] = "9f58e707dcbe9a3b7885c4e24ef57edfb9794490d72705b33a93fa1f3572cce4"

LIC_FILES_CHKSUM = "file://LICENSE;sha256=881467e52efeb1807406134b0ec04b1c6f52dc9dc49382713ef9ac4e0cae42f8"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr/local/bin
    install -m 0755 ${S}/linux-arm64/helm ${D}/usr/local/bin/helm
}

FILES:${PN} += "/usr/local/bin/helm"
