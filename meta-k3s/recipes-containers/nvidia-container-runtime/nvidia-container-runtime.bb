SUMMARY = "NVIDIA Container Runtime for CUDA support"
DESCRIPTION = "Configures NVIDIA container runtime and device access"
LICENSE = "MIT"

inherit systemd

do_install() {
    install -d ${D}/etc/docker

    # Configure Docker to use NVIDIA runtime
    cat <<EOF > ${D}/etc/docker/daemon.json
{
    "runtimes": {
        "nvidia": {
            "path": "/usr/bin/nvidia-container-runtime",
            "runtimeArgs": []
        }
    }
}
EOF

    # Configure k3s containerd to recognize NVIDIA GPUs
    install -d ${D}/etc/rancher/k3s
    cat <<EOF > ${D}/etc/rancher/k3s/registries.yaml
mirrors:
  docker.io:
    endpoint:
      - "https://registry-1.docker.io"
configs:
  "nvidia":
    sandbox_image: "nvcr.io/nvidia/k8s/containerd"
EOF

    # Enable NVIDIA GPU devices in containerd
    install -d ${D}/etc/containerd
    cat <<EOF > ${D}/etc/containerd/config.toml
[plugins."io.containerd.grpc.v1.cri".containerd]
  default_runtime_name = "nvidia"
  [plugins."io.containerd.grpc.v1.cri".containerd.runtimes.nvidia]
    runtime_type = "io.containerd.runc.v2"
    privileged_without_host_devices = false
    [plugins."io.containerd.grpc.v1.cri".containerd.runtimes.nvidia.options]
      BinaryName = "/usr/bin/nvidia-container-runtime"
EOF

    # Load NVIDIA kernel modules at boot
    install -d ${D}/etc/modules-load.d
    cat <<EOF > ${D}/etc/modules-load.d/nvidia.conf
nvidia
nvidia_uvm
EOF
}

FILES:${PN} += "/etc/docker/daemon.json"
FILES:${PN} += "/etc/rancher/k3s/registries.yaml"
FILES:${PN} += "/etc/containerd/config.toml"
FILES:${PN} += "/etc/modules-load.d/nvidia.conf"
