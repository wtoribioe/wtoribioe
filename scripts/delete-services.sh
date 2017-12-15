#!/bin/bash
if [ "$1" == "delete" ]; then
    action="$1"
    echo "Deleting Services"
    for i in $( ls *.yml ); do
    	echo kubectl "$action" -f $i
    	kubectl "$action" -f $i
    done
else
    echo "Please pass an argument specifying the action delete."
        echo "Ex.  './create-services.sh delete"
        exit 1
fi

