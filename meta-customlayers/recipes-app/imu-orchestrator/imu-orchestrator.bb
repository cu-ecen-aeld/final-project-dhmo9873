SUMMARY = "IMU orchestrator — IIO poller + tilt alert"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://imu_orchestrator.c"

S = "${WORKDIR}"

DEPENDS = ""

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} \
        -o imu_orchestrator imu_orchestrator.c \
        -lpthread -lm
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 imu_orchestrator ${D}${bindir}/
}
