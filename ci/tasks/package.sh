#!/bin/bash

echo $PROJECT

set -e -u -x

cd source-code/
./mvnw package
