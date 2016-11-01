#!/bin/bash

echo $project

set -e -u -x

cd source-code/
./mvnw package
