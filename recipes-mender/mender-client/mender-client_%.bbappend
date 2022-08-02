# NOTE! A lot of the documentation is not correct in regards to self hosted!
# It is still targeting the older release of Dunfell

# Depend on mender-server-certificate
DEPENDS:append = " mender-server-certificate"
RDEPENDS_${PN}:append = " mender-server-certificate"


MENDER_SERVER_URL = "https://<server URL>.com"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
# Use this for adding any custom Mender configuration fragments
#SRC_URI:append = " file://mender.conf"
# Use this for signing artifacts
#SRC_URI:append = " file://artifact-verify-key.pem"
