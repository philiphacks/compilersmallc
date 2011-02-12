ssp 5
ujp program
function_main:
ssp 7
ldc i 3
str i 0 5
lod i 0 5
str i 0 6
lod i 0 5
ldc i 3
equ i
conv b i
ldc i 0
equ i
not
lod i 0 5
lod i 0 6
equ i
conv b i
ldc i 0
equ i
not
and
conv b i
ldc i 0
equ i
fjp IF_0_true
IF_0_false:
ldc c 'D'
out c
ldc c 'e'
out c
ldc c ' '
out c
ldc c 'i'
out c
ldc c 'f'
out c
ldc c ' '
out c
ldc c 'c'
out c
ldc c 'o'
out c
ldc c 'n'
out c
ldc c 'd'
out c
ldc c 'i'
out c
ldc c 't'
out c
ldc c 'i'
out c
ldc c 'e'
out c
ldc c ' '
out c
ldc c 'i'
out c
ldc c 's'
out c
ldc c ' '
out c
ldc c 'f'
out c
ldc c 'a'
out c
ldc c 'l'
out c
ldc c 's'
out c
ldc c 'e'
out c
ldc c '!'
out c
IF_0_true:
ldc c 'D'
out c
ldc c 'e'
out c
ldc c ' '
out c
ldc c 'i'
out c
ldc c 'f'
out c
ldc c ' '
out c
ldc c 'c'
out c
ldc c 'o'
out c
ldc c 'n'
out c
ldc c 'd'
out c
ldc c 'i'
out c
ldc c 't'
out c
ldc c 'i'
out c
ldc c 'e'
out c
ldc c ' '
out c
ldc c 'i'
out c
ldc c 's'
out c
ldc c ' '
out c
ldc c 't'
out c
ldc c 'r'
out c
ldc c 'u'
out c
ldc c 'e'
out c
ldc c '!'
out c
IF_0_end:
retf
program:
mst 0
cup 0 function_main
hlt
