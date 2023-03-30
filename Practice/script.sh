#! /bin/bash

#1. Creating a new file with name Assignment.txt with some sample content
cat <<EOF > Assignment.txt
Hi,
My name is Tushar Katiyar.
EOF

#Displaying file name
cat Assignment.txt

#2. Moving the file to /tmp directory 
mv Assignment.txt /tmp
cd /tmp

#3. FILE_PATH environment variable with absolute path of Assignment.txt as the value
export FILE_PATH=$(realpath Assignment.txt)

#4. Printing environment variable
echo $FILE_PATH