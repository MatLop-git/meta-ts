DEPENDS += "kern-tools-native xz-native bc-native lzop-native linux-firmware"

inherit kernel
DEFAULT_PREFERENCE = "1"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SCMVERSION ?= "y"
PV = "${LINUX_VERSION}+git${SRCPV}"
S = "${WORKDIR}/git"

SRCBRANCH = "linux-5.15.y"
KERNEL_SRC ?= "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
           file://defconfig \
           file://0005-gpio-gpio-ts4900-Added-device-tree-base-property.patch"
LOCAL_VERSION = "-1.0"
SRCREV = "v5.15.43"
# May need to use 0e5bb338bf471ec46924f744c4301751bab8793a for srcrev?
LINUX_VERSION = "5.15.43"


do_configure:prepend() {
   install -d ${S}/firmware/imx/sdma/ || die "could not make directory"
   install -m 644 ${STAGING_BASELIBDIR}/firmware/imx/sdma/sdma-imx6q.bin ${S}/firmware/imx/sdma/ || die "could not copy sdma firmware"
}

SUMMARY = "Linux kernel for TS-Terumo board"
DESCRIPTION = "Linux Kernel modified for TS-Terumo board support."

COMPATIBLE_MACHINE = "(tsimx6)"


# From meta-freescale recipes-kernel linux-imx.inc
#
# Tell to kernel class that we would like to use our defconfig to configure the kernel.
# Otherwise, the --allnoconfig would be used per default which leads to mis-configured
# kernel.
#
# This behavior happens when a defconfig is provided, the kernel-yocto configuration
# uses the filename as a trigger to use a 'allnoconfig' baseline before merging
# the defconfig into the build.
#
# If the defconfig file was created with make_savedefconfig, not all options are
# specified, and should be restored with their defaults, not set to 'n'.
# To properly expand a defconfig like this, we need to specify: KCONFIG_MODE="--alldefconfig"
# in the kernel recipe include.
KCONFIG_MODE="--alldefconfig"

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
