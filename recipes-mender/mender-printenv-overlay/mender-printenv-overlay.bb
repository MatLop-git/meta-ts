SUMMARY = "fw_env.config overlay for Mender"
AUTHOR = "Kris Bahnsen <kris@embeddedTS.com>"
HOMEPAGE = "http://www.embeddedTS.com/"
SECTION = "base"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = " file://fw_env.config"
FILES:${PN} += "${sysconfdir}/fw_env.config"

do_install() {
	install -d ${D}/etc
	install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}
