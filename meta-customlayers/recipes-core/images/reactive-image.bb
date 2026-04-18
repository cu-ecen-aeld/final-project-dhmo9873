SUMMARY = "A custom image for the camera and DRM pipeline"
inherit core-image

# Add your image features
EXTRA_IMAGE_FEATURES += "debug-tweaks ssh-server-openssh"

# Explicitly define what goes into this specific image
IMAGE_INSTALL += " \
    openssh \
    i2c-tools \
    v4l-utils \
    libdrm-tests \
    wpa-supplicant \
    linux-firmware \
    kernel-module-brcmfmac \
	linux-firmware-rpidistro-bcm43455 \
	connman \
"
