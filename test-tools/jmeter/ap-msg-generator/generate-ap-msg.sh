#!/bin/bash 

start_time=`date +%s`
start_time=`expr $start_time + 0`
echo START_TIME=`date -d@$start_time`

files=`ls msg-template`
for msg_file in $files
do 
 new_timestamp=`expr $start_time \* 1000`
 input_file=msg-template/$msg_file
 output_file=output/$msg_file
 echo "loading $input_file , output to $output_file"
 rm -rf $output_file

 while read line
 do
   #echo $line
   new_timestamp=`expr $new_timestamp + 25`
   new_line=${line/\"timestamp\":999999999999/\"timestamp\":$new_timestamp}
   echo $new_line >> $output_file

 done < $input_file
 
done

echo "Generating AP message completed."
