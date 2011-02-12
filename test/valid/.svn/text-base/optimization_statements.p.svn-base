ssp 5
ujp program
function_main:
ssp 6
ldc i 5
str i 0 5
lod i 0 5
ldc i 6
les i
conv b i
ldc i 0
equ i
fjp IF_0_true
IF_0_false:
ujp IF_0_end
IF_0_true:
ujp COMPSTMNT_0_init
COMPSTMNT_0_body:
ssp 5
lod i 1 5
ldc i 1
add i
str i 1 5
ldc i 0
str i 0 0
retf
COMPSTMNT_0_return:
ldc i 1
str i 0 0
retf
COMPSTMNT_0_init:
mst 0
cup 0 COMPSTMNT_0_body
ldc i 1
neq i
fjp function_mainreturn
IF_0_end:
WHILE_0_check:
lod i 0 5
ldc i 10
les i
conv b i
ldc i 0
equ i
fjp WHILE_0_true
ujp WHILE_0_end
WHILE_0_true:
ujp COMPSTMNT_1_init
COMPSTMNT_1_body:
ssp 5
lod i 1 5
ldc i 1
add i
str i 1 5
ldc i 0
str i 0 0
retf
COMPSTMNT_1_return:
ldc i 1
str i 0 0
retf
COMPSTMNT_1_break:
lod a 0 4
inc a 12
str a 0 4
retp
COMPSTMNT_1_continue:
ldc i 0
str i 0 0
retf
COMPSTMNT_1_init:
mst 0
cup 0 COMPSTMNT_1_body
dpl i
dpl i
ldc i 1
neq i
fjp function_mainreturn
ldc i 2
neq i
fjp function_mainbreak
ldc i 3
neq i
fjp function_maincontinue
ujp WHILE_0_check
WHILE_0_end:
ldc i 0
str i 0 0
ujp function_mainreturn
function_mainreturn:
retf
program:
mst 0
cup 0 function_main
hlt
