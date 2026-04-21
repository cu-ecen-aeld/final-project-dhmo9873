FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://iio-sensors.cfg \
    file://ism330dhcx-overlay.dts \
    file://imx219-binning-ctrl.patch \
"

do_compile:prepend() {
    cp ${WORKDIR}/ism330dhcx-overlay.dts \
       ${S}/arch/arm64/boot/dts/overlays/
    if ! grep -q "ism330dhcx-overlay" ${S}/arch/arm64/boot/dts/overlays/Makefile; then
        echo "dtbo-y += ism330dhcx-overlay.dtbo" >> \
           ${S}/arch/arm64/boot/dts/overlays/Makefile
    fi
}

do_compile:append() {
    ${B}/scripts/dtc/dtc -@ -I dts -O dtb \
        -o ${B}/ism330dhcx-overlay.dtbo \
        ${WORKDIR}/ism330dhcx-overlay.dts
}

do_deploy:append() {
    install -m 0644 ${B}/ism330dhcx-overlay.dtbo \
        ${DEPLOYDIR}/ism330dhcx-overlay.dtbo
}
