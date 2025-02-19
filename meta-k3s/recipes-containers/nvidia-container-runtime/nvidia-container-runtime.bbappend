do_install:append() {
    install -d ${D}/etc/docker
    install -d ${D}/etc/containerd
    install -d ${D}/etc/rancher/k3s
    install -d ${D}/etc/modules-load.d

    echo 'nvidia' > ${D}/etc/modules-load.d/nvidia.conf
    echo 'nvidia_uvm' >> ${D}/etc/modules-load.d/nvidia.conf
}
