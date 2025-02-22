#!/bin/bash
source oe-init-build-env

cp ../reference-configuration/local.conf conf/
cp ../reference-configuration/bblayers.conf conf/

bitbake core-image-full-cmdline