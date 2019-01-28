#!/bin/bash

echo "**************** start ****************"
if [ "$1" == "" ];then
	set "Default commit ,nothing !"
fi
git add -A .
git commit -am $1
git push origin master
echo "*******commit and push success !******"
