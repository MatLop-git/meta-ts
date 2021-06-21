DEPENDS += "kern-tools-native xz-native bc-native lzop-native"

inherit kernel
DEFAULT_PREFERENCE = "1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SCMVERSION ?= "y"
PV = "${LINUX_VERSION}+git${SRCPV}"
S = "${WORKDIR}/git"

SRCBRANCH = "tslinux-5.10.y"
KERNEL_SRC ?= "git://git@polychrome.ts-local.net/ts/linux-terumo.git;protocol=ssh"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
           file://defconfig"
LOCAL_VERSION = "-1.0"
SRCREV = "df2f3229525602ef4eea8eaf410b4302541f60f4"
LINUX_VERSION = "5.10.41"

do_preconfigure_prepend() {
   mkdir -p ${S}/firmware/imx/sdma/
   cp ${D}/lib/firmware/imx/sdma/sdma-imx6q.bin ${S}/firmware/imx/sdma/
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
