#!/usr/bin/env bash
set -e
PROJECT_ROOT="$( cd "$( dirname "${BASH_SOURCE[0]}" )/.." && pwd )"
cd $PROJECT_ROOT

mvn install
adb kill-server
adb start-server
adb devices
adb install -r target/bitemoi-1.0-SNAPSHOT.apk
calabash-android run target/bitemoi-1.0-SNAPSHOT.apk
