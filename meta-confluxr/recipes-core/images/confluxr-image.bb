SUMMARY = "ConfluxR image"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image-minimal

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

# initrd flash to use usb as rootfs
TNSPEC_BOOTDEV:jetson-nano-devkit-emmc = "sda1"

# Select image type and format
IMAGE_FSTYPES = "tegraflash"

# Enable systemd for service management
VIRTUAL-RUNTIME_init_manager = "systemd"

# Increase storage space in rootfs
IMAGE_ROOTFS_EXTRA_SPACE = "5242880"

IMAGE_FEATURES:append "ssh-server-openssh"

IMAGE_INSTALL:append = " sudo"
IMAGE_INSTALL:append = " nvidia-container-runtime"
IMAGE_INSTALL:append = " cuda-toolkit"
IMAGE_INSTALL:append = " cudnn"
IMAGE_INSTALL:append = " tensorrt-core tensorrt-plugins"
IMAGE_INSTALL:append = " packagegroup-k3s-host"
IMAGE_INSTALL:append = " packagegroup-k3s-node"
IMAGE_INSTALL:append = " ca-certificates"
IMAGE_INSTALL:append = " kernel-modules"