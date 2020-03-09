#!/usr/bin/env bash

set -e

mvn clean package

DEPLOY_PATH=/root/deploy/auto_sign
#DEPLOY_PATH=/Users/xiaqiulei/deploy/auto_sign
rm -rf ${DEPLOY_PATH}

mkdir -p  ${DEPLOY_PATH}

cp target/*.jar ${DEPLOY_PATH}/auto_sign.jar
cp script/*.sh ${DEPLOY_PATH}
chmod +x ${DEPLOY_PATH}/*.sh