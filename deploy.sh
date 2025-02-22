#!/bin/bash

# ./deploy.sh core-image-full-cmdline jetson-nano-devkit-emmc

image=$1
machine=$2

scriptdir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
deployfile=${image}-${machine}.tegraflash.tar.gz
tmpdir=`mktemp`

rm -rf $tmpdir
mkdir -p $tmpdir
echo "Using temp directory $tmpdir"
pushd $tmpdir
cp $scriptdir/build/tmp/deploy/images/${machine}/$deployfile .
tar -xvf $deployfile
set -e
sudo ./initrd-flash
popd
echo "Removing temp directory $tmpdir"
rm -rf $tmpdir