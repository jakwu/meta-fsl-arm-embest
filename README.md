meta-fsl-arm-embest
===================

Yocto meta package for embest boards.

Change variable MACHINE to 'marsboard' in local.conf.
And add '${BSPDIR}/sources/meta-fsl-arm-embest' to BBLAYERS in bblayers.conf.


-----------------------------------------------------------------------
Example local.conf:

BB_NUMBER_THREADS ?= "${@oe.utils.cpu_count()}"
PARALLEL_MAKE ?= "-j ${@oe.utils.cpu_count()}"
MACHINE ??= 'marsboard'
DISTRO ?= 'poky'
PACKAGE_CLASSES ?= "package_rpm"
EXTRA_IMAGE_FEATURES = "debug-tweaks"
USER_CLASSES ?= "buildstats image-mklibs image-prelink"
PATCHRESOLVE = "noop"
BB_DISKMON_DIRS = "\
    STOPTASKS,${TMPDIR},1G,100K \
    STOPTASKS,${DL_DIR},1G,100K \
    STOPTASKS,${SSTATE_DIR},1G,100K \
    ABORT,${TMPDIR},100M,1K \
    ABORT,${DL_DIR},100M,1K \
    ABORT,${SSTATE_DIR},100M,1K" 
PACKAGECONFIG_pn-qemu-native = "sdl"
PACKAGECONFIG_pn-nativesdk-qemu = "sdl"
ASSUME_PROVIDED += "libsdl-native"
CONF_VERSION = "1"

BB_NUMBER_THREADS = '4'
PARALLEL_MAKE = '-j 4'

DL_DIR ?= "${BSPDIR}/downloads/"
ACCEPT_FSL_EULA = ""


-----------------------------------------------------------------------
Example bblayers.conf:

LCONF_VERSION = "6"

BBPATH = "${TOPDIR}"
BSPDIR := "${@os.path.abspath(os.path.dirname(d.getVar('FILE', True)) + '/../..')}"

BBFILES ?= ""
BBLAYERS = " \
  ${BSPDIR}/sources/poky/meta \
  ${BSPDIR}/sources/poky/meta-yocto \
  \
  ${BSPDIR}/sources/meta-openembedded/meta-oe \
  \
  ${BSPDIR}/sources/meta-fsl-arm \
  ${BSPDIR}/sources/meta-fsl-arm-extra \
  ${BSPDIR}/sources/meta-fsl-demos \
  \
  ${BSPDIR}/sources/meta-browser \
  \
  ${BSPDIR}/sources/meta-fsl-arm-embest \
"
