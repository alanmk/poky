do_install() {
    install -d ${D}/usr/local/bin
    install -m 0755 ${WORKDIR}/k3s ${D}/usr/local/bin/k3s

    # Create systemd service directory
    install -d ${D}${systemd_system_unitdir}

    # Create k3s service file
    cat << EOF > ${D}${systemd_system_unitdir}/k3s.service
[Unit]
Description=Lightweight Kubernetes
After=network-online.target
Wants=network-online.target

[Service]
ExecStart=/usr/local/bin/k3s server
Restart=always
User=root
Group=root
KillMode=process
Delegate=yes
LimitNOFILE=1048576
LimitNPROC=infinity
LimitCORE=infinity
TasksMax=infinity
Environment="K3S_KUBELET_ARGS=--feature-gates=DevicePlugins=true"

[Install]
WantedBy=multi-user.target
EOF
}

FILES:${PN} += "/usr/local/bin/k3s"
FILES:${PN} += "${systemd_system_unitdir}/k3s.service"

RDEPENDS:${PN} = "containerd runc docker-ce nvidia-container-runtime"

SYSTEMD_SERVICE:${PN} = "k3s.service"
