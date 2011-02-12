ssp 5
ujp program
function_main:
ssp 10
ldc c 0
ldc c 0
ldc c 0
ldc c 0
ldc c 0
str c 0 9
str c 0 8
str c 0 7
str c 0 6
str c 0 5
ldc c 'S'
out c
ldc c 'c'
out c
ldc c 'a'
out c
ldc c 'n'
out c
ldc c ' '
out c
ldc c 's'
out c
ldc c 't'
out c
ldc c 'r'
out c
ldc c 'i'
out c
ldc c 'n'
out c
ldc c 'g'
out c
ldc c '.'
out c
ldc c 10
out c
in c
str c 0 5
in c
str c 0 6
in c
str c 0 7
in c
str c 0 8
in c
str c 0 9
ldc c 'I'
out c
ldc c 'n'
out c
ldc c 'g'
out c
ldc c 'e'
out c
ldc c 'l'
out c
ldc c 'e'
out c
ldc c 'z'
out c
ldc c 'e'
out c
ldc c 'n'
out c
ldc c ' '
out c
ldc c 'S'
out c
ldc c 't'
out c
ldc c 'r'
out c
ldc c 'i'
out c
ldc c 'n'
out c
ldc c 'g'
out c
ldc c ':'
out c
ldc c ' '
out c
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
