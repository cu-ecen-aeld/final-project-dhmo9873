# Tell the base image to use OpenSSH instead of Dropbear
IMAGE_FEATURES += "ssh-server-openssh"

# Inject all our custom project tools into the Sato GUI image
IMAGE_INSTALL += " \
    i2c-tools \
    v4l-utils \
    libdrm-tests \
    wpa-supplicant \
    linux-firmware \
    kernel-module-brcmfmac \
    linux-firmware-rpidistro-bcm43455 \
    connman \
"
IMAGE_INSTALL:append = " imu-orchestrator drm-hud v4l2-imu-ctrl reactive-imu"
