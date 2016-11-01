#!/bin/bash

echo $project

set -e -u -x

cd source-code/$project
../mvnw package
