ssp 5
ujp program
function_main:
ssp 10
ldc c 72
ldc c 97
ldc c 108
ldc c 108
ldc c 111
str c 0 9
str c 0 8
str c 0 7
str c 0 6
str c 0 5
lod c 0 5
out c
lod c 0 6
out c
lod c 0 7
out c
lod c 0 8
out c
lod c 0 9
out c
ldc i 0
str i 0 0
ujp function_mainreturn
function_mainreturn:
retf
program:
mst 0
cup 0 function_main
hlt
