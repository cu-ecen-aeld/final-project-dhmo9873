SUMMARY = "Zero-Copy DMA-BUF consumer — Feature 10"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://dma_consumer.c"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} \
        -o dma_consumer dma_consumer.c
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 dma_consumer ${D}${bindir}/
}
