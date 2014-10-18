# Copyright (C) 2013, 2014 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by Freescale"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Set SCMVERSION to 'n' if download tar.bz2
SCMVERSION = "n"

LOCALVERSION = "-1.0.0_ga-yocto"

COMPATIBLE_MACHINE = "(mx6)"

SRC_URI = "git://git.freescale.com/imx/linux-2.6-imx.git;branch=${SRCBRANCH} \
           file://defconfig \
           file://001-ENGR00306992-2-gpu2d-may-cause-bus-hang.patch \
           file://002-ENGR00300876-Fix-flick-issue-in-GAL2D-compositor.patch \
"
SRCBRANCH = "imx_3.10.17_1.0.0_ga"
SRCREV = "2a69800d94f182e975e4ed3ae2e64d30d35a3603"

PACKAGES =+ "kernel-dbg"
FILES_kernel-dbg = "${KERNEL_SRC_PATH}/drivers/input/touchscreen/generic_ts_rel/lib/.debug/"

copy_bin_files () {
	mkdir -p ${S}/drivers/input/touchscreen/generic_ts_rel/lib
	cp ${WORKDIR}/chip.x ${S}/drivers/input/touchscreen/generic_ts_rel/lib/
	cp ${WORKDIR}/ct360.x ${S}/drivers/input/touchscreen/generic_ts_rel/lib/
	cp ${WORKDIR}/ct365.x ${S}/drivers/input/touchscreen/generic_ts_rel/lib/
	cp ${WORKDIR}/enhance.x ${S}/drivers/input/touchscreen/generic_ts_rel/lib/
}

do_patch[postfuncs] += "copy_bin_files"
do_patch[vardeps] += "copy_bin_files"

