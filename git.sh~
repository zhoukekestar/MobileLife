#!/bin/bash
cd /home/zhou/github/MobileYourLife
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
git push https://zhoukekestar:password@github.com/zhoukekestar/MobileYourLife master

