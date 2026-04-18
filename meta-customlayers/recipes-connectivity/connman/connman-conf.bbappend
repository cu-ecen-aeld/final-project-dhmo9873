FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Add config files to the source URI list
SRC_URI += " \
    file://wired.config \
    file://wifi.config \
"

do_install:append() {
    # Create the target directory
    install -d ${D}${localstatedir}/lib/connman
    
    # Install the static Ethernet config
    install -m 0644 ${WORKDIR}/wired.config ${D}${localstatedir}/lib/connman/wired.config
    
    # Install the Wi-Fi config (using 0600 permissions since it contains a password)
    install -m 0600 ${WORKDIR}/wifi.config ${D}${localstatedir}/lib/connman/wifi.config
}

# Tell Yocto to package everything inside the connman directory
FILES:${PN} += "${localstatedir}/lib/connman/*"
