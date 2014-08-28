#!/bin/bash
cd /home/zhou/github/MobileLife
# You can change your current path by $. ./xx.sh
# There is a space between two points.

# You can update your code by $git pull

git add --all

{
if [ x$1 == x ] 
	then
    		git commit -m "This is an auto commit."
	else
    	while getopts m: option
	do
		case "$option" in
			m)
				git commit -m "$OPTARG";;
			?)
				echo "Arg Error.";;
		esac
	done
fi
}
git push https://zhoukekestar:password@github.com/zhoukekestar/MobileLife master

