SUMMARY = "DRM dumb buffer HUD for IMU telemetry"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://drm_hud.c"

S = "${WORKDIR}"

DEPENDS = "libdrm"

do_compile() {
    ${CC} ${CFLAGS} \
        -I${STAGING_INCDIR}/libdrm \
        -o drm_hud drm_hud.c \
        ${LDFLAGS} -ldrm -lm
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 drm_hud ${D}${bindir}/
}
