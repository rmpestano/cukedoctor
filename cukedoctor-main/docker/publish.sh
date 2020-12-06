#!/bin/bash
docker build --build-arg VERSION=$1 -t rmpestano/cukedoctor ../ \
&& docker tag rmpestano/cukedoctor:latest rmpestano/cukedoctor:$1 \
&& docker push rmpestano/cukedoctor:$1 && docker push rmpestano/cukedoctor:latest