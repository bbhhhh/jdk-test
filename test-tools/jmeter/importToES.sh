#!/bin/bash

curl -s -u elastic:123456 -H "Content-Type: application/x-ndjson" -XPOST 135.251.218.218:9200/ap-ds-message/_bulk?pipeline=ap-ds-pipeline --data-binary "@wlanneighbor.itms88.log" &>period.out

curl -s -u elastic:123456 -H "Content-Type: application/x-ndjson" -XPOST 135.251.218.218:9200/ap-ds-message/_bulk?pipeline=ap-ds-pipeline --data-binary "@uplinkstatus.itms88.log" &>>period.out

curl -s -u elastic:123456 -H "Content-Type: application/x-ndjson" -XPOST 135.251.218.218:9200/ap-ds-message/_bulk?pipeline=ap-ds-pipeline --data-binary "@stainfo.itms88.log" &>>period.out 

curl -s -u elastic:123456 -H "Content-Type: application/x-ndjson" -XPOST 135.251.218.218:9200/ap-ds-message/_bulk?pipeline=ap-ds-pipeline --data-binary "@diagnose.itms88.log" &>diag.out 
