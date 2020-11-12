#!/bin/bash
curl -s --noproxy localhost -u'username:tomcat' http://localhost:8081/manager/text/list | grep /demo_fizz_buzz:running || exit 1
