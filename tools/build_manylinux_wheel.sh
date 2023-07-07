#!/usr/bin/env bash
#
# Must be run inside the manylinux docker container


set -e -x


working_dir="/tmp/python-package/"
dist_dir="dist/"
python_bin_version="cp3[7-9,10,11]*"

if [[ ${ARCH} = "arm64" ]]
then
  wheel_arch="aarch64"
elif [[ ${ARCH} = "x86_64" ]]
then
  wheel_arch=${ARCH}
fi

cd $working_dir


clean_up () {
  printf "Remove source wheels with common platform tag..."
  shopt -s extglob
  rm ${dist_dir}*-linux_*
}

change_owner () {
  printf "Return folder ownership to user..."
  chown -R ${USER_ID}:${GROUP_ID} ${working_dir}
}

exit_with_error () {
  >&2 printf "ERROR: $1"
  clean_up
  change_owner
  exit 1
}

compile_wheels () {
  printf "Compile wheels..."
  for pybin in /opt/python/${python_bin_version}/bin; do
       ${pybin}/python ${working_dir}/setup.py update_js bdist_wheel --dist-dir=${dist_dir} || exit_with_error "Could not build wheels for ${pybin}."
  done
}

audit_wheels () {
  printf "Make auditwheel..."
  for whl in ${dist_dir}lets_plot-*_${wheel_arch}.whl; do
      auditwheel repair "$whl" --plat ${PLAT} -w ${dist_dir} || exit_with_error "Could not make auditwheel for ${whl}."
  done
}


# Compile wheels:
compile_wheels || exit_with_error "Could not build wheels for ${PLAT}."
# Run auditwheel for compiled wheels:
audit_wheels || exit_with_error "Auditwheel failed for ${PLAT}."
# Remove source wheels and dependent libraries generated by pip wheel:
clean_up
# Change folder ownership back to user (Docker leaves mounted folders with root owner):
change_owner
printf "Finished for ${PLAT}"
exit 0
