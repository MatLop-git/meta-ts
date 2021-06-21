DESCRIPTION = "u-boot for TS-Terumo"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "imx_v2015.04_3.14.52_1.1.0_ga"
SRCREV = "d80f4bdc3a0f72c5bc692eae3cfbfd78a881776a"
SRC_URI = "git@polychrome.ts-local.net/ts/terumo-uboot.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "tsimx6"
