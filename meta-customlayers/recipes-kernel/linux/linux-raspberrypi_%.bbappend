FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://iio-sensors.cfg \
    file://ism330dhcx-overlay.dts \
"

do_compile:append() {
    ${B}/scripts/dtc/dtc -@ -I dts -O dtb \
        -o ${B}/ism330dhcx-overlay.dtbo \
        ${WORKDIR}/ism330dhcx-overlay.dts
}

do_deploy:append() {
    install -m 0644 ${B}/ism330dhcx-overlay.dtbo \
        ${DEPLOYDIR}/ism330dhcx-overlay.dtbo
}
