#!/bin/bash
if [ "$1" == "create" ]; then
    action="$1"
    echo "Creating Pods"
    for i in $( ls *.yml ); do
    	echo kubectl "$action" -f $i
    	kubectl "$action" -f $i
    done
else
    echo "Please pass an argument specifying the action create."
        echo "Ex.  './create-pods.sh create"
        exit 1
fi

