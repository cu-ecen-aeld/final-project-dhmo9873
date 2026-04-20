SUMMARY = "Reactive IMU — unified 3-thread integration binary"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://reactive_imu.c"

S = "${WORKDIR}"

DEPENDS = "libdrm"

do_compile() {
    ${CC} ${CFLAGS} \
        -I${STAGING_INCDIR}/libdrm \
        -o reactive_imu reactive_imu.c \
        ${LDFLAGS} -ldrm -lpthread -lm
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 reactive_imu ${D}${bindir}/
}
