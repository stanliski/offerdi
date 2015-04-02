#! /bin/bash

if [ $# -ne 2 ]
then 
    echo "less two parameters"
    exit 0
fi

goal_dir=$1

time_scope=$2

find $goal_dir -type f -name "*.java" -mmin -$time_scope -print 

if [ $? -ne 0 ]
then 
    echo "run command error!"
fi
