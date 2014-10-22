
require recipes-bsp/u-boot/u-boot-fslc.inc

SRC_URI = "git://github.com/jakwu/u-boot-fslc.git;branch=${SRCBRANCH}"
SRCBRANCH = "patches-2014.07"

SRCREV = "7c3fff814381f59718d8832fa5ab46892ed3990a"
