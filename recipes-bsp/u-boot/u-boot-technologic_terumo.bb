DESCRIPTION = "u-boot for TS-Terumo"

# Don't build an env
UBOOT_INITIAL_ENV = ""
# Use the correct suffix
UBOOT_SUFFIX = "imx"

require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot virtual/bootloader"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "imx_v2015.04_3.14.52_1.1.0_ga"
SRCREV = "9cd7bfad60cdb61105edf6ff8458229e79cad2d3"
SRC_URI = "git://git@polychrome.ts-local.net/ts/terumo-uboot.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "tsimx6"
