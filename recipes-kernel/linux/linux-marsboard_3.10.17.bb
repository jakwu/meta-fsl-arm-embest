# Copyright (C) 2013, 2014 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by Freescale"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Set SCMVERSION to 'n' if download tar.bz2
#SCMVERSION = "n"

LOCALVERSION = "-1.0.0_ga-yocto"

COMPATIBLE_MACHINE = "(mx6)"

SRC_URI = "git://github.com/jakwu/linux-imx.git;branch=${SRCBRANCH} \
           file://defconfig \
           file://001-ENGR00306992-2-gpu2d-may-cause-bus-hang.patch \
           file://002-ENGR00300876-Fix-flick-issue-in-GAL2D-compositor.patch \
"
SRCBRANCH = "embest_imx_3.10.17_1.0.0_ga"
SRCREV = "6df98572d99b68ce57f69d68b597036a81646e06"

PACKAGES =+ "kernel-dbg"
FILES_kernel-dbg = "${KERNEL_SRC_PATH}/drivers/input/touchscreen/generic_ts_rel/lib/.debug/"
