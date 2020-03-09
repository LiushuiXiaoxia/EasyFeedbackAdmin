#!/bin/sh

# start.sh

#get pwd
DIR_HOME="${BASH_SOURCE-$0}"
DIR_HOME="$(dirname "$DIR_HOME")"
PKG_DIR="$(cd "${DIR_HOME}"; pwd)"

jarfile=${PKG_DIR}/app.jar

#create log dir
mkdir -p ${PKG_DIR}/logs/

nohup java -jar ${jarfile} -Dfile.encoding=UTF-8 --spring.profiles.active=prod > ${PKG_DIR}/logs/start.log 2>&1 &
pid=$(ps -ef | grep java | grep ${jarfile} | awk '{print $2}')
echo "INFO: $jarfile is running! pid=$pid"